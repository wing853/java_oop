package http.toJson;

import com.google.gson.Gson;

public class ToJsonUser2 {

    public static void main(String[] args) {
        User user = new User();
        Address address = new Address();
        Geo geo = new Geo();
        Company company = new Company();

        user.setId(1);
        user.setName("홍길동");
        user.setAddress(address);
        address.setCity("부산");
        address.setStreet("중앙대로");
        user.getAddress().setGeo(geo);
        geo.setLat("123.1");
        geo.setLng("44.5");
        user.setCompany(company);
        user.getCompany().setName("코리아IT");

        // 객체 ---> (직렬화) JSON 텍스트 형식
        Gson gson = new Gson();
        String userJson = gson.toJson(user);
        System.out.println(userJson);
    }

}
