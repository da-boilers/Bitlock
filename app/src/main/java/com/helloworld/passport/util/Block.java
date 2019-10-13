package com.helloworld.passport.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Block {
    public String hash;
    public String previousHash;
    public ArrayList<Identity> vids = new ArrayList<Identity>();
    public long timeStamp;
    public int num;

    public Block(){}

    public Block(ArrayList<Identity> vids, String previousHash, int num) {
        this.vids = vids;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();
        this.num = num;
    }

    public String calculateHash() {
        String calculatedhash = StringUtil.applySha256(
                previousHash +
                      Long.toString(timeStamp) +
                      StringUtil.toString(vids)
        );
        return calculatedhash;
    }

    public int getnum() {
        return num;
    }

    public void setnum(int num) {
        this.num = num;
    }


    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public ArrayList<Identity> getVids() {
        return vids;
    }

    public void setvids() {
        this.vids = vids;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp() {
        this.timeStamp = timeStamp;
    }


    /*public HashMapArrayList<> getContent() {
        HashMap<String, HashMap<String, String>> outerContent = new HashMap<String, HashMap<String, String>>();
        for(Identity VID: VIDs) {
            HashMap<String, String> innerContent = new HashMap<String, String>();
            innerContent.put("data", VID.data);
            innerContent.put("providerKey", StringUtil.getStringFromKey(VID.organization));
            innerContent.put("signature", VID.organizationSig.toString());
            outerContent.put(StringUtil.getStringFromKey(VID.user), innerContent);
        }
        return outerContent;
    }*/

    public void addIdentity(Identity identity) {
        vids.add(identity);
    }
}
