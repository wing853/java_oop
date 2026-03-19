package io.ch18;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) {
        final double NANOSECOND = 1_000_000_000.0;
        // 파일 경로 지정
        String sourceFilePath = "employees.zip";
        String destinationFilePath = "employees_copy.zip";

        // 소요 시간 측정 시작
        // 현재 시각을 나코초(10억분의 1초) 단위로 변환 1970년부터~
        long startTime = System.nanoTime(); // 1000분에 1초

        // 파일 복사 기능

        try (FileInputStream fis = new FileInputStream(sourceFilePath);
             FileOutputStream fos = new FileOutputStream(destinationFilePath)) {
            int data;
            while ((data =fis.read()) != -1) {
                fos.write(data);
            }
            System.out.println("파일 복사 완료");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // employees.zip 에서 1바이트 씩 읽어서
        // employees_copy.zip에 1바이트 씩 쓰기

        long endTime = System.nanoTime(); // 끝난 시각
        // 소요 시간 계산
        long duration = endTime - startTime;
        double seconds = duration / NANOSECOND; // 나노초에서 초 변환
        System.out.println("나노 초 값: " + duration);
        System.out.println("초 값: " + seconds);





    } // end of main
} // end of class