package io.ch15_1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class SecretNote {
   static int keyValue;
    public static void main(String[] args) {

        // 1. 키보드에서 값을 받아야 한다
        // 2. 파일에다가 키보드에서 입력 받은 값을 저장 시켜야 한다
        // 2.1 단, 내용을 살짝 변경해서 저장해야 한다 (아스키 코드 값에 + 3)
        Scanner scan = new Scanner(System.in);

        final String encryption = "1";
        final String decryption = "2";

        System.out.println("=== 비밀 메모장 ===");
        System.out.println("1. 메모 암호화 저장");
        System.out.println("2. 메모 복호화 읽기");
        System.out.print("선택: ");
        String input = scan.nextLine();

        if (input.equals(encryption)) {
            saveMemo(scan);
        } else if (input.equals(decryption)) {
            readMemo(scan);
        }

        scan.close();

    } // end of main

    private static void readMemo(Scanner scan) {
        System.out.println("\n=== 복호화 된 메모 ===");
        try (FileInputStream fis = new FileInputStream("secrect.txt")) {
            int data;
            System.out.print("복호화 키: ");
            keyValue = scan.nextInt();
            while ((data = fis.read()) != -1) {
                System.out.print((char) (data - keyValue));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void saveMemo(Scanner scan) {

        System.out.print("저장할 메모를 입력하세요: ");
        String input = scan.nextLine();
        System.out.print("암호화 키: ");
        keyValue = scan.nextInt();

        try (FileOutputStream fos = new FileOutputStream("secrect.txt")) {

            byte[] original = input.getBytes();
            byte[] encrypted = new byte[original.length]; // 배열의 크기만 선언한 상태

            for (int i = 0; i < original.length; i++) {
                encrypted[i] = (byte) (original[i] + keyValue);
            }

            fos.write(encrypted);
            // fos.flush(); -> fos.close 호출 시 자동 호출 flush()
            System.out.println("각 문자에 " + keyValue +"를 더해서 저장");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
