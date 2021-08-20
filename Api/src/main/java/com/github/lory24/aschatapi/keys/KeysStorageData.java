package com.github.lory24.aschatapi.keys;

import lombok.Getter;
import lombok.SneakyThrows;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.EncodedKeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class KeysStorageData {
    @Getter private final PublicKey publicKey;
    @Getter private final PrivateKey privateKey;

    @SneakyThrows
    public KeysStorageData(byte[] publicKeyBytes, byte[] privateKeyBytes) {
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");

        EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKeyBytes);
        this.publicKey = keyFactory.generatePublic(publicKeySpec);
        EncodedKeySpec privateKeySpec =
                new PKCS8EncodedKeySpec(privateKeyBytes);
        this.privateKey = keyFactory.generatePrivate(privateKeySpec);
    }
}
