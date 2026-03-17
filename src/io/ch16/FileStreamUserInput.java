package io.ch16;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Scanner;

public class FileStreamUserInput {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("1. 파일 쓰기");
        System.out.println("2. 파일 읽기");
        System.out.print("선택:");
        String input = scanner.nextLine();

        if(input.equals("1")){
            writeUserInputToFile("user_input.txt");
        } else if (input.equals("2")) {
            readFromFile("user_input.txt");
        }

    } // end of main

    public static void writeUserInputToFile(String fileName) {
        /**
         * 키보드 입력 -> InputStreamReader(System.in) (바이트 -> 문자 변환)
         * 파일에 쓰기 -> FileWriter(fileName)         (문자기반  파일 출력)
         */

        try (InputStreamReader reader = new InputStreamReader(System.in);
             FileWriter writer = new FileWriter(fileName, true)) {

            System.out.println("텍스트를 입력하세요(종료: Ctrl + D)");
            // 1. 사용자가 입력한 값을 받기
            int charCode;
            while ((charCode = reader.read()) != -1) {
                writer.write(charCode);
                // 문자 하나 받을때마다 즉시 파일에 저장
                writer.flush();
            }

            System.out.println(fileName + "에 텍스트를 모두 작성함");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    } // end of writeUserInputToFile

    public static void readFromFile(String fileName) {
        //... 파일에 내용을 문자 기반으로 읽어서 콘솔창에 출력
        try (FileReader reader = new FileReader(fileName)) {
            int charCode;
            while((charCode = reader.read()) != -1) {
                System.out.print((char) charCode);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
