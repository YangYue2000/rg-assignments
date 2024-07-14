public class Main {
    public static void main(String[] args) {
        EmployeeCRUD crud = new EmployeeCRUD();

        // Create
        crud.addEmployee(new Employee(1, "John Doe", "HR"));
        crud.addEmployee(new Employee(2, "Jane Smith", "Finance"));

        // Read
        System.out.println(crud.getEmployee(1).getName());

        // Update
        crud.updateEmployee(new Employee(1, "John Doe", "Marketing"));

        // Delete
        crud.deleteEmployee(2);

        // List
        for (Employee emp : crud.getAllEmployees()) {
            System.out.println(emp.getName() + " - " + emp.getDepartment());
        }
    }
}
