/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hash;

/**
 *
 * @author juanm
 */
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.bouncycastle.crypto.digests.Blake2bDigest;
import org.bouncycastle.util.encoders.Hex;

public class Blake2 {
/**
 * 15
 */
    public static String getFileHashBlake2(File file) throws IOException {
        Blake2bDigest digest = new Blake2bDigest(512);
        Path filePath = file.toPath();
        byte[] fileBytes = Files.readAllBytes(filePath);
        digest.update(fileBytes, 0, fileBytes.length);
        byte[] hashBytes = new byte[digest.getDigestSize()];
        digest.doFinal(hashBytes, 0);
        return Hex.toHexString(hashBytes);
    }
}
