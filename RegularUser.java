// RegularUser.java
public class RegularUser extends User {
    // Constructor
    public RegularUser(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    // Override login method from User
    @Override
    public boolean login(String username, String password) {
        // Implement logic for user login
        return this.username.equals(username) && this.password.equals(password);
    }

    // Override viewProfile method from User
    @Override
    public void viewProfile() {
        System.out.println("Viewing profile of: " + username);
    }
}
