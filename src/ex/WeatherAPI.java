package ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class WeatherAPI {

    public static void main(String[] args) {
        String urlSting = "https://api.openweathermap.org/data/2.5/weather?lat=35&lon=127&appid=0d968badf5afa996135e403899873bb2";
        HttpURLConnection conn;

        try {
            URL url = new URL(urlSting);
            conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");

            BufferedReader rd;

            if(conn.getResponseCode() >= 200 && conn.getResponseCode()<300) {
                rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            } else {
                rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            }




        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
