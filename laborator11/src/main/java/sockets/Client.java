package sockets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {
        System.out.println("Client started");
        Socket socket = new Socket("localhost",1234);
        PrintWriter pr = new PrintWriter(socket.getOutputStream());
        pr.println("Hello");
        pr.close();
        Scanner scanner = new Scanner(socket.getInputStream());
        while (scanner.hasNext()) {
            System.out.println(scanner.nextLine());
        }
    }
}
