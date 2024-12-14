import javax.swing.*;

public class AdminDashboardFrame extends JFrame {

    public AdminDashboardFrame() {
        setTitle("Admin Dashboard");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1024, 600);
        setLocationRelativeTo(null);

        AdminDashboard dashboard = new AdminDashboard();
        add(dashboard);
    }
}
