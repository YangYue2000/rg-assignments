import java.util.ArrayList;
import java.util.List;

public class EmployeeCRUD {
    private List<Employee> employees = new ArrayList<>();

    // Create
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    // Read
    public Employee getEmployee(int id) {
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                return emp;
            }
        }
        return null;
    }

    // Update
    public void updateEmployee(Employee employee) {
        Employee emp = getEmployee(employee.getId());
        if (emp != null) {
            emp.setName(employee.getName());
            emp.setDepartment(employee.getDepartment());
        }
    }

    // Delete
    public void deleteEmployee(int id) {
        Employee emp = getEmployee(id);
        if (emp != null) {
            employees.remove(emp);
        }
    }

    // List all employees
    public List<Employee> getAllEmployees() {
        return employees;
    }
}
