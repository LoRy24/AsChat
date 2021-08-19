package com.github.lory24.aschatapi.keys;

public class KeysIdentity {
    private final Key publicKey;
    private final Key privateKey;

    public KeysIdentity(Key publicKey, Key privateKey) {
        this.publicKey = publicKey;
        this.privateKey = privateKey;
    }

    public Key getPublicKey() {
        return publicKey;
    }

    public Key getPrivateKey() {
        return privateKey;
    }
}
