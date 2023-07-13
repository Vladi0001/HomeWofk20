package Service.Mech;

import homework20.homework20.homework.Employee;
import homework20.homework20.Exception.EmployeeAlreadyAddedException;
import homework20.homework20.Exception.EmployeeNotFoundException;

import java.util.Collection;
import java.util.List;

public class EmployeeService implements Service.EmployeeService {
    private final List<Employee>employees;

    public EmployeeService(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public Employee add(String lastName, String firstName) {
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
        return employees;
    }
}
