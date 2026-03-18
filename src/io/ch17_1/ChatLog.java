package io.ch17_1;

import java.io.*;
import java.util.Scanner;

public class ChatLog {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("1. 대화저장");
        System.out.println("2. 전체 로그 보기");
        System.out.println("3. 단어 검색");
        System.out.println("4. 이름 검색");
        System.out.print("선택:");
        String choice = scan.nextLine();

        if (choice.equals("1")) {
            saveChat();
        } else if (choice.equals("2")) {
            printAll();
        } else if (choice.equals("3")) {
            System.out.print("검색할 단어: ");
            String keyword = scan.nextLine();
            searchChat(keyword);
        } else if(choice.equals("4")) {
            System.out.print("검색할 이름: ");
            String name = scan.nextLine();
            searchByName(name);
        }

        scan.close();

    } // end of main

    private static void searchByName(String name) {
        try (BufferedReader br = new BufferedReader(new FileReader("chat_log.txt"))) {
            System.out.println("\n===== " + name + "의 대화 =====");
            String line;
            int count = 0;

            while((line = br.readLine()) != null) {
                if(line.startsWith(name + ">")) {
                    System.out.println(line);
                    count++;
                }
            }

            if (count == 0) {
                System.out.println(name +"님이 대화한 기록이 없습니다");
            } else {
                System.out.println("총 " + count + "개의 대화");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void searchChat(String keyword) {

        try (BufferedReader br = new BufferedReader(new FileReader("chat_log.txt"))) {
            System.out.println("\n===== " + keyword + "검색 결과 =====");

            String line;
            int count = 0;

            while ((line = br.readLine()) != null) {
                // 만약 키워드 단어가 포함되어 있다면...
                if (line.contains(keyword.trim())) {
                    System.out.println(line);
                    count++;
                }
            }

            if (count == 0) {
                System.out.println(keyword + "가 포함된 대화가 없습니다.");
            } else {
                System.out.println("\n총 " + count + "개의 대화 내용이 발견 됐습니다.");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    } // end of search()

    private static void printAll() {

        System.out.println("\n===== 전체 채팅 로그 =====");
        // FileReader + BufferedReader
        try (BufferedReader br = new BufferedReader(new FileReader("chat_log.txt"))) {
            String line;
            int num = 1;
            while ((line = br.readLine()) != null) {
                System.out.println(num + " | " + line);
                num++;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    } // end of printAll()

    private static void saveChat() {
        System.out.println("===== 채팅 로그 저장소 =====");
        System.out.println("이름과 메세지를 입력하세요");
        System.out.println("형식: 이름>메세지    예) 홍길동>메세지");

        // System.in(바이트) -> InputStreamReader(문자 변환) -> BufferedReader( 버퍼 + readLine() )
        // FileWriter("파일명")  -> BufferedWriter()
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new FileWriter("chat_log.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
                bw.flush(); // 입력할 때 마다 즉시 파일에 저장
            }

            System.out.println("채팅 로그가 저장 되었습니다");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    } // end of saveChat()

} // end of class

