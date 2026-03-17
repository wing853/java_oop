package io.ch17;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ImageCopy {

    public static void main(String[] args) {
        // abc.png파일을 읽어서
        // abc2.png파일을 만들기
        String sourceFile = "abc.png";
        String destFile = "E:\\_work_java\\abc2.png";
        long startTime = System.currentTimeMillis();

        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destFile)) {
            int data;
            while ((data = fis.read()) != -1) {
                fos.write((char) data);
            }
            long endTime = System.currentTimeMillis();
            System.out.println("파일 저장 완료");
            System.out.println("소요시간: " + (endTime - startTime) + "ms");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

}
