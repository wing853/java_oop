package http.api;

import lombok.Data;

import java.util.List;
@Data
public class WeatherDTO {

    private Response response;

    @Data
    public static class Response {
        private Header header;
        private Body body;

    } // end of inner class

    @Data
    public static class Header {
        private String resultCode;
        private String resultMsg;
    }

    @Data
    public static class Body {
        private String dataType;
        private Items items;

    }

    @Data
    public static class Items {
        private List<Item> item;
    }

    @Data
    public static class Item {
        private String baseDate;
        private String baseTime;
        private String category;
        private int nx;
        private int ny;
        private String obsrValue;
    }

} // end of outer class
