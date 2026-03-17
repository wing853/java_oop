package io.ch15_1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Scores {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("시험 점수 저장소");
        System.out.println("1. 점수 저장");
        System.out.println("2. 결과 분석");
        String choice = scan.nextLine();

        if(choice.equals("1")){
            saveScore(scan);
        } else if (choice.equals("2")) {
            printTotalScore();
        }

    } // end of main

    private static void saveScore(Scanner scan) {
        System.out.print("학생 수를 입력하세요: ");
        try {
            int count = Integer.parseInt(scan.nextLine());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < count; i++) {
                System.out.print((i + 1) + "번째 학생 점수: ");
                // sb에 계속 append
                // 10 20 30 40
                String score = scan.nextLine();
                sb.append(score);
                sb.append(" ");
            }
            try (FileOutputStream fos = new FileOutputStream("scores.txt")) {
                fos.write(sb.toString().getBytes());
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void printTotalScore() {
        System.out.println("점수 분석 총점/평균");
        try (FileInputStream fin = new FileInputStream("scores.txt");) {
            // 파일 전체를 문자열로 읽기
            StringBuffer sb = new StringBuffer();
            int data;
            while ((data = fin.read()) != -1) {
                sb.append((char) data);
            }
            // System.out.println(sb.toString());

            String[] parts = sb.toString().trim().split(" "); //공백 기준으로 문자열을 자르는 split --> 배열 반환
            int total = 0;
            for (String part : parts) {
                // 문자열을 정수값으로 변환하는 방법
                total += Integer.parseInt(part);
            }
            System.out.println("총점: " + total);
            System.out.println("평균: " + (double) total / parts.length);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    } // end of totalPrintScore

}
