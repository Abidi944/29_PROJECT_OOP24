import javax.swing.SwingUtilities;

public class SaSaMboApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginPage().setVisible(true));
    }
}
