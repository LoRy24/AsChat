package com.github.lory24.aschatapi.keys;

import com.google.gson.annotations.Expose;

public class KeysBytesGson {
    @Expose private final byte[] publicKeyBytes;
    @Expose private final byte[] privateKeyBytes;

    public KeysBytesGson(byte[] publicKeyBytes, byte[] privateKeyBytes) {
        this.publicKeyBytes = publicKeyBytes;
        this.privateKeyBytes = privateKeyBytes;
    }

    public byte[] getPublicKeyBytes() {
        return publicKeyBytes;
    }

    public byte[] getPrivateKeyBytes() {
        return privateKeyBytes;
    }
}
