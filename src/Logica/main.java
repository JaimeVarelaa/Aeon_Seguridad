package Logica;

import GUI.Ask;
import GUI.MainGUI;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;

public class main {

    public static void main(String[] args) {
        MainGUI.MainGUI();
        startListener();
    }

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

    private static void handleClient(Socket clientSocket) {
        try (InputStream input = clientSocket.getInputStream(); BufferedReader reader = new BufferedReader(new InputStreamReader(input)); OutputStream output = clientSocket.getOutputStream(); PrintWriter writer = new PrintWriter(output, true)) {
            String clientMessage = reader.readLine();
            System.out.println("Mensaje recibido: " + clientMessage);
            String respuesta = Ask.askPanel(clientSocket.getInetAddress().toString());
            writer.println(respuesta);
            System.out.println("Respuesta enviada: " + respuesta);

        } catch (IOException e) {
            System.out.println("Error en la conexion: " + e.getMessage());
        }
    }

}
