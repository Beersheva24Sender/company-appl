package telran.employees;

import telran.view.*;

public class Main {
    public static void main(String[] args) {
       Company company = new CompanyImpl();
       
/*        if (company instanceof Persistable persistable) {
           persistable.restoreFromFile("employees.data");
       } */

       EmployeeManagementService service = new EmployeeManagementServiceImpl(company);

       Item[] items = CompanyItems.getItems(service);

       Menu menu = new Menu("Company Application", items);
       menu.perform(new StandardInputOutput());
    }
}
