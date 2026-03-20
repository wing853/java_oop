package server.ch01;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SeverFile {

    public static void main(String[] args) {
        // 소캣 통신을 하기 위한 서버측 테스트 코드 1
        // (내 IP 주소는 당연히 알고 있음)
        // 포트 번호를 열고  클라이언트에 연결 요청을 기다리는 서버소캣
        // IP: 192.168.7.211
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            // accept() -> 클라이언트가 연결 할 때 까지 이 줄에서 멈춤(블로킹 상태)
            Socket clientSocket = serverSocket.accept();
            // 1. 코드가 아래로 안내려감
            System.out.println("클라이언트가 연결 되었습니다.");

            // 2. 소캣 객체가 생성되면 (accept())이 소켓이 클라이언스 소캣과 연결되어 있는 소캣
            // I/O 단원에서 배운 체인 그대로
            InputStream input = clientSocket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            // 클라이언트가 보낸 한 줄을 읽음
            String message = reader.readLine();
            // 내 서버측 콘솔창에 출력
            System.out.println("클라이언트 메세지: " + message);

            clientSocket.close();

        } catch (IOException e) {
            System.out.println("오류 발생: 포트 5000번이 이미 사용 중이거나 연결에 실패했습니다.");
        }
    } // end of main

}
