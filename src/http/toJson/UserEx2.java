package http.toJson;

public class UserEx2 {

    public static void main(String[] args) {
        // User (DTO) 클래스를 내부 클래스에 필드를 만들었을 경우 사용법
        User3 user = new User3();
        User3.Address address = new User3.Address();
        User3.Address.Geo geo = new User3.Address.Geo();
        User3.Company company = new User3.Company();

        user.setAddress(address);
        user.getAddress().setGeo(geo);
        user.setCompany(company);

        // 값 할당 가능


    }

}
