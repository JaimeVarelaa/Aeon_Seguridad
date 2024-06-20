package GUI;

import javax.swing.*;
import java.awt.*;
import java.io.StringWriter;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.util.Base64;

public class JuanitoBonito {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                createAndShowGUI();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private static void createAndShowGUI() throws Exception {
        JFrame frame = new JFrame("Salida del Comando");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);

        frame.setVisible(true);

        String commandOutput = generateRSAKey();
        textArea.setText(commandOutput);
    }

    private static String generateRSAKey() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048); // Puedes cambiar el tamaño de la clave si lo deseas
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();

        // Convertir la clave privada a formato PEM
        StringWriter sw = new StringWriter();
        sw.write("-----BEGIN PRIVATE KEY-----\n");
        sw.write(Base64.getEncoder().encodeToString(privateKey.getEncoded()));
        sw.write("\n-----END PRIVATE KEY-----\n");

        return sw.toString();
    }
}
