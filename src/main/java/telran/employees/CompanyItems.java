package telran.employees;

import java.util.HashSet;
import java.util.List;

import telran.view.*;

public class CompanyItems {

        final static int MIN_SALARY = 5000;
        final static int MAX_SALARY = 30000;
        final static long MIN_ID = 1;
        final static long MAX_ID = 999999;
        final static int MIN_WAGE = 0;
        final static int MAX_WAGE = 100;
        final static int MIN_HOURS = 0;
        final static int MAX_HOURS = 100;
        final static int MIN_FACTOR = 0;
        final static int MAX_FACTOR = 10000;
        final static int MIN_PERCENT = 0;
        final static int MAX_PERCENT = 10000;
        final static int MIN_SALES = 0;
        final static int MAX_SALES = 10000;
        final static String[] DEPARTMENTS = { "QA", "Audit", "Development", "Management" };

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
                long id = getIdInput(io);
                String department = getDepartmentInput(io);
                int basicSalary = getBasicSalaryInput(io);

                Employee employee = new Employee(id, basicSalary, department);
                service.hireEmployee(employee);
                io.writeLine("Regular Employee hired successfully.");
        }

        public static void hireWageEmployee(InputOutput io) {
                long id = getIdInput(io);
                String department = getDepartmentInput(io);
                int basicSalary = getBasicSalaryInput(io);
                int wage = getWageInput(io);
                int hours = getHoursInput(io);

                WageEmployee wageEmployee = new WageEmployee(id, basicSalary, department, wage, hours);
                service.hireEmployee(wageEmployee);
                io.writeLine("Wage Employee hired successfully.");
        }

        public static void hireSalesPerson(InputOutput io) {
                long id = getIdInput(io);
                String department = getDepartmentInput(io);
                int basicSalary = getBasicSalaryInput(io);
                int wage = getWageInput(io);
                int hours = getHoursInput(io);
                int percent = getPercentInput(io);
                long sales = getSalesInput(io);

                SalesPerson salesPerson = new SalesPerson(id, basicSalary, department, wage, hours, percent, sales);
                service.hireEmployee(salesPerson);
                io.writeLine("Sales Person hired successfully.");
        }

        public static void hireManager(InputOutput io) {
                long id = getIdInput(io);
                String department = getDepartmentInput(io);
                int basicSalary = getBasicSalaryInput(io);
                int factor = getFactorInput(io);

                Manager manager = new Manager(id, basicSalary, department, factor);
                service.hireEmployee(manager);
                io.writeLine("Manager hired successfully.");
        }

        private static long getIdInput(InputOutput io) {
                return io.readNumberRange("Enter ID value in the range [" + MIN_ID + "-" + MAX_ID + "]",
                                "Wrong ID value", MIN_ID, MAX_ID).longValue();
        }

        private static String getDepartmentInput(InputOutput io) {
                HashSet<String> departmentsSet = new HashSet<>(List.of(DEPARTMENTS));
                return io.readStringOptions("Enter department from " + departmentsSet,
                                "Must be one out from " + departmentsSet,
                                departmentsSet);
        }

        private static int getBasicSalaryInput(InputOutput io) {
                return io.readNumberRange("Enter salary value in the range [" + MIN_SALARY + "-" + MAX_SALARY + "]",
                                "Wrong salary value", MIN_SALARY, MAX_SALARY).intValue();
        }

        private static int getWageInput(InputOutput io) {
                return io.readNumberRange("Enter Wage value in the range [" + MIN_WAGE + "-" + MAX_WAGE + "]",
                                "Wrong wage value", MIN_WAGE, MAX_WAGE).intValue();
        }

        private static int getHoursInput(InputOutput io) {
                return io.readNumberRange("Enter Hours Worked in the range [" + MIN_HOURS + "-" + MAX_HOURS + "]",
                                "Wrong hours value", MIN_HOURS, MAX_HOURS).intValue();
        }

        private static int getPercentInput(InputOutput io) {
                return io.readNumberRange("Enter Percent value in the range [" + MIN_PERCENT + "-" + MAX_PERCENT + "]",
                                "Wrong percent value", MIN_PERCENT, MAX_PERCENT).intValue();
        }

        private static long getSalesInput(InputOutput io) {
                return io.readNumberRange("Enter Sales value in the range [" + MIN_SALES + "-" + MAX_SALES + "]",
                                "Wrong sales value", MIN_SALES, MAX_SALES).longValue();
        }

        private static int getFactorInput(InputOutput io) {
                return io.readNumberRange("Enter Factor value in the range [" + MIN_FACTOR + "-" + MAX_FACTOR + "]",
                                "Wrong factor value", MIN_FACTOR, MAX_FACTOR).intValue();
        }

        public static void displayEmployee(InputOutput io) {
                long id = io.readNumberRange(String.format("Enter ID value in the range [%d-%d]", MIN_ID, MAX_ID),
                                "Wrong ID value", MIN_ID, MAX_ID).longValue();
                String result = service.displayEmployee(id);
                io.writeLine(result);
        }

        public static void removeEmployee(InputOutput io) {
                long id = io.readNumberRange(String.format("Enter ID value in the range [%d-%d]", MIN_ID, MAX_ID),
                                "Wrong ID value", MIN_ID, MAX_ID).longValue();
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