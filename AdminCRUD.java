import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminCRUD {

    // CREATE
    public static boolean createAdmin(String name, String email, String password) {
        String query = "INSERT INTO ADMIN (name, email, password) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, password);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // READ All Admins
    public static List<Admin> getAllAdmins() {
        List<Admin> adminList = new ArrayList<>();
        String query = "SELECT * FROM ADMIN";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                adminList.add(new Admin(rs.getInt("admin_id"), rs.getString("name"), rs.getString("email"), rs.getString("password")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adminList;
    }
}
