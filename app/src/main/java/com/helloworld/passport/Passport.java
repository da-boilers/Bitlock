package com.helloworld.passport;

import com.helloworld.passport.util.Block;
import com.helloworld.passport.util.Identity;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;

public class Passport {
    public static ArrayList<Block> blockChain;
    public PublicKey publicKey;
    private PrivateKey privateKey;
    private ArrayList<Identity> VIDs;

    public Passport(PublicKey publicKey, PrivateKey privateKey, ArrayList<Block> currentBlockChain) {
        this.publicKey = publicKey;
        this.privateKey = privateKey;
        this.blockChain = currentBlockChain;
    }

    public void updateBlockChain(ArrayList<Block> newBlockChain) {
        this.blockChain = newBlockChain;
    }

    public ArrayList<Identity> getVIDs() {
        return null;
    }
}
