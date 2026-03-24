package collection;

import java.util.*;

//데이터를 보관하고 관리하는 클래스
public class MemberRepository {
    private List<Member> memberList = new ArrayList<>(); // 전체 목록
    private Map<Integer, Member> memberMap = new HashMap<>();  // ID -> 회원 정보
    private Set<String> emailSet = new HashSet<>(); // 이메일 중복체크
    private int nextId = 1;
    // 회원가입하면 ID를 자동으로 1씩 증가하는 방법으로 회원에게 할당할 예정

    // 회원가입
    public boolean save(String name, String email, int age) {
        // 이메일 중복확인
        if (emailSet.contains(email)) {
            System.out.println("[오류] 이미 사용중인 이메일 입니다" + email);
            return false;
        }
        Member member = new Member(nextId, name, email, age);
        memberList.add(member);
        memberMap.put(nextId, member);
        emailSet.add(email);
        nextId++;
        // ID 유효성 검증

        System.out.println("[완료] 회원가입: " + member.getName());

        return true;
    }

    // ID로 회원 조회 -- id 입력이 들어오면 Member를 반환
    public Member findById(int id) {
        return memberMap.get(id);
    }

    // 전체 회원 목록 조회 -- 모든 멤버 정보를 반환 -> List
    public List<Member> findAll() {
        return memberList;
    }

    // 이름으로 회원 조회
    public List<Member> findByName(String name) {
        List<Member> result = new ArrayList<>();

        for (Member member : memberList) {
            if (member.getName().equalsIgnoreCase(name)) {
                result.add(member);
            }
        }

        return result;
    }

    // 회원 정보 수정
    // 1. id 기준으로 회원 정보 조회
    // 2. 새로운 이름 정보 필요
    // 3. 새로운 나이 정보 필요
    // 4. 이메일은 중복 처리 때문에 수정 불가하게 막을 예정.
    public boolean update(int id, String newName, int newAge) {
        // 수정을 하려면 반드시 먼저 조회
        Member member = memberMap.get(id);
        if (member == null) {
            System.out.println("존재하지 않는 회원입니다 ID: " + id);
            return false;
        }

        member.setName(newName);
        member.setAge(newAge);
        System.out.println("[완료] 수정됨: " + member);
        return true;
    }


    // 회원 ID 번호로 삭제
    public boolean delete(int id) {
        // 먼저 조회부터 하고 삭제
        Member member = memberMap.get(id);
        if (member == null) {
            System.out.println("존재 하지 않는 회원 입니다.");
            return false;
        }
        // list, map, set - 동기화 처리 중요
        memberList.remove((id - 1)); // 인텍스 번호로 삭제하기 때문에 보여지는 값 -1
        memberMap.remove(id);
        emailSet.remove(member.getEmail());
        System.out.println("삭제됨: " + member.getEmail());


        return true;
    }

    // 전체 회원수
    public int count() {
        return memberList.size();
    }

    // 나이 범위로 검색
    public List<Member> findByAgeRange(int minAge, int maxAge) {
        List<Member> resultList = new ArrayList<>();

        for(Member member : memberList) {
            if (member.getAge() >= minAge&& member.getAge()<=maxAge) {
                resultList.add(member);
            }
        }

        return resultList;
    }

    // 이메일로 회원찾기
    public Member findByEmail(String email) {

        // 전체 순회전에 존재 여부부터 확인 --> 빠르게 존재 여부 확인
        if (emailSet.contains(email) == false) {
            return null;
        }

        for(Member member : memberList) {
            if(member.getEmail().equalsIgnoreCase(email)){
                return member;
            }
        }

        return null;
    }
}
