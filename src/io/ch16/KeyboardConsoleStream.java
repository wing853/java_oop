package io.ch16;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * 바이트 단위 스트림 이름 형태: InputStream, OutputStream
 * 문자 기반 스트림 이름 형태: xxxReader, xxxWriter
 */
public class KeyboardConsoleStream {

    public static void main(String[] args) {
        /**
         * InputStreamReader의 read()는 하나의 문자를 읽어서
         * 유니코드(정수값)로 변환합니다.
         * PrintWriter은 문자 기반의 출력 스트림
         * System.out은 콘솔 출력
         */

        // 키보드에서 값을 읽어보기
        try (InputStreamReader reader = new InputStreamReader(System.in)) {

            PrintWriter writer = new PrintWriter(System.out, true);
            System.out.println("텍스트를 입력하세요(종료는 Ctrl + D)");
            System.out.println("-----------------------------");
            int charCode;
            // 개행문자로 종료 구분
            while ((charCode = reader.read()) != -1) {
                writer.print((char) charCode);
            }
            writer.flush(); // 버퍼 남은 데이터 즉시 출력


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    } // end of main

}
