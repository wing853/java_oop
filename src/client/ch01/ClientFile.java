package client.ch01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientFile {

    public static void main(String[] args) {

        // 클라이언트는 접근할 서버 컴퓨터의 IP주소와 포트 번호를 알고 있어야 한다.
        try (Socket socket = new Socket("localhost", 5000)) {
            // Socket socket = new Socket("localhost", 5000)
            // 위 코드가 실행되는 순간 내부적으로 이미 서버 컴푸터와 연결을 시도한 상태
            PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);
            //writer.write("Hello Server~~" + "\n"); // 개행 문자까지 보내야 정상 보내짐
            writer.println("가나다");
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    } // end of main

}
