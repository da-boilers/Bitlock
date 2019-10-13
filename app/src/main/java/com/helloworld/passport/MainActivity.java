package com.helloworld.passport;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.helloworld.passport.util.Block;
import com.helloworld.passport.util.Identity;
import java.security.Security;
import java.util.ArrayList;
import java.util.HashMap;
import static com.helloworld.passport.R.id;
import static com.helloworld.passport.R.layout;

public class MainActivity extends AppCompatActivity {
    // Access a Cloud Firestore instance from your Activity
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private ArrayList<Block> currentBlockChain = new ArrayList<Block>();
    private Passport passport = new Passport(currentBlockChain);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        Security.insertProviderAt(new org.spongycastle.jce.provider.BouncyCastleProvider(), 1);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();
        }
    }

    public void completeIdentification(Block block) {
        db.collection("BLOCKCHAIN").document(Integer.toString(block.num)).set(block);
    }

    public void updateData() {
        DocumentReference docRef = db.collection("BLOCKCHAIN").document("TEST");
        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Block block = documentSnapshot.toObject(Block.class);
                currentBlockChain.add(block);
                System.out.println(isChainValid(currentBlockChain));
                System.out.println(currentBlockChain.get(0).hash);
            }
        });

    }

    public boolean isChainValid(ArrayList<Block> blockChain) {
        Block currentBlock;
        Block lastBlock;

        for(int i=1; i < blockChain.size(); i++) {
            currentBlock = blockChain.get(i);
            lastBlock = blockChain.get(i-1);

            if(!currentBlock.hash.equals(currentBlock.calculateHash())) {
                return false;
            }

            if(!currentBlock.previousHash.equals(blockChain.get(blockChain.size()-1).hash)) {
                return false;
            }

            for(Identity VID: currentBlock.vids) {
                if(!VID.verifySignature()) {
                    return false;
                }
            }
        }
        return true;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;
                    switch (menuItem.getItemId()) {
                        case R.id.nav_home:
                            selectedFragment = new HomeFragment();
                            break;
                        case id.nav_verify:
                            selectedFragment = new VerifyFragment();
                            break;
                        case id.nav_add:
                            selectedFragment = new AddFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }
            };
}