package test;

import com.github.lory24.aschatapi.keys.KeysData;
import com.github.lory24.aschatapi.keys.KeysStorageData;
import com.github.lory24.aschatapi.keys.KeysUtils;
import lombok.SneakyThrows;

import javax.xml.bind.DatatypeConverter;

public class Test {

    @SneakyThrows
    public static void main(String[] args) {
        KeysData keysData = new KeysData("");
        keysData.setupFile();
        KeysStorageData keysStorageData = keysData.readKeys();
        byte[] encrypted = KeysUtils.rsaEncryption("Hello World!", keysStorageData.getPublicKey());
        System.out.println("Encrypted: " + DatatypeConverter.printHexBinary(encrypted));
        System.out.println("Decrypted: " + KeysUtils.rsaDecryption(encrypted,
                keysStorageData.getPrivateKey()));
    }
}
