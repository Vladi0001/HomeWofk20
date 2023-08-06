package homework20.homework20.Service;


import homework20.homework20.homework.Employee;

import java.util.Collection;

public interface EmployeeService {

    Employee add(String lastName, String firstName);
    Employee remove(String lastName, String firstName);
    Employee find(String lastName, String firstName);

    Collection<Employee> findAll();
}
