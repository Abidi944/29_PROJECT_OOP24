import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AdminDashboard extends JPanel {
    private JButton addButton;
    private JTable adminTable;
    private AdminTableModel adminTableModel;

    public AdminDashboard() {
        setLayout(new BorderLayout());
        setBackground(new Color(244, 244, 244));

        // Title Panel
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel titleLabel = new JLabel("Admin Dashboard");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titlePanel.setBackground(new Color(82, 99, 70));
        titlePanel.add(titleLabel);
        add(titlePanel, BorderLayout.NORTH);

        // Admin Table Panel
        adminTableModel = new AdminTableModel();
        adminTable = new JTable(adminTableModel);
        JScrollPane scrollPane = new JScrollPane(adminTable);
        add(scrollPane, BorderLayout.CENTER);

        // Buttons Panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        addButton = new JButton("Add Admin");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openAddAdminDialog();
            }
        });
        buttonPanel.add(addButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Load data
        loadAdminData();
    }

    private void loadAdminData() {
        List<Admin> adminList = AdminCRUD.getAllAdmins();
        adminTableModel.setAdminList(adminList);
    }

    private void openAddAdminDialog() {
        // Implementasi dialog add admin
    }
}
