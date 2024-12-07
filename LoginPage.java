import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;

public class LoginPage extends JFrame implements Navigable {
    public LoginPage() {
        setTitle("Login - SaSaMbo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(1024, 600);

        // Left Panel (Illustration)
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(new Color(46, 77, 46)); // Samakan dengan warna di gambar
        leftPanel.setLayout(new BorderLayout());

        // Gambar ilustrasi dan teks
        JLabel illustration = new JLabel(new ImageIcon("C:\\Users\\ADIT\\OneDrive\\Documents\\SEMESTER 5\\PBO\\coba\\ppp\\asset\\foto animasi sasambo.png"));
        illustration.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel leftText = new JLabel("<html><div style='text-align: center; color: white; font-size: 18px;'>Jelajahi warisan, temukan sejarah<br>dan hayati budaya!</div></html>");
        leftText.setHorizontalAlignment(SwingConstants.CENTER);
        leftText.setVerticalAlignment(SwingConstants.BOTTOM);
        leftText.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        leftPanel.add(illustration, BorderLayout.CENTER);
        leftPanel.add(leftText, BorderLayout.SOUTH);
        add(leftPanel, BorderLayout.WEST);


        // Right Panel (Login Form)
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridBagLayout());
        rightPanel.setBackground(Color.WHITE);

        JLabel logo = new JLabel("SaSaMbo");
        logo.setFont(new Font("SansSerif", Font.BOLD, 24));
        logo.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel welcome = new JLabel("Hi, Selamat Datang Kembali!");
        welcome.setFont(new Font("SansSerif", Font.PLAIN, 16));

        JButton googleLogin = new JButton("Login dengan Google");
        JButton facebookLogin = new JButton("Login dengan Facebook");

        JLabel orLabel = new JLabel("-OR-");

        JTextField emailField = new JTextField(20);
        emailField.setBorder(BorderFactory.createTitledBorder("Alamat Email"));

        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setBorder(BorderFactory.createTitledBorder("Kata Sandi"));

        JButton loginButton = new JButton("Masuk");
        JLabel signUpLabel = new JLabel("Belum punya akun? Daftar");
        signUpLabel.setForeground(Color.BLUE);
        signUpLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // Action Listeners
        signUpLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dispose();
                new SignUpPage().setVisible(true);
            }
        });

        // Login Button ActionListener
        loginButton.addActionListener(e -> {
            // Cek validasi login di sini (username, password)
            // Jika login berhasil, pindah ke HomePage
            new HomePage().setVisible(true);
            dispose();
        });

        // Adding Components
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
        rightPanel.add(logo, gbc);

        gbc.gridy++;
        rightPanel.add(welcome, gbc);

        gbc.gridy++;
        rightPanel.add(googleLogin, gbc);

        gbc.gridy++;
        rightPanel.add(facebookLogin, gbc);

        gbc.gridy++;
        rightPanel.add(orLabel, gbc);

        gbc.gridy++;
        rightPanel.add(emailField, gbc);

        gbc.gridy++;
        rightPanel.add(passwordField, gbc);

        gbc.gridy++;
        rightPanel.add(loginButton, gbc);

        gbc.gridy++;
        rightPanel.add(signUpLabel, gbc);

        add(rightPanel, BorderLayout.CENTER);
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
}
