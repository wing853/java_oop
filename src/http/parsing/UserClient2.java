package http.parsing;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

// https://jsonplaceholder.typicode.com/users/1
public class UserClient2 {
    public static void main(String[] args) {

        String urlString = "https://jsonplaceholder.typicode.com/users";
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
                TypeToken<List<User>> tokenUser = new TypeToken<>() {
                };
                List<User> users = gson.fromJson(response, tokenUser.getType());
                Scanner scan = new Scanner(System.in);
                while (true) {
                    System.out.println("0. 종료");
                    System.out.println("1. 전체 조회");
                    System.out.println("2. ID 조회");
                    System.out.print("선택: ");
                    String input = scan.nextLine();
                    if (input.equals("0")) {
                        break;
                    } else if (input.equals("1")) {
                        for (User user : users) {
                            System.out.println(user.toString());
                        }
                    } else if (input.equals("2")) {
                        System.out.print("조회할 ID를 입력하세요: ");
                        int id = scan.nextInt();


                        for (User user : users) {
                            if (user.getId() == id) {
                                System.out.println(user.toString());
                                break;
                            }
                        }
                    }
                }

            }

        } catch (MalformedURLException e) {
            System.out.println("통신 실패: " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    } // end of main
}
