import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReviewPanel extends JPanel {
    private JTextField namaKebudayaanField;
    private JTextField ratingField;
    private JTextArea komentarTextArea;
    private JButton editButton;
    private JButton saveButton;

    public ReviewPanel() {
        setLayout(new BorderLayout());
        setBackground(new Color(255, 255, 255)); // Background putih luar

        // Container utama
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBackground(new Color(82, 99, 70)); // Hijau tua
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Panel hijau muda untuk Nama Kebudayaan, Rating, dan Komentar
        JPanel greenPanel = new JPanel();
        greenPanel.setBackground(new Color(215, 225, 212)); // Warna D7E1D4
        greenPanel.setLayout(new GridBagLayout());
        GridBagConstraints greenGbc = new GridBagConstraints();
        greenGbc.fill = GridBagConstraints.HORIZONTAL;
        greenGbc.insets = new Insets(10, 10, 10, 10);

        // Set preferred size untuk greenPanel agar lebih besar
        greenPanel.setPreferredSize(new Dimension(300, 350)); // Menyesuaikan dengan isi panel

        // Nama Kebudayaan
        JLabel namaLabel = new JLabel("Nama Kebudayaan");
        namaLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        namaLabel.setForeground(Color.BLACK);
        greenGbc.gridx = 0;
        greenGbc.gridy = 0;
        greenPanel.add(namaLabel, greenGbc);

        namaKebudayaanField = new JTextField();
        namaKebudayaanField.setFont(new Font("Arial", Font.PLAIN, 16));
        namaKebudayaanField.setPreferredSize(new Dimension(250, 30)); // Memperbesar input field
        greenGbc.gridx = 0;
        greenGbc.gridy = 1;
        greenPanel.add(namaKebudayaanField, greenGbc);

        // Rating
        JLabel ratingLabel = new JLabel("Rating");
        ratingLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        ratingLabel.setForeground(Color.BLACK);
        greenGbc.gridx = 0;
        greenGbc.gridy = 2;
        greenPanel.add(ratingLabel, greenGbc);

        ratingField = new JTextField();
        ratingField.setFont(new Font("Arial", Font.PLAIN, 16));
        ratingField.setPreferredSize(new Dimension(250, 30)); // Memperbesar input field
        greenGbc.gridx = 0;
        greenGbc.gridy = 3;
        greenPanel.add(ratingField, greenGbc);

        // Komentar
        JLabel komentarLabel = new JLabel("Komentar");
        komentarLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        komentarLabel.setForeground(Color.BLACK);
        greenGbc.gridx = 0;
        greenGbc.gridy = 4;
        greenPanel.add(komentarLabel, greenGbc);

        komentarTextArea = new JTextArea();
        komentarTextArea.setFont(new Font("Arial", Font.PLAIN, 16));
        komentarTextArea.setLineWrap(true);
        komentarTextArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(komentarTextArea);
        scrollPane.setPreferredSize(new Dimension(250, 100)); // Memperbesar area komentar
        greenGbc.gridx = 0;
        greenGbc.gridy = 5;
        greenPanel.add(scrollPane, greenGbc);

        // Tambahkan greenPanel ke mainPanel
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(greenPanel, gbc);

        // Tombol Edit dan Save
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(82, 99, 70));
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));

        editButton = new JButton("Save");
        saveButton = new JButton("Done");
        saveButton.setVisible(false);

        buttonPanel.add(editButton);
        buttonPanel.add(saveButton);
        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(buttonPanel, gbc);

        // Action listeners untuk tombol
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                namaKebudayaanField.setEditable(true);
                ratingField.setEditable(true);
                komentarTextArea.setEditable(true);
                editButton.setVisible(false);
                saveButton.setVisible(true);
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                namaKebudayaanField.setEditable(false);
                ratingField.setEditable(false);
                komentarTextArea.setEditable(false);
                saveButton.setVisible(false);
                editButton.setVisible(true);
            }
        });

        // Tambahkan ke panel utama
        add(mainPanel, BorderLayout.CENTER);
    }
}
