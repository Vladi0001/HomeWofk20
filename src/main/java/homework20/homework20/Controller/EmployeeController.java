package homework20.homework20.Controller;

import homework20.homework20.Service.Mech.EmployeeServiceImpl;
import homework20.homework20.homework.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/hallo")
    public String hallo() {
        return "Привет!";
    }
    @GetMapping("/add")
    public ResponseEntity<Employee> add(@RequestParam String lastName, String firstName) {
        Employee employee = employeeService.add(lastName, firstName);

        return ResponseEntity.ok(employee);
    }

    @GetMapping("/remove")
    public ResponseEntity<Employee> remove(@RequestParam String lastName, String firstName) {
        Employee employee = employeeService.remove(lastName, firstName);
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/find")
    public ResponseEntity<Employee> find(@RequestParam String lastName, String firstName) {
        Employee employee = employeeService.find(lastName, firstName);
        return ResponseEntity.ok(employee);
    }

    @GetMapping
    public ResponseEntity<Collection<Employee>> findAll() {
        Collection<Employee> employees = employeeService.findAll();
        return ResponseEntity.ok(employees);
    }
}
