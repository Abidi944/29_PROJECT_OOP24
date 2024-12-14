import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class AdminLoginPage extends JFrame {

    public AdminLoginPage() {
        setTitle("Admin Login - SaSaMbo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(1024, 600);

        // Left Panel (Illustration)
        JPanel leftPanel = createLeftPanel();
        add(leftPanel, BorderLayout.WEST);

        // Right Panel (Login Form)
        JPanel rightPanel = createRightPanel();
        add(rightPanel, BorderLayout.CENTER);
    }

    private JPanel createLeftPanel() {
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(new Color(82, 99, 70)); 
        leftPanel.setLayout(new BorderLayout());

        JLabel illustration = new JLabel(new ImageIcon("asset/foto animasi sasambo.png"));
        illustration.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel leftText = new JLabel("<html><div style='text-align: center; color: white; font-size: 18px;'>Jelajahi warisan, temukan sejarah<br>dan hayati budaya!</div></html>");
        leftText.setHorizontalAlignment(SwingConstants.CENTER);
        leftText.setVerticalAlignment(SwingConstants.BOTTOM);
        leftText.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        leftPanel.add(illustration, BorderLayout.CENTER);
        leftPanel.add(leftText, BorderLayout.SOUTH);
        return leftPanel;
    }

    private JPanel createRightPanel() {
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridBagLayout());
        rightPanel.setBackground(Color.WHITE);

        JLabel logo = new JLabel("SaSaMbo");
        logo.setFont(new Font("SansSerif", Font.BOLD, 24));
        logo.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel welcome = new JLabel("Hi, Admin! Selamat Datang!");
        welcome.setFont(new Font("SansSerif", Font.PLAIN, 16));

        JTextField usernameField = new JTextField(20);
        usernameField.setBorder(BorderFactory.createTitledBorder("Username"));

        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setBorder(BorderFactory.createTitledBorder("Password"));

        JButton loginButton = new JButton("Login");
        JButton backButton = new JButton("Back");

        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (authenticateAdmin(username, password)) {
                JOptionPane.showMessageDialog(this, "Login berhasil! Selamat datang, Admin.");
                navigateToAdminDashboard();
            } else {
                JOptionPane.showMessageDialog(this, "Username atau password salah!", "Login Gagal", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Back button to MainPage
        backButton.addActionListener(e -> {
            dispose();
            new MainPage().setVisible(true); 
        });

        // Layout configuration
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
        rightPanel.add(logo, gbc);

        gbc.gridy++;
        rightPanel.add(welcome, gbc);

        gbc.gridy++;
        rightPanel.add(usernameField, gbc);

        gbc.gridy++;
        rightPanel.add(passwordField, gbc);

        gbc.gridy++;
        rightPanel.add(loginButton, gbc);

        gbc.gridy++;
        rightPanel.add(backButton, gbc);

        return rightPanel;
    }

    private boolean authenticateAdmin(String username, String password) {
        String query = "SELECT * FROM ADMIN WHERE name = ? AND password = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menghubungi database.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    private void navigateToAdminDashboard() {
        dispose();
        AdminDashboardFrame adminDashboard = new AdminDashboardFrame();
        adminDashboard.setVisible(true);
    }
}
