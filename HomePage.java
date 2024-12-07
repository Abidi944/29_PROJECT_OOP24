import javax.swing.*;
import java.awt.*;

public class HomePage extends JFrame implements Navigable {
    public HomePage() {
        // Set up frame
        setTitle("SaSaMbo - Home");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel header
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(Color.WHITE);
        headerPanel.setPreferredSize(new Dimension(1200, 60));

        JLabel logoLabel = new JLabel();
        logoLabel.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\ADIT\\OneDrive\\Documents\\SEMESTER 5\\PBO\\coba\\ppp\\asset\\logo.jpeg").getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH))); // Replace "sasambo_logo.png" with the path to your logo image file
        logoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        logoLabel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 0));
        headerPanel.add(logoLabel, BorderLayout.WEST);

        JPanel menuPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        menuPanel.setBackground(Color.WHITE);
        JButton homeButton = new JButton("Home");
        JButton reviewButton = new JButton("Review");
        JButton profileButton = new JButton("Profil");
        menuPanel.add(homeButton);
        menuPanel.add(reviewButton);
        menuPanel.add(profileButton);
        headerPanel.add(menuPanel, BorderLayout.CENTER);

        JTextField searchField = new JTextField(20);
        searchField.setText("Selamat Datang, Adit");
        searchField.setHorizontalAlignment(JTextField.RIGHT);
        searchField.setEditable(false);
        headerPanel.add(searchField, BorderLayout.EAST);

        add(headerPanel, BorderLayout.NORTH);

        // Main panel setup
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Panel kategori
        JPanel categoryPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        categoryPanel.setBackground(Color.WHITE);
        categoryPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton historyButton = new JButton("Sejarah");
        JButton fictionButton = new JButton("Fiksi");
        JButton horrorButton = new JButton("Horor");

        historyButton.setBackground(new Color(255, 204, 204));
        fictionButton.setBackground(new Color(255, 102, 102));
        horrorButton.setBackground(new Color(255, 51, 51));

        categoryPanel.add(historyButton);
        categoryPanel.add(fictionButton);
        categoryPanel.add(horrorButton);

        mainPanel.add(categoryPanel, BorderLayout.NORTH);

        // Panel rekomendasi
        JPanel recommendationPanel = new JPanel(new BorderLayout());
        recommendationPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        JLabel recommendationLabel = new JLabel("Rekomendasi Untuk Anda", JLabel.LEFT);
        recommendationLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        recommendationPanel.add(recommendationLabel, BorderLayout.NORTH);

        JPanel recommendationsGrid = new JPanel(new GridLayout(2, 4, 10, 10));
        for (int i = 0; i < 8; i++) {
            JPanel posterPanel = new JPanel();
            posterPanel.setBackground(new Color(255, 204, 204));
            recommendationsGrid.add(posterPanel);
        }
        recommendationPanel.add(recommendationsGrid, BorderLayout.CENTER);

        mainPanel.add(recommendationPanel, BorderLayout.CENTER);

        // Panel trending dan terbaru
        JPanel trendingPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        trendingPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel trendingLabel = new JLabel("Trending", JLabel.LEFT);
        trendingLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        trendingPanel.add(trendingLabel);

        JPanel trendingGrid = new JPanel(new GridLayout(1, 4, 10, 10));
        for (int i = 0; i < 4; i++) {
            JPanel posterPanel = new JPanel();
            posterPanel.setBackground(new Color(255, 204, 204));
            trendingGrid.add(posterPanel);
        }
        trendingPanel.add(trendingGrid);

        JLabel newLabel = new JLabel("Terbaru", JLabel.LEFT);
        newLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        trendingPanel.add(newLabel);

        JPanel newGrid = new JPanel(new GridLayout(1, 4, 10, 10));
        for (int i = 0; i < 4; i++) {
            JPanel posterPanel = new JPanel();
            posterPanel.setBackground(new Color(255, 204, 204));
            newGrid.add(posterPanel);
        }
        trendingPanel.add(newGrid);

        mainPanel.add(trendingPanel, BorderLayout.SOUTH);

        add(mainPanel, BorderLayout.CENTER);

        // Panel deskripsi
        JPanel descriptionPanel = new JPanel(new BorderLayout());
        descriptionPanel.setBackground(new Color(204, 255, 204));
        descriptionPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel mapImageLabel = new JLabel();
        mapImageLabel.setIcon(new ImageIcon("C:\\Users\\ADIT\\OneDrive\\Documents\\SEMESTER 5\\PBO\\coba\\ppp\\asset\\th.png")); // Replace "map_ntb.png" with the path to your map image file
        mapImageLabel.setHorizontalAlignment(JLabel.CENTER);
        descriptionPanel.add(mapImageLabel, BorderLayout.NORTH);

        JTextArea descriptionText = new JTextArea(
                "SaSaMbo adalah singkatan dari tiga kelompok etnis utama di Pulau Lombok, yaitu Sasak, Samawa, dan Mbojo. " +
                        "Ketiganya mencerminkan kekayaan budaya yang beragam, mulai dari tradisi, seni, bahasa, hingga nilai-nilai adat yang unik. " +
                        "SaSaMbo bukan hanya simbol keberagaman, tetapi juga bukti nyata harmoni dalam perbedaan. Melalui pelestarian budaya SaSaMbo, kita tidak hanya menjaga warisan leluhur tetapi juga mengenalkan dunia pada keindahan Lombok yang kaya akan sejarah dan nilai budaya.");
        descriptionText.setLineWrap(true);
        descriptionText.setWrapStyleWord(true);
        descriptionText.setEditable(false);
        descriptionText.setFont(new Font("SansSerif", Font.PLAIN, 14));
        descriptionText.setBackground(new Color(204, 255, 204));
        descriptionPanel.add(descriptionText, BorderLayout.CENTER);

        add(descriptionPanel, BorderLayout.EAST);

        setVisible(true);
    }

    // Implementing methods from Navigable interface
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
