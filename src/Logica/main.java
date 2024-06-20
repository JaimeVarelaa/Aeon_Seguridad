package Logica;

import GUI.Ask;
import GUI.MainGUI;
import GUI.PseudoChat;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class main {

    public static Datos datos = new Datos();

    public static void main(String[] args) {
        MainGUI.MainGUI();
        startListener();
    }

    /**
     * 1
     */
    public static void startListener() {
        int port = 1234;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Puerto: " + port);
            while (true) {
                try {
                    Socket clientSocket = serverSocket.accept();
                    handleClient(clientSocket);
                } catch (IOException e) {
                    System.out.println("Error en conexion: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Error iniciando: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 2
     */
    private static void handleClient(Socket clientSocket) {
        try (InputStream input = clientSocket.getInputStream(); BufferedReader reader = new BufferedReader(new InputStreamReader(input)); OutputStream output = clientSocket.getOutputStream(); PrintWriter writer = new PrintWriter(output, true)) {
            String clientMessage = reader.readLine();

            if (clientMessage.contains("Inicio")) {
                clientMessage = clientMessage.replace("Inicio", "").trim();
                System.out.println("Inicio recibido: " + clientMessage);
                String respuesta = Ask.askPanel(clientSocket.getInetAddress().toString());
                writer.println(respuesta);
                System.out.println("Respuesta enviada: " + respuesta);
                datos.setIp(clientSocket.getInetAddress().toString());
                datos.setMac(clientMessage);
                datos.setPublicKey(respuesta);
            } else if (clientMessage.contains("SHA384")) {
                clientMessage = clientMessage.replace("SHA384", "").trim();
                System.out.println("SHA384 recibido: " + clientMessage);
                datos.setSha384(clientMessage);
            } else if (clientMessage.contains("SHA512")) {
                clientMessage = clientMessage.replace("SHA512", "").trim();
                System.out.println("SHA512 recibido: " + clientMessage);
                datos.setSha512(clientMessage);
            } else if (clientMessage.contains("Blake2")) {
                clientMessage = clientMessage.replace("Blake2", "").trim();
                System.out.println("Blake2 recibido: " + clientMessage);
                datos.setBlake2(clientMessage);
            } else if (clientMessage.contains("Size")) {
                clientMessage = clientMessage.replace("Size", "").trim();
                System.out.println("Size recibido: " + clientMessage);
                long size = Long.parseLong(clientMessage.trim());
                datos.setArchivoSize(size);
            } else if (clientMessage.contains("File")) {
                System.out.println("Es un archivo");
                receiveFile(clientSocket, clientMessage.replace("File", "").trim());
            }
        } catch (IOException e) {
            System.out.println("Error en la conexion: " + e.getMessage());
        }
    }

    /**
     * 3 
     */
    private static void receiveFile(Socket clientSocket, String fileName) {
        try (
                InputStream input = clientSocket.getInputStream(); FileOutputStream fileOutput = new FileOutputStream(fileName)) {

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = input.read(buffer)) != -1) {
                fileOutput.write(buffer, 0, bytesRead);
            }

            System.out.println("Archivo recibido correctamente: " + fileName);

            File receivedFile = new File(fileName);

            datos.setArchivo(receivedFile);
            Logica.Comprobador.comprobar(datos);

        } catch (IOException e) {
            System.out.println("Error al recibir el archivo: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
