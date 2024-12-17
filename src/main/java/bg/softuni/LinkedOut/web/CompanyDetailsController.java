package bg.softuni.LinkedOut.web;

import bg.softuni.LinkedOut.model.dto.AddCompanyDTO;
import bg.softuni.LinkedOut.service.CompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CompanyDetailsController {

    private final CompanyService companyService;

    public CompanyDetailsController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/companies/{id}")
    public String companyDetails(@PathVariable("id") String id, Model model) {
        AddCompanyDTO companyDTO = companyService.getCompany(id);
        model.addAttribute("company", companyDTO);
        return "company-details";
    }

}
