package io.ch15_1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Scores2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //saveScore(scan);
        printTotalScore();

    } // end of main

    private static void saveScore(Scanner scan) {
        System.out.println("점수를 입력하세요: ");
        String scores = scan.nextLine();
        try (FileOutputStream fos = new FileOutputStream("scores2.txt")) {
            fos.write(scores.getBytes());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private static void printTotalScore() {
        System.out.println("점수 분석 총점/평균");
        try (FileInputStream fin = new FileInputStream("scores2.txt")) {
            int data;
            int total = 0;
            String str = "";
            while ((data = fin.read()) != -1) {
                if (data == ' ') {
                    total+=Integer.parseInt(str);
                    str = "";
                } else if ((char)data == -1) {
                    total+=Integer.parseInt(str);
                    str = "";
                } else {
                    str += (char)data;
                }
            }
            System.out.println(total);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
