package bg.softuni.LinkedOut.web;

import bg.softuni.LinkedOut.model.dto.AddEmployeeDTO;
import bg.softuni.LinkedOut.model.entity.Company;
import bg.softuni.LinkedOut.service.CompanyService;
import bg.softuni.LinkedOut.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class AddEmployeeController {

    private final EmployeeService employeeService;
    private final CompanyService companyService;

    public AddEmployeeController(EmployeeService employeeService, CompanyService companyService) {
        this.employeeService = employeeService;
        this.companyService = companyService;
    }

    @GetMapping("/add")
    public String addEmployees(Model model) {
        if (!model.containsAttribute("addEmployeeDTO")) {
            model.addAttribute("addEmployeeDTO", AddEmployeeDTO.empty());
            List<Company> companies = companyService.getAllCompanies();
            model.addAttribute("companies", companies);
        }
        return "employee-add";
    }

    @PostMapping("/add")
    public String addEmployees(@ModelAttribute("addEmployeeDTO") AddEmployeeDTO addEmployeeDTO,
                               RedirectAttributes redirectAttributes,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addEmployeeDTO", addEmployeeDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.addEmployeeDTO",
                    bindingResult);
            return "redirect:/employees/add";
        }

        String id = employeeService.addEmployees(addEmployeeDTO);
        return "redirect:/employees/" + id;
    }

}
