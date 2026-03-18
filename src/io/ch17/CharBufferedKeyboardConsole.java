package io.ch17;


import java.io.*;

/**
 *  스트림체인 구조
 *  [키보드]
 *      System.in(InputStream)
 *      InputStreamReader(브릿지)
 *      BufferedReda (버퍼 + readLine() 추가)
 *
 *  [프로그램] -> 출력
 *      BufferedWrite(버퍼 + newLine() 추가)
 *      PrintWriter
 *      System.out(PrintWriter) - 콘솔창에 출력
 *
 */


public class CharBufferedKeyboardConsole {

    public static void main(String[] args) throws IOException {

        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        //BufferedWriter bw = new BufferedWriter(new PrintWriter(System.out));
        PrintWriter pw = new PrintWriter(System.out);
        BufferedWriter bw = new BufferedWriter(pw);

        // 콘솔창의 종료 명령은 (CTRL + D)
        System.out.println("텍스트를 입력하세요 (종료: 빈 줄 입력)");

        String line;

        while((line = br.readLine()) != null) {
            bw.write("받은값 출력: " + line);
            // \n <-- Linux, mac
            // \r\n <-- window
            bw.newLine(); // 운영체제에 맞는 줄바꿈 자동 삽입
            bw.flush(); // 버퍼에 남은데이터 즉시 출력
        }

    } // end of main

}
