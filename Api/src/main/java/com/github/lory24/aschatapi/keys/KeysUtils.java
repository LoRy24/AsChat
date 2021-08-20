package com.github.lory24.aschatapi.keys;

import lombok.SneakyThrows;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.PrivateKey;
import java.security.PublicKey;

public class KeysUtils {

    @SneakyThrows
    public static byte[] rsaEncryption(String s, PublicKey key) {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(s.getBytes(StandardCharsets.UTF_8));
    }

    @SneakyThrows
    public static String rsaDecryption(byte[] bytes, PrivateKey key) {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] result = cipher.doFinal(bytes);
        return new String(result);
    }
}
