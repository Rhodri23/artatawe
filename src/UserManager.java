import java.util.List;
import java.util.ArrayList;

/**
* Simple description of the class, along with the author and verison.
* @author Placeholder
* @version 1.0
*/

public class UserManager {
    public int userCounter = 0;
    private List<User> users = new ArrayList<User>();
    private ReadWriteUser userManager = new ReadWriteUser();

    public boolean addUser(String username, String firstName, String lastName) {
        User user = createUser(username, firstName, lastName);
        if(!saveUser(user)) {
            return false;
        }
        users.add(user);
        return true;
    }

    private User createUser(String username, String firstName, String lastName) {
        User user = new User(username, firstName, lastName);
        return user;
    }

    private boolean saveUser(User user) {
        return userManager.save(user);
    }

    public String toString() {
        String userStr = "";

        for(int i = 0; i < users.size(); i++) {
            userStr += ("  " + users.get(i) + "\n");
        }

        return String.format("Users: \n" + userStr);
    }
}
