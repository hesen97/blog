package com.hesen.blog.util;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {

    public static String encode(String plaintext) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(plaintext.getBytes());
            byte[] digest = md5.digest();
            return DatatypeConverter.printHexBinary(digest).toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
