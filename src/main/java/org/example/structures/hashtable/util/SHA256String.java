package org.example.structures.hashtable.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256String {
    private String string;

    public SHA256String(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return string;
    }

    @Override
    public int hashCode() {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(string.getBytes(StandardCharsets.UTF_8));

            int hashInt = 0;
            for (int i = 0; i < Math.min(4, hashBytes.length); i++) {
                hashInt <<= 8;
                hashInt |= (hashBytes[i] & 0xFF);
            }

            return hashInt;

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
