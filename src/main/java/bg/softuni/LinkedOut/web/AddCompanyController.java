package bg.softuni.LinkedOut.web;

import bg.softuni.LinkedOut.model.dto.AddCompanyDTO;
import bg.softuni.LinkedOut.service.CompanyService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String addCompany(Model model) {
            if (!model.containsAttribute("addCompanyDTO")) {
            model.addAttribute("addCompanyDTO", new AddCompanyDTO(null, null, null, null));
        }
        return "company-add";
    }

    @PostMapping("/add")
    public String addCompanyConfirm(@Valid AddCompanyDTO addCompanyDTO,
                                    BindingResult bindingResult,
                                    RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addCompanyDTO", addCompanyDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.addCompanyDTO",
                    bindingResult);
            return "redirect:/companies/add";
        }

        String id = companyService.addCompany(addCompanyDTO);

        return "redirect:/companies/" + id;
    }

}
