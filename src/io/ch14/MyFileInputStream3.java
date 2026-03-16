package io.ch14;

import java.io.FileInputStream;

public class MyFileInputStream3 {

    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("a_1.txt")) {
            int readData;

            while ((readData = in.read()) != -1) {
                System.out.print((char) readData);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
