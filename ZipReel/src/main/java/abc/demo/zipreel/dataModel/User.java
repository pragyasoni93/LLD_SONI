package abc.demo.zipreel.dataModel;

import lombok.Data;
import java.util.List;

@Data
public class User {
    private String userId;
    private List<String> preferredGenre;
    private String uname;
}
