package bg.softuni.LinkedOut.web;

import bg.softuni.LinkedOut.model.entity.Employee;
import bg.softuni.LinkedOut.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AllEmployeeController {

    private final EmployeeService employeeService;

    public AllEmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees/all")
    public String allEmployees(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "employee-all";
    }

}
