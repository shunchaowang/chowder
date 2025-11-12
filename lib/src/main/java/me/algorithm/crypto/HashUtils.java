package me.algorithm.crypto;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class HashUtils {


  public static void main(String[] args) {

    Mac mac = null;
    SecretKeySpec signingKey = new SecretKeySpec("world".getBytes(), "HmacSHA1");
    try {
      mac = Mac.getInstance("HmacSHA1");
      mac.init(signingKey);
    } catch (NoSuchAlgorithmException | InvalidKeyException e) {
      e.printStackTrace();
    }

    String hmacToSign = "hello";
    System.out.println("hmacToSign = " + hmacToSign);
    String hmacSigned = new String(Base64.getEncoder().encode(mac.doFinal(hmacToSign.getBytes())));

    System.out.println("hamcSigned = " + hmacSigned);
  }
}
