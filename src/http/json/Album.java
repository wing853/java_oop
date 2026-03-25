package http.json;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Album {
    private int userId;
    private int id;
    private String title;
}
