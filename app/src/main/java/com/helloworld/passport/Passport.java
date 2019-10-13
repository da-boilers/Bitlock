package com.helloworld.passport;

import android.util.Log;

import com.helloworld.passport.util.Block;
import com.helloworld.passport.util.Identity;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.ECGenParameterSpec;
import java.util.ArrayList;

public class Passport {
    public static ArrayList<Block> blockChain;
    public PublicKey publicKey;
    private PrivateKey privateKey;
    private ArrayList<Identity> VIDs;

    public Passport(ArrayList<Block> currentBlockChain) {
        VIDs = new ArrayList<Identity>();
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("ECDSA");
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            ECGenParameterSpec ecSpec = new ECGenParameterSpec("prime192v1");
            keyGen.initialize(ecSpec, random);
            KeyPair keyPair = keyGen.generateKeyPair();
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