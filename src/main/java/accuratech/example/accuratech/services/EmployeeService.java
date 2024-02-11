package accuratech.example.accuratech.services;

import accuratech.example.accuratech.model.Employee;

import java.util.List;

//Interface for the service
public interface EmployeeService {
        Employee createEmployee(Employee employee);

        List<Employee> getAllEmployees();

        boolean deleteEmployee(Long id);

        Employee getEmployeeById(Long id);

        Employee updateEmployee(Long id, Employee employee);
}
