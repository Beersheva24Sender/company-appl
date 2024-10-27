package telran.employees;

public class EmployeeManagementServiceImpl implements EmployeeManagementService {
    private Company company;

    public EmployeeManagementServiceImpl(Company company) {
        this.company = company;
    }

    @Override
    public void hireEmployee(Employee employee) {
        company.addEmployee(employee);
    }

    @Override
    public String displayEmployee(long id) {
        Employee employee = company.getEmployee(id);
        return employee != null ? employee.toString() : "Employee not found";
    }

    @Override
    public void removeEmployee(long id) {
        Employee removedEmployee = company.removeEmployee(id);
        if (removedEmployee == null) {
            System.out.println("Employee not found");
        }
    }

    @Override
    public String displaySalaryByDepartment(String departmentName) {
        int budget = company.getDepartmentBudget(departmentName);
        return "Department: " + departmentName + ", Budget: " + budget;
    }

    @Override
    public String displayListDepartments(String departmentList) {
        String[] departments = company.getDepartments();
        return String.join(", ", departments);
    }

    @Override
    public String displayManagerMostFactor() {
        Manager[] managers = company.getManagersWithMostFactor();
        StringBuilder sb = new StringBuilder("Managers with the highest factor:\n");
        for (Manager manager : managers) {
            sb.append(manager).append("\n");
        }
        return sb.toString();
    }

}
