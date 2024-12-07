public abstract class User {
    protected int id;
    protected String username;
    protected String password;

    public abstract boolean login(String username, String password);
    public abstract void viewProfile();
}
