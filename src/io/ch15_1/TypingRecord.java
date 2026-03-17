package io.ch15_1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class TypingRecord {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===타자 연습 기록기===");
        System.out.println("1. 문장 저장");
        System.out.println("2. 기록 보기");
        System.out.print("선택 : ");
        String choice = sc.nextLine();

        if (choice.equals("1")) {
            saveRecord(sc);
        } else if (choice.equals("2")) {
            printRecord();
        }

        sc.close(); // 메모리 누수 방지

    } // end of main

    private static void printRecord() {
        System.out.println("\n===저장된 기록 ===");
        try (FileInputStream fin = new FileInputStream("typing_record.txt")) {
            int data;
            int count = 0;
            StringBuilder sb = new StringBuilder();
            while ((data = fin.read()) != -1) {
                if (data == '\n') {
                    count++;
                    System.out.println(count + "번 기록 " + sb);
                    sb.delete(0, sb.length());
                } else {
                    sb.append((char) data);
                }

            }
            System.out.print("총 " + count + "개의 기록이 있습니다.");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void saveRecord(Scanner sc) {
        System.out.print("연습한 문장을 입력하세요 : ");
        String input = sc.nextLine();

        try (FileOutputStream fos = new FileOutputStream("typing_record.txt", true)) {
            fos.write(input.getBytes());
            // 줄바꿈 추가
            fos.write("\n".getBytes());
            System.out.println("저장 완료!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
