package http.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

// https://jsonplaceholder.typicode.com/posts/1
public class PostClient2 {

    private static final int SUCCESS_CODE = 200;

    public static void main(String[] args) {

        String urlString = "https://jsonplaceholder.typicode.com/posts";
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

                Gson gson = new Gson();

                TypeToken<List<Post>> postToken = new TypeToken<>() {};
                List<Post> posts = gson.fromJson(response, postToken.getType());
                System.out.println("전체 개수: " + posts.size() + "개");
                for (Post post : posts) {
                    System.out.println(post.toString());
                }


            }



        } catch (MalformedURLException e) {
            System.out.println("통신 실패: " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    } // end of main

}
