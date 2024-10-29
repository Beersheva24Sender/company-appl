# Company Management Application

This Java application provides a comprehensive management system for employees within a company, allowing for employee hiring, removal, display, and department-based salary reporting. It also allows administrators to view the departments and manage factors for managers based on specified parameters.

Link TODO: https://github.dev/Beersheva24Telran/company-application/tree/main/src/main/java/telran/employees

## Features

- **Employee Management**: Hire and remove employees, with support for various employee types such as Regular, Wage, Salesperson, and Manager.
- **Department Budgeting**: View departmental salary budgets.
- **Validation**: Input data validation for ID, salary, wage, and hours.
- **Department Listings**: Display all departments within the company.
- **Manager Factor Analysis**: View managers with the highest factor for performance analysis.

## Dependencies

- **CLI-View (telran.view)**: For interactive console input/output
- **company-implementation (telran.employees)**: Company implementation

## Setup

### Prerequisites

- **Java 17** or higher
- **Maven**

## Usage

The application starts with a **main menu** that provides options for managing employees and viewing departmental details. Each feature is accessible through the console menu and is validated to ensure inputs fall within acceptable ranges.

### Key Actions

- **Hire Employee**
  - Select the type of employee to hire (Regular, Wage, Salesperson, or Manager).
  - Enter required fields with validated input for ID, department, salary, and additional parameters (like wage, hours, etc., based on employee type).
  - The application will confirm successful hiring.

- **Display Employee**
  - Enter the employee's ID to retrieve and display their information.
  - If the employee is not found, a message will be displayed.

- **Remove Employee**
  - Enter the employee’s ID to remove them from the company.
  - A confirmation message will be displayed upon successful removal.

- **Display Department Budget**
  - Enter a department name to view its total salary budget.
  - The application displays the department’s budget based on current employees.

- **List Departments**
  - View a list of all departments within the company.

- **Manager Factor Analysis**
  - Display managers with the highest performance factor in the company for comparison and analysis.

### Validation Parameters

Each input is validated to ensure data integrity:

- **ID**: 100000 - 999999
- **Salary**: 5000 - 30000
- **Wage**: 0 - 100
- **Hours Worked**: 0 - 100
- **Factor**: 0 - 10000
- **Percent**: 0 - 10000
- **Sales**: 0 - 10000

For each input, the application prompts the user to enter values within these ranges. If a value is out of range, an error message will be displayed, and the user will be prompted to enter a valid input.

## License

This project is licensed under the MIT License. 
