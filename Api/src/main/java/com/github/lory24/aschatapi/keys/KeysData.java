package com.github.lory24.aschatapi.keys;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.SneakyThrows;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;

@SuppressWarnings("ResultOfMethodCallIgnored")
public class KeysData {
    private final File file;

    public KeysData(String dataFolderPath) {
        file = new File(dataFolderPath + "keys.data");
    }

    @SneakyThrows
    public void setupFile() {
        if (!file.exists()) {
            file.createNewFile();

            // generate the keys
            SecureRandom secureRandom = new SecureRandom();
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048, secureRandom);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();

            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.excludeFieldsWithoutExposeAnnotation();
            Gson gson = new Gson();
            KeysBytesGson keysBytesGson = new KeysBytesGson(keyPair.getPublic().getEncoded(), keyPair.getPrivate().getEncoded());
            String keysBytesJson = gson.toJson(keysBytesGson);

            FileWriter fileWriter = new FileWriter(file.getAbsolutePath());
            fileWriter.write(keysBytesJson);
            fileWriter.close();
        }
    }

    @SneakyThrows
    public KeysStorageData readKeys() {
        String fileContent = Files.readString(Paths.get(file.getAbsolutePath()));
        Gson gson = new Gson();
        KeysBytesGson keysBytesGson = gson.fromJson(fileContent, KeysBytesGson.class);
        return new KeysStorageData(keysBytesGson.getPublicKeyBytes(),
                keysBytesGson.getPrivateKeyBytes());
    }
}
