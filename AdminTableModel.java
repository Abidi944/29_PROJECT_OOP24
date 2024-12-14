import javax.swing.table.AbstractTableModel;
import java.util.List;

public class AdminTableModel extends AbstractTableModel {
    private List<Admin> adminList;
    private String[] columnNames = {"ID", "Name", "Email", "Password"};

    public AdminTableModel() {
        this.adminList = AdminCRUD.getAllAdmins();
    }

    public void setAdminList(List<Admin> adminList) {
        this.adminList = adminList;
        fireTableDataChanged(); 
    }

    @Override
    public int getRowCount() {
        return adminList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Admin admin = adminList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return admin.getId();
            case 1:
                return admin.getName();
            case 2:
                return admin.getEmail();
            case 3:
                return admin.getPassword();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
