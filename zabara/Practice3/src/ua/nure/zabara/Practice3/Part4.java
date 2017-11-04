package ua.nure.zabara.Practice3;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Part4 {

    public static String hash(String getHashOf, String algorithm) throws NoSuchAlgorithmException {
        StringBuilder sb = new StringBuilder();
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        digest.update(getHashOf.getBytes(Charset.forName("UTF-8")));
        byte[] hash = digest.digest();

        for (int i = 0; i < hash.length; i++) {
            String str = Integer.toHexString(0xFF & hash[i]);
            if (str.length() == 1) {
                sb.append("0");
            }
            sb.append(str);
        }
        return sb.toString().toUpperCase();
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(hash("p", "SHA-256"));
    }
}