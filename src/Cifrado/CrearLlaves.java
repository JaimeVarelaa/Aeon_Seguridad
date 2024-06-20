package Cifrado;

import Logica.main;
import java.io.IOException;
import java.io.StringWriter;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemWriter;

/**
 *
 * @author juanm
 */
public class CrearLlaves {

    private PrivateKey privateKey;
    private PublicKey publicKey;

    public CrearLlaves() throws NoSuchAlgorithmException {
        // Añadir el proveedor de Bouncy Castle
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

        // Generar la clave privada y pública
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        KeyPair pair = keyGen.generateKeyPair();
        this.privateKey = pair.getPrivate();
        this.publicKey = pair.getPublic();
    }

    public String getPublicKeyPem() throws IOException {
        StringWriter publicKeyWriter = new StringWriter();
        try (PemWriter pemWriter = new PemWriter(publicKeyWriter)) {
            PemObject pemObject = new PemObject("PUBLIC KEY", publicKey.getEncoded());
            pemWriter.writeObject(pemObject);
        }
        return publicKeyWriter.toString();
    }

    public PublicKey getPublicKeyFromString(String publicKeyPEM) throws Exception {
        // Eliminar las cabeceras y pies de la clave PEM
        String publicKeyPEMFormatted = publicKeyPEM
                .replace("-----BEGIN PUBLIC KEY-----", "")
                .replace("-----END PUBLIC KEY-----", "")
                .replaceAll("\\s", "");

        // Decodificar la clave PEM desde Base64
        byte[] publicKeyBytes = Base64.getDecoder().decode(publicKeyPEMFormatted);

        // Crear un objeto X509EncodedKeySpec a partir de los bytes de la clave pública
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKeyBytes);

        // Crear el objeto PublicKey a partir del KeySpec
        PublicKey publicKey = java.security.KeyFactory.getInstance("RSA").generatePublic(keySpec);

        return publicKey;
    }

    public PublicKey getPublicKey() {
        return this.publicKey;
    }

    public PrivateKey getPrivateKey() {
        return this.privateKey;
    }

    public static String getPublicKeyString() {
        String publicKeyPem = null;
        try {
            CrearLlaves crearLlaves = new CrearLlaves();
            publicKeyPem = crearLlaves.getPublicKeyPem();
            main.datos.setPrivateKey(crearLlaves.getPrivateKey());
        } catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
        }
        return publicKeyPem;
    }
}
