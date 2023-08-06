package homework20.homework20.Service;

import homework20.homework20.homework.Employee;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface DepartmentService {
    Optional<Employee> minSalaryOfDepartment(int department);

    Optional<Employee> maxSalaryOfDepartment(int department);

    Map<Integer, List<Employee>> getAllGroupDepartment();


    List<Employee> getAll(int department);


}
