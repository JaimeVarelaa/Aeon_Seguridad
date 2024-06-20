/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import static Hash.Encriptar.decryptStringWithPrivateKey;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jaime
 */
public class Comprobador {

    /**
     * 17
     */
    public static void comprobar(Datos datos) {
        try {
            String blake21 = datos.getBlake2();
            String blake22 = Hash.Blake2.getFileHashBlake2(datos.getArchivo());
            System.out.println(blake21);
            System.out.println(blake22);
            if (blake21.equals(blake22)) {
                System.out.println("Blake2 coincide :)");
            } else {
                JOptionPane.showMessageDialog(null, "Blake2 no coincide", "Comunicación alterada", JOptionPane.ERROR_MESSAGE);
                //Files.delete(datos.getArchivo().toPath());
            }

            File archivo = datos.getArchivo();

            System.out.println(datos.getArchivoSize() + "  /  " + datos.getArchivo().length());

            try {
                FileInputStream fis = new FileInputStream(archivo);
                RandomAccessFile raf = new RandomAccessFile(archivo, "r");
                raf.seek(datos.getArchivoSize());
                StringBuilder contenido = new StringBuilder();
                int byteLeido;
                while ((byteLeido = raf.read()) != -1) {
                    System.out.print((char) byteLeido);
                    contenido.append((char) byteLeido);
                }
                raf.close();
                fis.close();

                String contenidoString = contenido.toString();
                System.out.println("Encriptado " + contenidoString);

                if (datos.getSha512().equals(Hash.SHA512.getStringHash512(contenidoString))) {
                    System.out.println("SHA512 coincide :)");
                } else {
                    JOptionPane.showMessageDialog(null, "SHA512 no coincide", "Comunicación alterada", JOptionPane.ERROR_MESSAGE);
                    //Files.delete(datos.getArchivo().toPath());
                }

                String mensaje = decryptStringWithPrivateKey(contenidoString);
                System.out.println("Mensaje Original " + mensaje);

                if (datos.getSha384().equals(Hash.SHA384.getStringHash384(mensaje))) {
                    System.out.println("SHA384 coincide :)");
                    JOptionPane.showMessageDialog(null, mensaje, "Ok", JOptionPane.WARNING_MESSAGE);
                    Files.delete(datos.getArchivo().toPath());
                } else {
                    JOptionPane.showMessageDialog(null, "SHA384 no coincide", "Comunicación alterada", JOptionPane.ERROR_MESSAGE);
                    //Files.delete(datos.getArchivo().toPath());
                }

            } catch (IOException e) {
                e.printStackTrace();
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(Comprobador.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(Comprobador.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
