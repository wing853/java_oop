package io.ch15;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MyFileOutputSystem2 {

    public static void main(String[] args) {
        String data = "Give me love and I'ma give it right back\n" +
                "Who knew cupid he could shoot me like that\n" +
                "Going stupid cause I want it so bad";
        try {
            FileOutputStream fos = new FileOutputStream("singLylics.txt");
            fos.write(data.getBytes());
            System.out.println("파일 생성 완료: singLylics");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    } // end of main

}
