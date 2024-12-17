package bg.softuni.LinkedOut.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {

    @GetMapping("/employees")
    public String addEmployees(Model model) {
        return "employees-add";
    }

}
