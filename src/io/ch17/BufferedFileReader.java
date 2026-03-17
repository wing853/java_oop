package io.ch17;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedFileReader {

    public static void main(String[] args) {

        // FileReader(기반 스트림)을 BufferedReader(보조 스트림)로 감쌈.

        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {

            String line;
            // readLine(): 한 줄 전체를 String으로 읽음
            // 반환 값이 null이면 파일 끝
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    } // end of main

}
