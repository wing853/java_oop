package http.json;

public class NotJsonEx2 {
    public static void main(String[] args) {
        String json = "{\"userId\": 1, \"id\": 1, \"title\": \"quidem molestiae enim\"}";
        // Json 형식에 문자열을 파싱해서 Album 객체로 변환

        String remove = json.replace("{", "").replace("}", "");
        System.out.println(remove);

        String[] parts = remove.split(",");
        for (int i = 0; i < parts.length; i++) {
            System.out.print(parts[i]);
        }
        System.out.println();

        int userId = Integer.parseInt(parts[0].split(":")[1].trim());
        System.out.println(userId);

        int id = Integer.parseInt(parts[1].split(":")[1].trim());
        System.out.println(id);

        String title = parts[2].split(":")[1].trim();
        System.out.println(title);

        Album2 album = new Album2(userId, id, title);
        System.out.println(album.toString());

    } // end of main

} // end of class

class Album2 {
    int userId;
    int id;
    String title;

    public Album2(int userId, int id, String title) {
        this.userId = userId;
        this.id = id;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Album{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}