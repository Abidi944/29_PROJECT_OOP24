import javax.swing.*;
import java.awt.*;
// import java.awt.event.*;
import java.sql.*;

public class LoginUserPage extends JFrame implements Navigable {

    public LoginUserPage() {
        setTitle("Login - SaSaMbo");
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

        JLabel welcome = new JLabel("Hi, Selamat Datang Kembali!");
        welcome.setFont(new Font("SansSerif", Font.PLAIN, 16));

        JTextField emailField = new JTextField(20);
        emailField.setBorder(BorderFactory.createTitledBorder("Alamat Email"));

        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setBorder(BorderFactory.createTitledBorder("Kata Sandi"));

        JButton loginButton = new JButton("Masuk");
        JButton backButton = new JButton("Back");

        loginButton.addActionListener(e -> {
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());

            if (validateLogin(email, password)) {
                new PageHome().setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Login gagal. Periksa email atau kata sandi Anda.", "Error", JOptionPane.ERROR_MESSAGE);
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
        rightPanel.add(emailField, gbc);

        gbc.gridy++;
        rightPanel.add(passwordField, gbc);

        gbc.gridy++;
        rightPanel.add(loginButton, gbc);

        gbc.gridy++;
        rightPanel.add(backButton, gbc);

        return rightPanel;
    }

    private boolean validateLogin(String email, String password) {
        String query = "SELECT * FROM USER WHERE email = ? AND password = ?";
        try (Connection conn = DatabaseConnection.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, email);
            stmt.setString(2, password);

            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();  
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void goToHome() {
        System.out.println("Navigating to Home Page...");
    }

    @Override
    public void goToProfile() {
        System.out.println("Navigating to Profile Page...");
    }

    @Override
    public void goToReview() {
        System.out.println("Navigating to Review Page...");
    }

    public class SignUpUserPage extends JFrame {
        public SignUpUserPage() {
            setTitle("Sign Up - SaSaMbo");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(new BorderLayout());
            setSize(1024, 600);

            // Left Panel (Illustration)
            JPanel leftPanel = createLeftPanel();
            add(leftPanel, BorderLayout.WEST);

            // Right Panel (Sign Up Form)
            JPanel rightPanel = createSignUpRightPanel();
            add(rightPanel, BorderLayout.CENTER);
        }

        private JPanel createSignUpRightPanel() {
            JPanel rightPanel = new JPanel();
            rightPanel.setLayout(new GridBagLayout());
            rightPanel.setBackground(Color.WHITE);

            JLabel logo = new JLabel("SaSaMbo");
            logo.setFont(new Font("SansSerif", Font.BOLD, 24));
            logo.setHorizontalAlignment(SwingConstants.CENTER);

            JTextField usernameField = new JTextField(20);
            usernameField.setBorder(BorderFactory.createTitledBorder("Nama Pengguna"));

            JTextField emailField = new JTextField(20);
            emailField.setBorder(BorderFactory.createTitledBorder("Alamat Email"));

            JPasswordField passwordField = new JPasswordField(20);
            passwordField.setBorder(BorderFactory.createTitledBorder("Kata Sandi"));

            JButton signUpButton = new JButton("Sign Up");
            JButton backButton = new JButton("Back");

            signUpButton.addActionListener(e -> {
                String username = usernameField.getText();
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());

                if (signUpUser(username, email, password)) {
                    JOptionPane.showMessageDialog(this, "Account Created Successfully!");
                    dispose();
                    new LoginUserPage().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to create account.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            });

            backButton.addActionListener(e -> {
                dispose();
                new MainPage().setVisible(true);
            });

            // Layout configuration for Sign Up form
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.insets = new Insets(5, 5, 5, 5);
            rightPanel.add(logo, gbc);

            gbc.gridy++;
            rightPanel.add(usernameField, gbc);

            gbc.gridy++;
            rightPanel.add(emailField, gbc);

            gbc.gridy++;
            rightPanel.add(passwordField, gbc);

            gbc.gridy++;
            rightPanel.add(signUpButton, gbc);

            gbc.gridy++;
            rightPanel.add(backButton, gbc);

            return rightPanel;
        }

        private boolean signUpUser(String username, String email, String password) {
            String query = "INSERT INTO USER (username, email, password) VALUES (?, ?, ?)";
            try (Connection conn = DatabaseConnection.getConnection(); 
                 PreparedStatement stmt = conn.prepareStatement(query)) {

                stmt.setString(1, username);
                stmt.setString(2, email);
                stmt.setString(3, password);

                int rowsInserted = stmt.executeUpdate();
                return rowsInserted > 0;

            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
    }
}
