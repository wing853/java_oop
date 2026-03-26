package http.api;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class WeatherApiDTO {
    public static void main(String[] args) {

        // 1. 공공데이터 토탈 인증키(보통 Decoding 사용)
        String serviceKey = "d439493b168b27443cf338c7130bc9eb2217b470390037bc70979e84dc6668ce";

        // 2. 조회에 필요한 파라미터 설정
        String baseDate = "20260325";
        String baseTime = "0500";
        String nx = "55";
        String ny = "127";

        try{
            StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst"); /*URL*/
            urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + serviceKey); /*Service Key*/
            urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
            urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
            urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8")); /*요청자료형식(XML/JSON) Default: XML*/
            urlBuilder.append("&" + URLEncoder.encode("base_date","UTF-8") + "=" + URLEncoder.encode(baseDate, "UTF-8")); /*‘21년 6월 28일 발표*/
            urlBuilder.append("&" + URLEncoder.encode("base_time","UTF-8") + "=" + URLEncoder.encode(baseTime, "UTF-8")); /*06시 발표(정시단위) */
            urlBuilder.append("&" + URLEncoder.encode("nx","UTF-8") + "=" + URLEncoder.encode(nx, "UTF-8")); /*예보지점의 X 좌표값*/
            urlBuilder.append("&" + URLEncoder.encode("ny","UTF-8") + "=" + URLEncoder.encode(ny, "UTF-8")); /*예보지점의 Y 좌표값*/

            // HTTP 연결 설정
            URL url = new URL(urlBuilder.toString());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            // 생략

            BufferedReader rd;
            if(conn.getResponseCode() >= 200 && conn.getResponseCode() < 300) {
                // 통신 성공
                rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            } else {
                // 통신 성공은 했으나 응답 잘못, 실패
                rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            }

            StringBuilder sb = new StringBuilder();
            String line;

            while((line = rd.readLine()) != null) {
                sb.append(line);
            }

            rd.close();
            conn.disconnect();

            System.out.println(sb.toString());
            Gson gson = new Gson();
            //WeatherDTO weather = gson.fromJson(sb.toString(), WeatherDTO.class);
            //System.out.println(weather);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    } // end of main

}
