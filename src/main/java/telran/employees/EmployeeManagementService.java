package telran.employees;

public interface EmployeeManagementService {
    public void hireEmployee(Employee employee);

    public String displayEmployee(long id);

    public void removeEmployee(long id);

    public String displaySalaryByDepartment(String departmentName);

    public String displayListDepartments(String departmentList);

    public String displayManagerMostFactor();
}
