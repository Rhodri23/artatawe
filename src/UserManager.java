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

    public void addUser(String username, String firstName, String lastName) {
        User user = createUser(username, firstName, lastName);
        users.add(user);
    }

    private User createUser(String username, String firstName, String lastName) {
        User user = new User(username, firstName, lastName);
        return user;
    }

    private void saveUser(User user) {
        ReadWriteUser.save(user);
    }

    public String toString() {
        String userStr = "";

        for(int i = 0; i < users.size(); i++) {
            userStr += ("  " + users.get(i) + "\n");
        }

        return String.format("Users: \n" + userStr);
    }
}
