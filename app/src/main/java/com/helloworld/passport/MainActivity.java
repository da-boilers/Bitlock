package com.helloworld.passport;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.os.TransactionTooLargeException;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.helloworld.passport.util.Block;
import com.helloworld.passport.util.DataParserTest;
import com.helloworld.passport.util.Identity;
import java.security.spec.ECGenParameterSpec;
import java.security.*;
import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;

import java.lang.reflect.Array;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.ECGenParameterSpec;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    private ArrayList<Block> currentBlockchain = new ArrayList<Block>();

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

        DataParserTest.runTest();

        Passport passport = new Passport(currentBlockchain);
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
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("EC");
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            ECGenParameterSpec ecSpec = new ECGenParameterSpec("prime192v1");
            keyGen.initialize(ecSpec, random);
            KeyPair keyPair = keyGen.generateKeyPair();
            rdmKey = keyPair.getPublic();
        } catch(Exception e) {
            throw new RuntimeException(e);
        }

        byte[] sig = {};
        ArrayList<Identity> idList = new ArrayList<Identity>();
        idList.add(new Identity(orgKey, passport.publicKey, sig, "data"));
        passport.addNewId(new Identity(orgKey, passport.publicKey, sig, "data"));
        idList.add(new Identity(orgKey, rdmKey, sig, "data"));

        currentBlockchain.add(new Block(idList, "0"));

        idList.add(new Identity(orgKey, passport.publicKey, sig, "data 2"));
        passport.addNewId(new Identity(orgKey, passport.publicKey, sig, "data 2"));
        idList.add(new Identity(orgKey, passport.publicKey, sig, "data 3"));
        passport.addNewId(new Identity(orgKey, passport.publicKey, sig, "data 3"));

        currentBlockchain.add(new Block(idList, currentBlockchain.get(0).hash));

        passport.updateBlockChain(currentBlockchain);
        passport.printAllVIDs();
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
