package http.api;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class AirClient {

    private static final String SERVICE_KEY = "d439493b168b27443cf338c7130bc9eb2217b470390037bc70979e84dc6668ce";
    private static final String BASE_URL = "http://apis.data.go.kr/B552584/UlfptcaAlarmInqireSvc/getUlfptcaAlarmInfo";

    public static void main(String[] args) {
        getAirData();
    } // end of main

    private static void getAirData() {
        String urlString = BASE_URL +
                "?serviceKey=" + SERVICE_KEY +
                "&returnType=json" +
                "&numOfRows=2" +
                "&pageNo=1" +
                "&year=2025";
        HttpURLConnection connection;

        try {
            URL url = new URL(urlString);

            connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            System.out.println("응답 코드: " + responseCode);

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                StringBuilder sb = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }
                System.out.println("출력값: " + sb);

                String airInfo = sb.toString();

                Gson gson = new Gson();
                AirQualityDto airQualityDto = gson.fromJson(airInfo, AirQualityDto.class);
                System.out.println(airQualityDto);

            }

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

} // end of class
