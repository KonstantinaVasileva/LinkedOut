package bg.softuni.LinkedOut.web;

import bg.softuni.LinkedOut.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class EmployeeDetailsController {

    private final EmployeeService employeeService;
    public EmployeeDetailsController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees/{id}")
    public String employeeDetails(@PathVariable("id") String id, Model model) {
        model.addAttribute("employee", employeeService.getEmployee(id));
        return "employee-details";
    }

}
