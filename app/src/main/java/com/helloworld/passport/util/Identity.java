package com.helloworld.passport.util;

import java.security.PublicKey;
import java.security.Signature;
import java.util.HashMap;
import java.util.Map;

import static com.helloworld.passport.util.StringUtil.getPublicKeyFromString;
import static com.helloworld.passport.util.StringUtil.getStringFromKey;

public class Identity {
    public String organization;
    public String user;
    public String organizationSig;
    public String data;

    public Identity() {}

    public Identity(PublicKey organization, PublicKey user, byte[] organizationSig, String data) {
        this.organization = getStringFromKey(organization);
        this.organizationSig = organizationSig.toString();
        this.user = getStringFromKey(user);
        this.data = data;
    }

    public boolean verifySignature(){
        String info = organization + user + data;
        return StringUtil.verifyECDSASig(getPublicKeyFromString(organization), info, organizationSig.getBytes());
    }

    /*public HashMap<String, HashMap<String, String>> getVIDTable() {
        HashMap<String, HashMap<String, String>> outerContent = new HashMap<String, HashMap<String, String>>();
        HashMap<String, String> innerContent = new HashMap<String, String>();
        innerContent.put("data", data);
        innerContent.put("providerKey", organization);
        innerContent.put("signature", organizationSig.toString());
        outerContent.put(user, innerContent);
        return outerContent;
    }*/

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getOrganizationSig() {
        return organizationSig;
    }

    public void setOrganizationSig(String organizationSig) {
        this.organizationSig = organizationSig;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
