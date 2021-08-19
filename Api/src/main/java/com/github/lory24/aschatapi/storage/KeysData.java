package com.github.lory24.aschatapi.storage;

import com.github.lory24.aschatapi.keys.KeysIdentity;
import lombok.SneakyThrows;

import java.io.File;

@SuppressWarnings("ResultOfMethodCallIgnored")
public class KeysData {
    private final File file;

    public KeysData(String dataFolderPath) {
        file = new File(dataFolderPath + "/keys.data");
    }

    @SneakyThrows
    public void setupFile() {
        if (!file.exists()) file.createNewFile();

    }

    public KeysIdentity readKeys() {
        return null;
    }
}
