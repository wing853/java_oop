package http.gson;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class TodoClient {

    public static void main(String[] args) {
        // 통신할 주소: https://jsonplaceholder.typicode.com/todos/1
        // 단건 조회 --> JSON Object

        String urlString = "https://jsonplaceholder.typicode.com/todos/100";
        HttpURLConnection connection;

        try {
            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();

            // HTTP 요청 메세지 만들어서 --> 연결 요청
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept","application/json");
            // 내가 설정하지 않더라도 기본적인 설정이 구축되어 있음

            // 바로 연결 요청
            int responseHttpCode = connection.getResponseCode(); // 통신
            System.out.println("통신 성공 여부 확인: " + responseHttpCode);

            // 응답 본문 추출
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {

                StringBuffer responseBody = new StringBuffer();
                String line;

                while((line = reader.readLine()) != null) {
                    responseBody.append(line);
                }

                // StringBuffer --> String으로 형변환: toString()호출 or +""(문자열 더하기)
                String jsonString = responseBody.toString();
                System.out.println("JSON 응답: " + responseBody);

                // 자바 프로그램에서 사용하려면 JSON형식의 텍스트를 파싱 처리 해야한다.
                // GSON 라이브러리 사용 - 사용 방법
                Gson gson = new Gson();
                // JAVA 객체 변환 <--- JSON 문자열

                // 변환 하고자하는 JSON형식의 문자열 <-- 1번째 인수 값
                // 변호나 하고자 하는 DTO 타입(클래스)
                Todo todo= gson.fromJson(jsonString,Todo.class);
                // GSON lib 활용해서 간단히 파싱 처리하고 우리 자바에서 쓰는 데이터 타입으로 활용 가능
                System.out.println("================================");
                System.out.println(todo.getId());
                System.out.println(todo.getUserId());
                System.out.println(todo.getTitle());
                System.out.println(todo.isCompleted());
                System.out.println(todo.toString());
            }

        } catch (MalformedURLException e) {
            System.out.println("통신 실패: " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    } // end of main

}
