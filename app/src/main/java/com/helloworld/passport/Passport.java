package com.helloworld.passport;

import android.util.Log;
import android.view.SurfaceControl;

import com.helloworld.passport.util.Block;
import com.helloworld.passport.util.Identity;

import java.lang.reflect.Array;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Security;
import java.security.*;
import java.security.spec.ECGenParameterSpec;
import java.util.ArrayList;
import java.util.concurrent.TransferQueue;

public class Passport {
    public static ArrayList<Block> blockChain;
    public PublicKey publicKey;
    private PrivateKey privateKey;
    private ArrayList<Identity> VIDs;
    public KeyPair keyPair;


    public Passport(ArrayList<Block> currentBlockChain) {
        Security.insertProviderAt(new org.spongycastle.jce.provider.BouncyCastleProvider(), 1);
        VIDs = new ArrayList<Identity>();
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("ECDSA");
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            ECGenParameterSpec ecSpec = new ECGenParameterSpec("prime192v1");
            keyGen.initialize(ecSpec, random);
            keyPair = keyGen.generateKeyPair();
            this.privateKey = keyPair.getPrivate();
            this.publicKey = keyPair.getPublic();
        }catch(Exception e) {
            throw new RuntimeException(e);
        }

        this.blockChain = currentBlockChain;
    }

    public void printAllVIDs() {
        for(Identity identity: VIDs) {
            Log.e("Passport", identity.data);
        }
    }

    public void updateBlockChain(ArrayList<Block> newBlockChain) {
        this.blockChain = newBlockChain;
    }

    public void addNewId(Identity identity) {
        VIDs.add(identity);
        //If group leader
        //  Then add identity into block
        //Else
        //  Then send identity to group leader
    }

    public ArrayList<Identity> getVIDs() {
        return VIDs;
    }
}
