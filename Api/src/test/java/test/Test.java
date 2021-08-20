package test;

import lombok.SneakyThrows;

import javax.xml.bind.DatatypeConverter;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;

public class Test {

    @SneakyThrows
    public static void main(String[] args) {
        SecureRandom secureRandom = new SecureRandom();
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048, secureRandom);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        System.out.println("Key:" + DatatypeConverter.printHexBinary(keyPair.getPublic().getEncoded()));
    }
}
