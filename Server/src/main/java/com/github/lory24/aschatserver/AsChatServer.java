package com.github.lory24.aschatserver;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.util.Locale;

public class AsChatServer {

    public static final int SERVER_PORT = 45656;

    @SneakyThrows
    protected void runServer() {
        ServerSocket serverSocket = new ServerSocket(SERVER_PORT);

        System.out.print("\rServer started! Listening on port " + serverSocket.getLocalPort() + "\n");

        // Start listening
        Thread listeningThread = new Thread(() -> {
            while (true);
        });
        listeningThread.start();

        while (true) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print(">> ");
            String exc = bufferedReader.readLine();
            if (exc.toLowerCase(Locale.ROOT).equals("exit")) break;
        }
    }

    public void log(LogSeverity logSeverity, Object o, boolean replace) {
        System.out.print((replace ? "\r" : "") + "[" + logSeverity.toString() + "] " + o + "\n>>");
    }
}
