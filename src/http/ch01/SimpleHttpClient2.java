package http.ch01;

// https://jsonplaceholder.typicode.com/users/10

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class SimpleHttpClient2 {

    static final int SUCCESS_CODE = 200;

    public static void main(String[] args) {
        // 가짜 서버에 user10에 정보를 요청하고 응답을 받고 콘솔창에 출력하시오
        String urlString = "https://jsonplaceholder.typicode.com/users/10";

        HttpURLConnection connection;

        try {
            URL url = new URL(urlString);

            connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

            int responseCode = connection.getResponseCode();
            System.out.println("응답 코드 확인: " + responseCode);
            if (responseCode != SUCCESS_CODE) {
                System.out.println("응답 실패");
                return;
            }

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                StringBuffer response = new StringBuffer();
                String line;

                while ((line = reader.readLine()) != null) {
                    response.append(line + "\n");
                }
                System.out.println("응답 내용:");
                System.out.println(response);
            }


        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    } // end of main
}
