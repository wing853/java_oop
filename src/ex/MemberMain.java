package ex;

// 메인에서 실행해보기

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MemberMain {

    private final static String EXIT = "0";
    private final static String CREATE = "1";
    private final static String RENAME = "1";
    private final static String READ = "2";
    private final static String REEMAIL = "2";
    private final static String UPDATE = "3";
    private final static String REAGE = "3";
    private final static String DELETE = "4";
    private final static String READALL = "5";
    private static int id = 0;
   static Member member;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<Integer, Member> members = new HashMap<>();


        System.out.println("===== 회원 관리 시스템 =====");
        while (true) {
            System.out.println("0. 종료");
            System.out.println("1. 회원 가입");
            System.out.println("2. 회원 조회");
            System.out.println("3. 회원 수정");
            System.out.println("4. 회원 삭제");
            System.out.println("5. 전체 목록");

            System.out.print("번호를 선택하세요:");
            String input = scan.next();
            if (input.equals(EXIT)) {
                System.out.println("시스템을 종료합니다.");
                break;
            } else if (input.equals(CREATE)) {
                create(id, scan, members);
            } else if (input.equals(READ)) {
                read(scan, members, id);
            } else if (input.equals(UPDATE)) {
                update(scan, members);
            } else if (input.equals(DELETE)) {
                delete(scan, members);
            } else if (input.equals(READALL)) {
                readAll(members);
            }

        }

    } // end of main

    private static void readAll(Map<Integer, Member> members) {
        System.out.println("===전체 회원 목록 ===");
        for (int i = 0; i < members.size(); i++) {
            System.out.println(members.get(i + 1).toString());
        }
    } // end of readAll()

    private static void delete(Scanner scan, Map<Integer, Member> members) {
        System.out.println("=== 회원 삭제 ===");
        System.out.print("ID입력: ");
        int idInput = scan.nextInt();
        String name = members.get(idInput).getName();
        members.remove(idInput);
        System.out.println("[완료] 삭제됨: " + name);
    } // end of delete()

    private static void update(Scanner scan, Map<Integer, Member> members) {
        System.out.println("=== 회원 정보 수정 ===");
        System.out.print("ID입력: ");
        int idInput = scan.nextInt();

        while (true) {
            System.out.println("0. 종료");
            System.out.println("1. 이름 수정");
            System.out.println("2. 이메일 수정");
            System.out.println("3. 나이 수정");
            System.out.println("선택: ");
            String choice = scan.next();
            if (choice.equals(EXIT)) {
                break;
            } else if (choice.equals(RENAME)) {
                System.out.print("이름 수정: ");
                String reName = scan.next();
                members.get(idInput).setName(reName);
                System.out.println("이름 수정됨: " + members.get(idInput).toString());

            } else if (choice.equals(REEMAIL)) {
                System.out.print("이메일 수정: ");
                String reEmail = scan.next();
                members.get(idInput).setEmail(reEmail);
                System.out.println("이메일 수정됨: " + members.get(idInput).toString());

            } else if (choice.equals(REAGE)) {
                System.out.print("나이 수정: ");
                int reAge = scan.nextInt();
                members.get(idInput).setAge(reAge);
                System.out.println("나이 수정됨: " + members.get(idInput).toString());
            }
        }
    } // end of update()

    private static void read(Scanner scan, Map<Integer, Member> members, int id) {
        System.out.println("=== 회원 조회 ===");
        System.out.print("ID입력: ");
        int searchId = scan.nextInt();
        System.out.println("조회결과: " + members.get(searchId));
    }

    private static void create(int id, Scanner scan, Map<Integer, Member> members) {
        System.out.println("=== 회원 가입 ===");
        member = new Member();
        System.out.print("이름: ");
        String name = scan.next();
        System.out.print("이메일: ");
        String email = scan.next();
        System.out.print("나이: ");
        int age = scan.nextInt();

        member.setEmail(email);
        for (int i = 0; i < members.size() ; i++) {
            if(email.equals(members.get(i+1).getEmail())){

                System.out.println(member.notCreateMember());
                return;
            }
        }
        id++;
        member.setName(name);
        member.setId(id);
        member.setAge(age);

        members.put(id, member);
        member.createInfo();

    } // end of create()

} // end of class
