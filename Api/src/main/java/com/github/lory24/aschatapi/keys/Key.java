package com.github.lory24.aschatapi.keys;

import lombok.Getter;

public class Key {
    @Getter private final KeyType keyType;
    @Getter private final String key;

    public Key(KeyType keyType, String key) {
        this.keyType = keyType;
        this.key = key;
    }
}
