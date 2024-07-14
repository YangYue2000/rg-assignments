import java.sql.*;

public class EmployeeJDBC {
    private static final String URL = "jdbc:mysql://localhost:3306/EmployeeDB";
    private static final String USER = "marsyue";
    private static final String PASSWORD = "123456";

    // Create
    public void addEmployee(Employee employee) throws SQLException {
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        String sql = "INSERT INTO employees (id, name, department) VALUES (?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, employee.getId());
        pstmt.setString(2, employee.getName());
        pstmt.setString(3, employee.getDepartment());
        pstmt.executeUpdate();
        conn.close();
    }

    // Read
    public Employee getEmployee(int id) throws SQLException {
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        String sql = "SELECT * FROM employees WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        Employee emp = null;
        if (rs.next()) {
            emp = new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("department"));
        }
        conn.close();
        return emp;
    }

    // Update
    public void updateEmployee(Employee employee) throws SQLException {
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        String sql = "UPDATE employees SET name = ?, department = ? WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, employee.getName());
        pstmt.setString(2, employee.getDepartment());
        pstmt.setInt(3, employee.getId());
        pstmt.executeUpdate();
        conn.close();
    }

    // Delete
    public void deleteEmployee(int id) throws SQLException {
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        String sql = "DELETE FROM employees WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
        conn.close();
    }
}
