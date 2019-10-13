package com.helloworld.passport.util;

import java.security.PublicKey;

public class Identity {
    public PublicKey organization;
    public PublicKey user;
    public byte[] organizationSig;
    public String data;

    public Identity(PublicKey organization, PublicKey user, byte[] organizationSig, String data) {
        this.organization = organization;
        this.organizationSig = organizationSig;
        this.user = user;
        this.data = data;
    }

    public boolean verifySignature(){
        String info = StringUtil.getStringFromKey(organization) + StringUtil.getStringFromKey(user) + data;
        return StringUtil.verifyECDSASig(organization, info, organizationSig);
    }
}