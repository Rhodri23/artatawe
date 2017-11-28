import java.util.ArrayList;
import java.util.List;

/**
* Simple description of the class, along with the author and verison.
* @author Placeholder
* @version 1.0
*/

class ReadWriteUser {
    private static final String FILE_LOCATION = "data/users.csv";

    public static void save(User user){
        System.out.println("Saving user: " + user);
        List<String> list = new ArrayList<>();
        list.add(user.getUsername());
        list.add(user.getFirstName());
        list.add(user.getLastName());

        try {
            FileManager.store(FILE_LOCATION, list);
        } catch(Exception e) {
            System.out.println("An error occured while trying to save a user!");
        }
    }

    public static ArrayList<User> load() {
        ArrayList<List<String>> file = FileManager.read(FILE_LOCATION);
        ArrayList<User> users = new ArrayList<User>();
        System.out.println("Reading users...");

        for(List<String> line : file) {
            // One Line
            System.out.println("User [Username=" + line.get(0) + ", firstName=" + line.get(1) + " , lastName=" + line.get(2) + "]");
            for(String value: line) {
                // Individual values
                // System.out.println(value);
            }
        }
        return users;
    }
}
