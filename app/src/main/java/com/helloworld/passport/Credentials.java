package com.helloworld.passport;

import java.util.ArrayList;
import java.util.HashMap;

public class Credentials {

    private HashMap<String, String> mHash;

    public Credentials(HashMap hm){
        mHash = hm;
    }

    public static ArrayList<HashMap<String, String>> createCredentialList(int numCreds){
        //ArrayList<HashMap<String, String>> Vids = new ArrayList<>();

        ArrayList<HashMap<String, String>> credentials = new ArrayList<>();
        double rand = Math.random();

        int counter = 0;
        for(int i = 0; i < numCreds; i++) {
            HashMap<String, String> hash = new HashMap<>();
            hash.put("IDTYPE", "Type" + counter);
            hash.put("Name", "Jack" + counter);
            hash.put("CPM", "1000" + counter);
            hash.put("Membership", " " + rand);
            credentials.add(hash);
            counter++;
        }

        return credentials;
    }

}
