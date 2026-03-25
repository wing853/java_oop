package http.toJson;

import com.google.gson.Gson;

import java.awt.print.Book;

public class ToJsonUser {

    public static void main(String[] args) {
        User user = new User();

        user.setId(1);
        user.setName("Leanne Graham");
        user.setUsername("Bret");
        user.setEmail("Sincere@april.biz");
        user.getAddress().setStreet("Kulas Light");
        user.getAddress().setSuite("Apt. 556");
        user.getAddress().setCity("Gwenborough");
        user.getAddress().setCity("92998-3874");
        user.getAddress().getGeo().setLat("-37.3159");
        user.getAddress().getGeo().setLng("81.1496");
        user.setPhone("1-770-736-8031 x56442");
        user.setWebsite("hildegard.org");
        user.getCompany().setName("Romaguera-Crona");
        user.getCompany().setCatchPhrase("Multi-layered client-server neural-net");
        user.getCompany().setBs("harness real-time e-markets");

        Gson gson = new Gson();
        String userToJson = gson.toJson(user);
        System.out.println(userToJson);

        User reUser = gson.fromJson(userToJson, User.class);
        System.out.println(reUser);

    }

}


