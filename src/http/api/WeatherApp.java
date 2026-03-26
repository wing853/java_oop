package http.api;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherApp {

    public static void main(String[] args) {
        String apiKey = "0d968badf5afa996135e403899873bb2"; // 발급받은 API 키 입력
        String city = "Busan";
        String urlString = "https://api.openweathermap.org/data/2.5/weather?q=" + city +
                "&appid=" + apiKey + "&units=metric&lang=kr";

        try {
            // 1. URL 객체 생성 및 연결 설정
            URL url = new URL(urlString);
            System.out.println(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000); // 연결 타임아웃 5초
            conn.setReadTimeout(5000);    // 읽기 타임아웃 5초

            // 2. 응답 코드 확인 (200 OK 인지 체크)
            int responseCode = conn.getResponseCode();

            if (responseCode == 200) {
                // 3. 입력 스트림을 통해 데이터 읽기
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // 4. 결과 출력
                System.out.println("응답 성공!");

                Gson gson = new Gson();
                WeatherAppDTO weatherAppDTO = gson.fromJson(response.toString(), WeatherAppDTO.class);
                System.out.println("상태: " + weatherAppDTO.getWeather().get(0).getDescription());
                System.out.println("기온: " + weatherAppDTO.getMain().getTemp() + "°C");
                System.out.println("습도: " + weatherAppDTO.getMain().getHumidity() + "%");
                System.out.println("풍속: " + weatherAppDTO.getWind().getSpeed() + "m/s");

                if (weatherAppDTO.getMain().getTemp() > 25) {
                    System.out.println("🥵 더운 날씨 🥵");
                } else if (weatherAppDTO.getMain().getTemp() < 10) {
                    System.out.println("😰조금 쌀쌀한 날씨😰");
                } else {
                    System.out.println("😀오늘 날씨가 따뜻하네요 산책하기 좋아요😀");
                }

            } else {
                System.out.println("호출 실패. 응답 코드: " + responseCode);
            }

            conn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

