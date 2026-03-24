package ex;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Member {

    private int id;
    private String name;
    private String email;
    private int age;


    public void createInfo() {
        System.out.println("[완료] 회원가입: " + name + "(ID: " + id + ")");
    }

    @Override
    public String toString() {
        return "Member{id=" + id + ", name=" + name + ", email=" + email + ", age=" + age + "}";
    }

    public String notCreateMember() {
        return "[오류] 이미 사용 중인 이메일입니다:" + email;
    }
}
