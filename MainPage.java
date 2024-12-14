import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainPage extends JFrame {

    public MainPage() {
        setTitle("SaSaMbo - Main Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(1024, 600);
        setLocationRelativeTo(null); // Tengah layar

        // Left Panel (Illustration)
        JPanel leftPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Warna latar hijau
                g2d.setColor(new Color(82, 99, 70));
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        leftPanel.setLayout(new BorderLayout());

        // Gambar ilustrasi
        JLabel illustration = new JLabel(new ImageIcon("asset/foto animasi sasambo.png"));
        illustration.setHorizontalAlignment(SwingConstants.CENTER);

        // Teks pada panel kiri
        JLabel leftText = new JLabel("<html><div style='text-align: center; color: white; font-size: 20px;'>"
                + "Jelajahi warisan,<br>temukan sejarah<br>dan hayati budaya!</div></html>");
        leftText.setHorizontalAlignment(SwingConstants.CENTER);
        leftText.setVerticalAlignment(SwingConstants.BOTTOM);
        leftText.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Padding teks

        leftPanel.add(illustration, BorderLayout.CENTER);
        leftPanel.add(leftText, BorderLayout.SOUTH);
        add(leftPanel, BorderLayout.WEST);

        // Right Panel (Form Login)
        JPanel rightPanel = new JPanel(new GridBagLayout());
        rightPanel.setPreferredSize(new Dimension(600, 600));
        rightPanel.setBackground(Color.WHITE);

        // Logo dan teks
        JLabel logo = new JLabel("SASAMBO");
        logo.setFont(new Font("SansSerif", Font.BOLD, 28));
        logo.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel welcome = new JLabel("<html><div style='text-align: center; color: #526346;'>Hi, Selamat Datang Kembali!</div></html>");
        welcome.setFont(new Font("SansSerif", Font.BOLD, 20));

        JLabel subtext = new JLabel("<html><div style='text-align: center; color: gray;'>Hello again, you've been missed!</div></html>");
        subtext.setFont(new Font("SansSerif", Font.PLAIN, 14));
        
        // Tombol login
        JButton loginAsAdmin = new JButton("Login As Admin");
        JButton loginAsUser = new JButton("Login As User");
        JLabel orLabel = new JLabel("-OR-");
        orLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        orLabel.setForeground(Color.GRAY);

        // Styling tombol
        loginAsAdmin.setFocusPainted(false);
        loginAsUser.setFocusPainted(false);
        loginAsAdmin.setPreferredSize(new Dimension(200, 40));
        loginAsUser.setPreferredSize(new Dimension(200, 40));

        // Action Listeners untuk tombol
        loginAsAdmin.addActionListener((ActionEvent e) -> {
            dispose(); // Tutup MainPage
            new AdminLoginPage().setVisible(true); // Navigasi ke AdminLoginPage
        });

        loginAsUser.addActionListener((ActionEvent e) -> {
            dispose(); // Tutup MainPage
            new LoginUserPage().setVisible(true); // Navigasi ke LoginPage
        });

        // Menambahkan komponen ke Right Panel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10); // Margin antar komponen
        rightPanel.add(logo, gbc);

        gbc.gridy++;
        rightPanel.add(welcome, gbc);

        gbc.gridy++;
        rightPanel.add(subtext, gbc);

        gbc.gridy++;
        rightPanel.add(loginAsAdmin, gbc);

        gbc.gridy++;
        rightPanel.add(orLabel, gbc);

        gbc.gridy++;
        rightPanel.add(loginAsUser, gbc);

        add(rightPanel, BorderLayout.CENTER);
    }
}
