package sockets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) {
        try {
            System.out.println("Server started");
            ServerSocket socketServer = new ServerSocket(1234);
            Socket client = socketServer.accept();
            System.out.println("Client is now connected");
            Scanner scanner = new Scanner(client.getInputStream());
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
            PrintWriter clientWriter = new PrintWriter(client.getOutputStream());
            clientWriter.println("Hello back");
            clientWriter.close();

            Thread.sleep(10000);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
