package com.helloworld.passport;

import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SetOptions;
import com.helloworld.passport.util.Block;
import com.helloworld.passport.util.Identity;
import com.helloworld.passport.util.StringUtil;

import java.security.spec.ECGenParameterSpec;
import java.security.*;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.opencensus.tags.Tag;

public class MainActivity extends AppCompatActivity {
    // Access a Cloud Firestore instance from your Activity
    FirebaseFirestore db = FirebaseFirestore.getInstance();


    private AppBarConfiguration mAppBarConfiguration;

    private Button discoverPeersBtn;
    private Button enableWifi;
    private TextView connectionStatus;
    private ListView listView;

    //private BlockChain currentBlockChain = new BlockChain(new ArrayList<Block>());
    private ArrayList<Block> currentBlockChain = new ArrayList<Block>();
    private Passport passport = new Passport(currentBlockChain);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Security.insertProviderAt(new org.spongycastle.jce.provider.BouncyCastleProvider(), 1);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        BlockChainTest();
        updateData();
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

    public void BlockChainTest() {
        //Passport passport = new Passport(blockChain.blockList);
        PublicKey orgKey;
        PublicKey rdmKey;

        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("ECDSA");
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            ECGenParameterSpec ecSpec = new ECGenParameterSpec("prime192v1");
            keyGen.initialize(ecSpec, random);
            KeyPair keyPair = keyGen.generateKeyPair();
            orgKey = keyPair.getPublic();
        } catch(Exception e) {
            throw new RuntimeException(e);
        }

        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("ECDSA");
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            ECGenParameterSpec ecSpec = new ECGenParameterSpec("prime192v1");
            keyGen.initialize(ecSpec, random);
            KeyPair keyPair = keyGen.generateKeyPair();
            rdmKey = keyPair.getPublic();
        } catch(Exception e) {
            throw new RuntimeException(e);
        }

        byte[] sig = {};
        Block block1 = new Block(new ArrayList<Identity>(), "0", 0);
        block1.addIdentity(new Identity(orgKey, passport.publicKey, sig, "data"));
        block1.addIdentity(new Identity(orgKey, rdmKey, sig, "data"));

        completeIdentification(block1);

        Block block2 = new Block(new ArrayList<Identity>(), block1.hash, block1.num+1);
        block1.addIdentity(new Identity(orgKey, passport.publicKey, sig, "data"));
        block1.addIdentity(new Identity(orgKey, rdmKey, sig, "data"));

        completeIdentification(block2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
