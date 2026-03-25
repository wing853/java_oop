package http.toJson;

import com.google.gson.Gson;
import lombok.Data;

public class ToJsonEx {

    public static void main(String[] args) {
        // 자바 객체 생성 ---> 텍스트 형식인 JSON으로 변환
        Post post = new Post();
        post.setUserId(1);
        post.setId(10);
        post.setTitle("자바 공부");
        post.setBody("JSON 파싱 연습");

        Gson gson = new Gson();
        String jsonPost = gson.toJson(post);
        System.out.println(jsonPost);

        // jsonPost를 다시 역방향으로

        Post rePost = gson.fromJson(jsonPost,Post.class);
        System.out.println(rePost);

    } // end of main

} // end of class

@Data
class Post {
    private int userId;
    private int id;
    private String title;
    private String body;
}