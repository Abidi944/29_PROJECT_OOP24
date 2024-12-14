import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserSession {

    // Database connection details
    private static final String DB_URL = "jdbc:mysql://localhost:3306/SASAMBO";  // Ganti dengan URL database Anda
    private static final String DB_USER = "root";  // Ganti dengan username database Anda
    private static final String DB_PASSWORD = "password";  // Ganti dengan password database Anda

    // Atribut untuk menyimpan data pengguna
    private static String name;
    private static String email;
    private static String password;

    // Mengambil data pengguna berdasarkan ID (atau email)
    public static void loadUserData(String userId) {
        // Koneksi ke database
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            // SQL Query untuk mengambil data pengguna
            String query = "SELECT name, email, password FROM USER WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, userId); // Misalnya menggunakan ID pengguna untuk pencarian

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Mengambil data dari database
                name = rs.getString("name");
                email = rs.getString("email");
                password = rs.getString("password");
            } else {
                System.out.println("User not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Mendapatkan nama pengguna
    public static String getName() {
        return name;
    }

    // Mendapatkan email pengguna
    public static String getEmail() {
        return email;
    }

    // Mendapatkan password pengguna
    public static String getPassword() {
        return password;
    }

    // Mengubah nama pengguna
    public static void setName(String newName) {
        name = newName;
    }

    // Mengubah email pengguna
    public static void setEmail(String newEmail) {
        email = newEmail;
    }

    // Mengubah password pengguna
    public static void setPassword(String newPassword) {
        password = newPassword;
    }
}
