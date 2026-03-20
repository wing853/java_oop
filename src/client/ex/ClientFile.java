package client.ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientFile {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try (Socket socket = new Socket("localhost", 8000)) {

            PrintWriter writer = new PrintWriter(new PrintWriter(socket.getOutputStream()),true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            while (true) {
                System.out.print("서버에 보낼 문자를 입력하세요: ");
                String message = scan.nextLine();
                writer.println(message);

                String response = reader.readLine();
                System.out.println("서버 응답: " + response);
            }

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    } // end of main

}
