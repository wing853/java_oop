package http.gson;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

// https://jsonplaceholder.typicode.com/posts/1
public class PostClient {

    private static final int SUCCESS_CODE = 200;

    public static void main(String[] args) {

        String urlString = "https://jsonplaceholder.typicode.com/posts/1";
        HttpURLConnection connection;

        try {
            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            System.out.println("응답 코드 확인: " + responseCode);

            if(responseCode != SUCCESS_CODE) {
                System.out.println("연결 실패");
                return;
            }

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {

                StringBuffer responseBody = new StringBuffer();
                String line;

                while((line = reader.readLine()) != null) {
                    responseBody.append(line);
                }
                String response = responseBody.toString();
                System.out.println("JSON 요청 내용: " + response);

                Gson gson = new Gson();
                Post post= gson.fromJson(response, Post.class);

                System.out.println("UserId: " + post.getUserId());
                System.out.println("Id: " + post.getId());
                System.out.println("Title: " + post.getTitle());
                System.out.println("Body: " + post.getBody());
                System.out.println("전체 정보:\n" + post.toString());
            }



        } catch (MalformedURLException e) {
            System.out.println("통신 실패: " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    } // end of main

}
