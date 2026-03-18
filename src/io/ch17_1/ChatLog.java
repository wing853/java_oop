package io.ch17_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class ChatLog {

    public static void main(String[] args) {

        System.out.println("===== 채팅 로그 저장소 =====");
        System.out.println("이름과 메세지를 입력하세요");
        System.out.println("형식: 이름>메세지    예) 홍길동>메세지");

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new FileWriter("chat_log.txt"))) {
            String line;
            while((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
                bw.flush();
            }

            System.out.println("채팅 로그가 저장 되었습니다");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
       

    }

}
