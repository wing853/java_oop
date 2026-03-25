package http.parsing;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

// https://jsonplaceholder.typicode.com/users/1
public class UserClient {
    public static void main(String[] args) {

        String urlString = "https://jsonplaceholder.typicode.com/users/1";
        HttpURLConnection connection;

        try {
            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            System.out.println("응답 코드 확인: " + responseCode);

            if (responseCode != 200) {
                System.out.println("응답실패");
                return;
            }

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                StringBuffer sb = new StringBuffer();
                String line;

                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }

                String response = sb.toString();

                Gson gson = new Gson();
                User user = gson.fromJson(response, User.class);
                System.out.println(user.toString());
            }


        } catch (MalformedURLException e) {
            throw new RuntimeException(e); //
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    } // end of main
}
