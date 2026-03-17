package io.ch17;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ImageCopy {

    public static void main(String[] args) {
        // abc.png파일을 읽어서
        // abc2.png파일을 만들기

        try (FileInputStream fis = new FileInputStream("abc.png");
             FileOutputStream fos = new FileOutputStream("abc2.png")) {
            int data;
            while((data = fis.read()) != -1){
                fos.write((char)data);
            }
            System.out.println(System.currentTimeMillis());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

}
