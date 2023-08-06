package homework20.homework20.Controller;

import homework20.homework20.Service.DepartmentService;
import homework20.homework20.homework.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @GetMapping("/minSalary")
        public Optional<Employee> minSalaryOfDepartment(@RequestParam int department){
        return departmentService.minSalaryOfDepartment(department);
    }

    @GetMapping("/maxSalary")
    public Optional<Employee> maxSalaryOfDepartment(@RequestParam int department){
        return departmentService.maxSalaryOfDepartment(department);
    }

    @GetMapping("/getAllByDepartment")
    public List<Employee> getAllOfDepartment(@RequestParam int department){
        return departmentService.getAll(department);
    }

    @GetMapping("/getAllGroupDepartment")
    public Map<Integer, List<Employee>> getAllGroupDepartment(){
        return departmentService.getAllGroupDepartment();
    }
}
