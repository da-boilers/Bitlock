package com.helloworld.passport.util;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Block {
    public String hash;
    public String previousHash;
    private ArrayList<Identity> VIDs = new ArrayList<Identity>();
    private long timeStamp;

    public Block(ArrayList<Identity> VIDs, String previousHash) {
        this.VIDs = VIDs;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();
    }

    public String calculateHash() {
        String calculatedhash = StringUtil.applySha256(
                previousHash +
                      Long.toString(timeStamp) +
                      StringUtil.toString(VIDs)
        );
        return calculatedhash;
    }

    public void addIdentity(Identity identity) {
        VIDs.add(identity);
    }
}
