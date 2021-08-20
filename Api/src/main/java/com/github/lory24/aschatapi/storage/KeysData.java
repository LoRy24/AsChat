package com.github.lory24.aschatapi.storage;

import com.google.gson.Gson;
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
        file = new File(dataFolderPath + "/keys.data");
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
            System.out.println("Generated public key: " + keyPair.getPublic().toString());

            Gson gson = new Gson();
            String keyPairJson = gson.toJson(keyPair);
            System.out.println(keyPairJson);

            FileWriter fileWriter = new FileWriter(file.getAbsolutePath());
            fileWriter.write(keyPairJson);
            fileWriter.close();
        }
    }

    @SneakyThrows
    public KeyPair readKeys() {
        String fileContent = Files.readString(Paths.get(file.getAbsolutePath()));
        Gson gson = new Gson();
        return gson.fromJson(fileContent, KeyPair.class);
    }
}
