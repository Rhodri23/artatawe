import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
* Simple description of the class, along with the author and verison.
* @author Placeholder
* @version 1.0
*/

class ReadWriteUser extends FileManager {
    public String fileLocation = "data/users.txt";

    public boolean save(User user){
        System.out.println("Saving user: " + user);
        super.store(user.getUsername(), fileLocation);
        return true;
    }

    public ArrayList<User> load() {
        ArrayList<User> users = new ArrayList<User>();
        return users;
    }

    private User load(Scanner line) {
        User user = null;
        return user;
    }
}
