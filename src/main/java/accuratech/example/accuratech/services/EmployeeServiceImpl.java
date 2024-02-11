package accuratech.example.accuratech.services;

import accuratech.example.accuratech.entity.EmployeeEntity;
import accuratech.example.accuratech.model.Employee;
import accuratech.example.accuratech.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    //Implementation of create employee method
    @Override
    public Employee createEmployee(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();

        BeanUtils.copyProperties(employee,employeeEntity);
        employeeRepository.save(employeeEntity);
        return employee;
    }

    //Implementation of get all employees method
    @Override
    public List<Employee> getAllEmployees() {
        List<EmployeeEntity> employeeEntities
                = employeeRepository.findAll();

        List<Employee> employees = employeeEntities
                .stream()
                .map(emp -> new Employee(
                        emp.getId(),
                        emp.getFirstName(),
                        emp.getLastName(),
                        emp.getSummary(),
                        emp.getDob(),
                        emp.getDsDivision()))
                .collect(Collectors.toList());
        return employees;
    }

    //Implementation of delete employee method
    @Override
    public boolean deleteEmployee(Long id) {
        EmployeeEntity employee = employeeRepository.findById(id).get();
        employeeRepository.delete(employee);
        return true;
    }

    //Implementation of get employee by id method
    @Override
    public Employee getEmployeeById(Long id) {
        EmployeeEntity employeeEntity
                = employeeRepository.findById(id).get();
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeEntity,employee);
        return employee;
    }

    //Implementation of update employee method
    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        EmployeeEntity employeeEntity
                = employeeRepository.findById(id).get();
        employeeEntity.setFirstName(employee.getFirstName());
        employeeEntity.setLastName(employee.getLastName());
        employeeEntity.setSummary(employee.getSummary());
        employeeEntity.setDob(employee.getDob());
        employeeEntity.setDsDivision(employee.getDsDivision());

        employeeRepository.save(employeeEntity);
        return employee;
    }
}
