package telran.employees;

import telran.view.*;

public class CompanyItems {

    private static EmployeeManagementService service;

    public static Item[] getItems(EmployeeManagementService service) {

        CompanyItems.service = service;

        return new Item[] {
                Item.of("Add Employee", CompanyItems::hireEmployee),
                Item.of("Display Employee", CompanyItems::displayEmployee),
                Item.of("Remove Employee", CompanyItems::removeEmployee),
                Item.of("Display Salary by Department", CompanyItems::displaySalaryByDepartment),
                Item.of("Display Departments", CompanyItems::displayListDepartments),
                Item.of("Display Manager with Most Factor", CompanyItems::displayManagerMostFactor),
                Item.ofExit()
        };
    }

    public static void hireEmployee(InputOutput io) {
        int basicSalary, wage, hours, percent, factor = 0;
        long sales = 0;
        String department = "";
        long id = io.readLong("Enter Employee ID:", "");

        String menuSelection = "Select the employee type: \n 1. Regular Employee \n 2. Wage Employee \n 3. Sales Person \n. 4. Manager";
        long employeeType = io.readInt(menuSelection, "");

        if (employeeType == 1) {

            basicSalary = io.readInt("Enter Employee Basic Salary:", "");
            department = io.readString("Enter Department:");
            Employee employee = new Employee(id, basicSalary, department);
            service.hireEmployee(employee);

        } else if (employeeType == 2) {

            basicSalary = io.readInt("Enter Employee Basic Salary:", "");
            department = io.readString("Enter Department:");
            wage = io.readInt("Enter Wage:", "");
            hours = io.readInt("Enter Hours", "");
            WageEmployee wageEmployee = new WageEmployee(id, basicSalary, department, wage, hours);
            service.hireEmployee(wageEmployee);

        } else if (employeeType == 3) {

            basicSalary = io.readInt("Enter Employee Basic Salary:", "");
            department = io.readString("Enter Department:");
            percent = io.readInt("Enter Percent:", "");
            sales = io.readLong("Enter Sales", "");
            wage = io.readInt("Enter Wage:", "");
            hours = io.readInt("Enter Hours", "");
            SalesPerson salesPerson = new SalesPerson(id, basicSalary, department, wage, hours, percent, sales);
            service.hireEmployee(salesPerson);

        } else {

            basicSalary = io.readInt("Enter Employee Basic Salary:", "");
            department = io.readString("Enter Department:");
            factor = io.readInt("Enter Factor", "");
            Manager manager = new Manager(id, basicSalary, department, factor);
            service.hireEmployee(manager);

        }
        io.writeLine("Employee hired successfully.");
    }

    public static void displayEmployee(InputOutput io) {
        long id = io.readLong("Enter Employee ID:", "");
        String result = service.displayEmployee(id);
        io.writeLine(result);
    }

    public static void removeEmployee(InputOutput io) {
        long id = io.readLong("Enter Employee ID:", "");
        service.removeEmployee(id);
        io.writeLine("Employee removed successfully.");
    }

    public static void displaySalaryByDepartment(InputOutput io) {
        String department = io.readString("Enter Department:");
        String result = service.displaySalaryByDepartment(department);
        io.writeLine(result);
    }

    public static void displayListDepartments(InputOutput io) {
        String result = service.displayListDepartments("");
        io.writeLine(result);
    }

    public static void displayManagerMostFactor(InputOutput io) {
        String result = service.displayManagerMostFactor();
        io.writeLine(result);
    }
}