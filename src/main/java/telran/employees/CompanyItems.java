package telran.employees;

import telran.view.*;

public class CompanyItems {

    private static EmployeeManagementService service;

    public static Item[] getItems(EmployeeManagementService service) {
        CompanyItems.service = service;

        return new Item[] {
                Item.of("Hire Employee", CompanyItems::hireEmployee),
                Item.of("Display Employee", CompanyItems::displayEmployee),
                Item.of("Remove Employee", CompanyItems::removeEmployee),
                Item.of("Display Salary by Department",
                        CompanyItems::displaySalaryByDepartment),
                Item.of("Display Departments", CompanyItems::displayListDepartments),
                Item.of("Display Manager with Most Factor",
                        CompanyItems::displayManagerMostFactor),
                Item.ofExit()
        };
    }

    public static void hireEmployee(InputOutput io) {
        Item[] addEmployeeItems = getAddEmployeeItems();
        Menu menu = new Menu("Hire Employee", addEmployeeItems);
        menu.perform(io);
    }

    private static Item[] getAddEmployeeItems() {
        return new Item[] {
                Item.of("Hire Regular Employee", CompanyItems::HireRegularEmployee),
                Item.of("Hire Wage Employee", CompanyItems::hireWageEmployee),
                Item.of("Hire Sales Person", CompanyItems::hireSalesPerson),
                Item.of("Hire Manager", CompanyItems::hireManager),
                Item.ofExit()  
        };
    }

    public static void HireRegularEmployee(InputOutput io) {
        long id = io.readLong("Enter Employee ID:", "");
        String department = io.readString("Enter Department:");
        int basicSalary = io.readInt("Enter Employee Basic Salary:", "");
        Employee employee = new Employee(id, basicSalary, department);
        service.hireEmployee(employee);
        io.writeLine("Regular Employee hired successfully.");
    }
    
    public static void hireWageEmployee(InputOutput io) {
        long id = io.readLong("Enter Employee ID:", "");
        String department = io.readString("Enter Department:");
        int basicSalary = io.readInt("Enter Employee Basic Salary:", "");
        int wage = io.readInt("Enter Wage:", "");
        int hours = io.readInt("Enter Hours Worked:", "");
        WageEmployee wageEmployee = new WageEmployee(id, basicSalary, department, wage, hours);
        service.hireEmployee(wageEmployee);
        io.writeLine("Wage Employee hired successfully.");
    }
    
    public static void hireSalesPerson(InputOutput io) {
        long id = io.readLong("Enter Employee ID:", "");
        String department = io.readString("Enter Department:");
        int basicSalary = io.readInt("Enter Employee Basic Salary:", "");
        int wage = io.readInt("Enter Wage:", "");
        int hours = io.readInt("Enter Hours Worked:", "");
        int percent = io.readInt("Enter Percent:", "");
        long sales = io.readLong("Enter Sales", "");
        SalesPerson salesPerson = new SalesPerson(id, basicSalary, department, wage, hours, percent, sales);
        service.hireEmployee(salesPerson);
        io.writeLine("Sales Person hired successfully");
    }
    
    public static void hireManager(InputOutput io) {
        long id = io.readLong("Enter Employee ID:", "");
        String department = io.readString("Enter Department:");
        int basicSalary = io.readInt("Enter Employee Basic Salary:", "");
        int factor = io.readInt("Enter Factor", "");
        Manager manager = new Manager(id, basicSalary, department, factor);
        service.hireEmployee(manager);
        io.writeLine("Manager hired successfully");
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