package homework20.homework20.Service.impl;

import homework20.homework20.Service.EmployeeService;
import homework20.homework20.Service.EmployeeValidationServece;
import homework20.homework20.homework.Employee;
import homework20.homework20.Exception.EmployeeAlreadyAddedException;
import homework20.homework20.Exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final List<Employee>employees;
    private final EmployeeValidationServece validationServece;

    public EmployeeServiceImpl(List<Employee> employees, EmployeeValidationServece validationServece) {

        this.employees = employees;

        this.validationServece = validationServece;
    }

    @Override
    public Employee add(String lastName, String firstName) {
        validationServece.validate(firstName,lastName);
        Employee employee = new Employee( firstName, lastName);
        if (employees.contains(employee)){
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(employee);
        return employee;
    }


    @Override
    public Employee remove(String lastName, String firstName) {
        Employee employee = new Employee( firstName, lastName);
        if (!employees.contains(employee)){
            throw new EmployeeNotFoundException();
        }
        employees.remove(employee);
        return employee;
    }

    @Override
    public Employee find(String lastName, String firstName) {
        Employee employee = new Employee( firstName, lastName);
        if (!employees.contains(employee)){
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableList(employees);
    }
}
