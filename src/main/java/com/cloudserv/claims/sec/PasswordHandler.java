package com.cloudserv.claims.sec;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class PasswordHandler {

    private String key;
    private String encryptedPassword;

    public PasswordHandler(String key, String encryptedPassword) {
        this.key = key;
        this.encryptedPassword = encryptedPassword;
    }

    public String handlePassword() throws NoSuchPaddingException,
            InvalidAlgorithmParameterException, NoSuchAlgorithmException, IllegalBlockSizeException,
            IOException, BadPaddingException, InvalidKeyException,
            InvalidKeySpecException {
        EncryptionUtils cryptoUtil = new EncryptionUtils();
        String plainAfter = cryptoUtil.decrypt(this.key, this.encryptedPassword);
        return plainAfter;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public String getKey() {
        return this.key;
    }

    public String getEncryptedPassword() {
        return this.encryptedPassword;
    }
}
