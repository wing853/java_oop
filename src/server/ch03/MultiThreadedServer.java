package server.ch03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadedServer {

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(5000)) {

            System.out.println("클라이언트에 연결 요청을 기다립니다...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("========== 서버 실행 ==========");

            // 소캣과 연결된 스트림
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

            // 키보드와 연결할 스트림
            BufferedReader keyboardReader = new BufferedReader(new InputStreamReader(System.in));

            //  읽기 스레드: 클라이언트 메세지를 계속 수신
            Thread readThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        String clientMessage;
                        while ((clientMessage = reader.readLine()) != null) {
                            if ("exit".equalsIgnoreCase(clientMessage)) {
                                System.out.println("클라이언트가 종료했습니다.");
                                break;
                            }
                            System.out.println("클라이언트 메세지> " + clientMessage);
                        }
                    } catch (IOException e) {
                        System.err.println("클라이언트와 연결이 끊겼습니다");
                    }
                }
            });

            // 쓰기스레드: 키보드 입력을 받아 클라이언트에게 전송
            Thread writeThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        String serverMessage;
                        while ((serverMessage = keyboardReader.readLine()) != null) {
                            writer.println(">>>" + serverMessage);
                            if ("exit".equalsIgnoreCase(serverMessage)) {
                                System.out.println("서버가 종료 했습니다.");
                                break;
                            }
                        }

                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });

            readThread.start(); // 읽기 스레드 시작
            writeThread.start(); // 쓰기 스레드 시작

            readThread.join(); // 읽기 스레드가 종료까지 대기
            writeThread.join(); // 쓰기 스레드가 종료까지 대기

            /**
             * join() = 이 스레드가 끝날때 까지 기다리라는 의미
             * Thread.sleep()이 N초 동안 잠깐 멈춘다 하면
             * join()은 해당 스레드가 끝날 때 까지 멈춘다.
             *
             * join()이 없으면 main 스레드가 try블록을 벗어남
             * socket 자동 close
             * 아직 실행중인 readThread/writeThread가 닫힌 소캣으로 통신 시도... 예외 발생
             */

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    } // end of main

} // end of class
