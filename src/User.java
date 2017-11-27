// Import statements

/**
* Simple description of the class, along with the author and verison.
* @author Placeholder
* @version 1.0
*/

public class User {
    private String username;
    private String firstName;
    private String lastName;

    User(String username, String firstName, String lastName) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getUsername() {
        return this.username;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String toString() {
        return String.format("User: " + this.username);
    }
}
