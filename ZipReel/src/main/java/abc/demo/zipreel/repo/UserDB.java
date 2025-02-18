package abc.demo.zipreel.repo;

import abc.demo.zipreel.dataModel.User;
import java.util.HashMap;
import java.util.Map;

public class UserDB {
    private static final Map<Integer, User> userMap = new HashMap<>();
    private static int userIdCounter = 1;

    public static void addMovie(User user){
        if(userMap.containsKey(user.getUserId()))
            System.out.println("User is already exists");
        else {
            userMap.put(userIdCounter, user);
            userIdCounter++;
            System.out.println("User : " + user.getUname()+" added succesully");
        }
    }
}
