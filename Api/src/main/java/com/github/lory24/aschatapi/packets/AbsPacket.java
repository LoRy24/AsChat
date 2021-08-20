package com.github.lory24.aschatapi.packets;

import com.github.lory24.aschatapi.keys.KeysUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Getter;
import lombok.SneakyThrows;

import java.io.*;
import java.security.PublicKey;

public abstract class AbsPacket<T extends AbsPacket<T>> {
    @Getter private final int id;
    @Getter private T data;

    protected AbsPacket(int id) {
        this.id = id;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T readPacket(DataInputStream dataInputStream, Class<T> clazz) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
        Gson gson = new Gson();
        return gson.fromJson(bufferedReader.readLine(), clazz);
    }

    @SneakyThrows
    public void sendEncryptedPacket(DataOutputStream dataOutputStream,
                                    PublicKey othersPublic) {
        // Write the ID
        dataOutputStream.writeInt(id);
        // Write the data
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.excludeFieldsWithoutExposeAnnotation();
        Gson gson = gsonBuilder.create();
        dataOutputStream.write(KeysUtils.rsaEncryption(gson.toJson(this.data), othersPublic));
    }

    @SneakyThrows
    public void sendPacket(DataOutputStream dataOutputStream) {
        // Write the ID
        dataOutputStream.writeInt(id);
        // Write the data
        PrintWriter printWriter = new PrintWriter(dataOutputStream);
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.excludeFieldsWithoutExposeAnnotation();
        Gson gson = gsonBuilder.create();
        printWriter.print(gson.toJson(this.data));
        printWriter.flush();
        printWriter.close();
    }
}
