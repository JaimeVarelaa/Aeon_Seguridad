package Hash;

import Logica.main;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import javax.crypto.Cipher;

public class Encriptar {

    /**
     * 12
     */
    public static String encryptStringWithPublicKey(String input) throws Exception {
        String publicKeyPEM = main.datos.getPublicKey();
        publicKeyPEM = publicKeyPEM
                .replace("-----BEGIN PUBLIC KEY-----", "")
                .replace("-----END PUBLIC KEY-----", "")
                .replaceAll("\\s", "");

        byte[] publicKeyBytes = java.util.Base64.getDecoder().decode(publicKeyPEM);

        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKeyBytes);

        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(keySpec);

        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);

        byte[] inputBytes = input.getBytes("UTF-8");

        byte[] encryptedBytes = cipher.doFinal(inputBytes);

        return java.util.Base64.getEncoder().encodeToString(encryptedBytes);
    }

    /**
     * 13 
     */
    public static String decryptStringWithPrivateKey(String encryptedInput) throws Exception {
        PrivateKey privateKey = main.datos.getPrivateKey();
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);

        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedInput);

        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

        return new String(decryptedBytes, "UTF-8");
    }
}
