package bg.softuni.LinkedOut.web;

import bg.softuni.LinkedOut.model.dto.AddEmployeeDTO;
import bg.softuni.LinkedOut.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/employees")
public class AddEmployeeController {

    private final EmployeeService employeeService;

    public AddEmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public String addEmployees(Model model) {
        if (!model.containsAttribute("addEmployeeDTO")) {
            model.addAttribute("addEmployeeDTO", AddEmployeeDTO.empty());
        }
        return "employee-add";
    }

    @PostMapping("/add")
    public String addEmployees(AddEmployeeDTO addEmployeeDTO,
                               RedirectAttributes redirectAttributes,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addEmployeeDTO", addEmployeeDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.addEmployeeDTO",
                    AddEmployeeDTO.empty());
            return "redirect:/employees/add";
        }

        long id = employeeService.addEmployees(addEmployeeDTO);
        return "redirect:/employees/" + id;
    }

}
