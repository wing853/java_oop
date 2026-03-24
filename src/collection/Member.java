package collection;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Member {

    private int id;
    private String name;
    private String email;
    private int age;

    // 필요하다면 직접 생성자 생성 가능


    public Member(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }
}
