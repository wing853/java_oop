package server.ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerFile {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {

            Scanner scan = new Scanner(System.in);

            System.out.println("포트번호 8000번으로 서버 연결...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("클라이언트1 연결됨");
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter writer = new PrintWriter(new PrintWriter(clientSocket.getOutputStream()),true);

            while (true) {
                String message = reader.readLine();
                System.out.println("클라이언트 메세지: " + message);

                System.out.print("클라이언트에게 답장: ");
                String response = scan.nextLine();
                writer.println(response);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
