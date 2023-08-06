package homework20.homework20.Service.Mech;

import homework20.homework20.Service.DepartmentService;
import homework20.homework20.Service.EmployeeService;
import homework20.homework20.homework.Employee;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentSeviceImpl implements DepartmentService {
    private EmployeeService employeeService;

    @Override
    public Optional<Employee> minSalaryOfDepartment(int department) {
        return employeeService.findAll().stream()
                .filter(e -> e.getDepartmentId() == department)
                .min(Comparator.comparing(Employee::getSalary));
    }

    @Override
    public Optional<Employee> maxSalaryOfDepartment(int department) {
        return employeeService.findAll().stream()
                .filter(e -> e.getDepartmentId() == department)
                .max(Comparator.comparing(Employee::getSalary));
    }

    @Override
    public Map<Integer, List<Employee>> getAllGroupDepartment() {
        return employeeService.findAll().stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentId));
    }

    @Override
    public List<Employee> getAll(int department) {
        return employeeService.findAll().stream()
                .filter(e -> e.getDepartmentId()==department)
                .collect(Collectors.toList());

    }

}
