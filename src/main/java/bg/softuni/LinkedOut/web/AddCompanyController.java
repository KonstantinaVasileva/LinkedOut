package bg.softuni.LinkedOut.web;

import bg.softuni.LinkedOut.model.dto.AddCompanyDTO;
import bg.softuni.LinkedOut.service.CompanyService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/companies")
public class AddCompanyController {

    private final CompanyService companyService;
    public AddCompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/add")
    public String addCompany() {
        return "company-add";
    }

    @PostMapping("/add")
    public String addCompanyConfirm(@Valid AddCompanyDTO addCompanyDTO,
                                    BindingResult bindingResult,
                                    RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("companyAddForm", addCompanyDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.companyAddForm", bindingResult);
            return "redirect:/companies/add";
        }

        long id = companyService.addCompany(addCompanyDTO);

        return "redirect:/companies/"+ id;
    }

}
