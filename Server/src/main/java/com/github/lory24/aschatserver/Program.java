package com.github.lory24.aschatserver;

import lombok.Getter;
import lombok.SneakyThrows;

public class Program {

    @Getter public static AsChatServer server;

    @SneakyThrows
    public static void main(String[] args) {
        System.out.print("Starting server... Please wait 3s");
        Thread.sleep(3000);

        server = new AsChatServer();
        server.runServer();

        System.out.println("Bye!");
        System.exit(0);
    }
}
