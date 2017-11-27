import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;

/**
* Simple description of the class, along with the author and verison.
* @author Placeholder
* @version 1.0
*/

class ReadWriteUser {
    private static final String FILE_LOCATION = "data/users.csv";

    public static boolean save(User user){
        System.out.println("Saving user: " + user);
        List<String> list = new ArrayList<>();
        list.add(user.getUsername());
        list.add(user.getFirstName());
        list.add(user.getLastName());

        try {
            FileManager.store(FILE_LOCATION, list);
        } catch(Exception e) {
            System.out.println("An error occured while trying to save a user!");
            return false;
        }
        return true;
    }

    public static ArrayList<User> load() {
        ArrayList<User> users = new ArrayList<User>();
        return users;
    }
}
