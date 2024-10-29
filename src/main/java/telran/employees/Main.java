package telran.employees;

import telran.io.Persistable;
import telran.view.*;

public class Main {
    public static void main(String[] args) {
        Company company = new CompanyImpl();

        EmployeeManagementService service = new EmployeeManagementServiceImpl(company);
        
        if (company instanceof Persistable persistable) {
            persistable.restoreFromFile("employees.data");
        }

        Item[] items = CompanyItems.getItems(service);

        Menu menu = new Menu("Company Application", items);
        menu.perform(new StandardInputOutput());
    }
}