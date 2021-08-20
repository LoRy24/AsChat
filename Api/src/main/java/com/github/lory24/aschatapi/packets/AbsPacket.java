package com.github.lory24.aschatapi.packets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Getter;
import lombok.SneakyThrows;

import java.io.DataOutputStream;
import java.io.PrintWriter;

public abstract class AbsPacket<T extends Class<T>> {
    @Getter private final int id;
    @Getter private T data;

    protected AbsPacket(int id) {
        this.id = id;
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
        printWriter.print(gson.toJson(dataOutputStream));
        printWriter.flush();
        printWriter.close();
    }
}
