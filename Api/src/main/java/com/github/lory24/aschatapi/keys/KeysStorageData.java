package com.github.lory24.aschatapi.keys;

import lombok.Getter;
import lombok.SneakyThrows;

import java.security.PrivateKey;
import java.security.PublicKey;

public class KeysStorageData {
    @Getter private final PublicKey publicKey;
    @Getter private final PrivateKey privateKey;

    @SneakyThrows
    public KeysStorageData(byte[] publicKeyBytes, byte[] privateKeyBytes) {
        this.publicKey = KeysUtils.publicKeyFromBytes(publicKeyBytes);
        this.privateKey = KeysUtils.privateKeyFromBytes(privateKeyBytes);
    }
}
