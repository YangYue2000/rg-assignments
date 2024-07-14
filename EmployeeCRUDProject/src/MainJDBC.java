import java.sql.SQLException;

public class MainJDBC {
    public static void main(String[] args) throws SQLException {
        EmployeeJDBC jdbc = new EmployeeJDBC();
        try {
            // Create
            jdbc.addEmployee(new Employee(1, "John Doe", "HR"));
            jdbc.addEmployee(new Employee(2, "Jane Smith", "Finance"));

            // Read
            System.out.println(jdbc.getEmployee(1).getName());

            // Update
            jdbc.updateEmployee(new Employee(1, "John Doe", "Marketing"));

            // Delete
            jdbc.deleteEmployee(2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
