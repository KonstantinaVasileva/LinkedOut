package bg.softuni.LinkedOut.web;

import bg.softuni.LinkedOut.model.entity.Company;
import bg.softuni.LinkedOut.service.CompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AllCompaniesController {

    private final CompanyService companyService;

    public AllCompaniesController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/companies/all")
    public String allCompanies(Model model) {
        List<Company> companies = companyService.getAllCompanies();
        model.addAttribute("companies", companies);
        return "company-all";
    }

}
