import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class ProfilePanel extends JPanel {
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton editButton;
    private JLabel avatarLabel;
    private JLabel nameLabel;

    // Constructor
    public ProfilePanel() {
        setLayout(new BorderLayout());
        setBackground(new Color(244, 244, 244)); 

        // Main profile container
        JPanel profilePanel = new JPanel();
        profilePanel.setLayout(new BoxLayout(profilePanel, BoxLayout.Y_AXIS));
        profilePanel.setBackground(new Color(82, 99, 70)); 
        profilePanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Avatar (Circle with + icon or image)
        avatarLabel = new JLabel("+", SwingConstants.CENTER);
        avatarLabel.setFont(new Font("Arial", Font.BOLD, 40));
        avatarLabel.setOpaque(true);
        avatarLabel.setBackground(Color.WHITE);
        avatarLabel.setForeground(Color.BLACK);
        avatarLabel.setPreferredSize(new Dimension(120, 120));
        avatarLabel.setMaximumSize(new Dimension(120, 120));
        avatarLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        avatarLabel.setBorder(BorderFactory.createLineBorder(new Color(82, 99, 70), 5, true));

        try {
            String imagePath = "asset/Logo.jpg"; 
            File imageFile = new File(imagePath);
            ImageIcon avatarIcon = new ImageIcon(ImageIO.read(imageFile));
            Image avatarImage = avatarIcon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
            avatarLabel.setIcon(new ImageIcon(avatarImage)); 
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(ProfilePanel.this, "Error loading image: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        profilePanel.add(Box.createRigidArea(new Dimension(0, 20))); 
        profilePanel.add(avatarLabel);

        // Name Label
        nameLabel = new JLabel("Loading...", SwingConstants.CENTER); 
        nameLabel.setFont(new Font("Arial", Font.BOLD, 18));
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        profilePanel.add(Box.createRigidArea(new Dimension(0, 10))); 
        profilePanel.add(nameLabel);

        // Email Field
        JPanel emailPanel = new JPanel();
        emailPanel.setLayout(new BoxLayout(emailPanel, BoxLayout.Y_AXIS));
        emailPanel.setBackground(new Color(215, 225, 212));
        emailPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Padding
        JLabel emailLabel = new JLabel("Email");
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        emailLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        emailField = new JTextField();
        emailField.setFont(new Font("Arial", Font.PLAIN, 14));
        emailField.setEditable(false);
        emailPanel.add(emailLabel);
        emailPanel.add(emailField);
        profilePanel.add(Box.createRigidArea(new Dimension(0, 10)));
        profilePanel.add(emailPanel);

        // Password Field
        JPanel passwordPanel = new JPanel();
        passwordPanel.setLayout(new BoxLayout(passwordPanel, BoxLayout.Y_AXIS));
        passwordPanel.setBackground(new Color(215, 225, 212));
        passwordPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        passwordLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Arial", Font.PLAIN, 14));
        passwordField.setEditable(false);
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordField);
        profilePanel.add(Box.createRigidArea(new Dimension(0, 10)));
        profilePanel.add(passwordPanel);

        // Edit Button
        editButton = new JButton("Edit");
        editButton.setFont(new Font("Arial", Font.PLAIN, 18));
        editButton.setBackground(new Color(82, 99, 70));
        editButton.setForeground(Color.WHITE);
        editButton.setFocusPainted(false);
        editButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        editButton.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15)); 
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (emailField.isEditable()) {
                    emailField.setEditable(false);
                    passwordField.setEditable(false);
                    editButton.setText("Edit");
                } else {
                    emailField.setEditable(true);
                    passwordField.setEditable(true);
                    editButton.setText("Save");
                }
            }
        });
        profilePanel.add(Box.createRigidArea(new Dimension(0, 20)));
        profilePanel.add(editButton);

        add(profilePanel, BorderLayout.CENTER);

        loadUserData();
    }

    private void loadUserData() {
        String name = UserSession.getName();  
        String email = UserSession.getEmail(); 
        String password = UserSession.getPassword(); 

        nameLabel.setText(name);
        emailField.setText(email);
        passwordField.setText(password);
    }
}
