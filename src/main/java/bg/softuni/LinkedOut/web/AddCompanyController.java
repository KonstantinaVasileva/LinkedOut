package bg.softuni.LinkedOut.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddCompanyController {

    @GetMapping("/companies/add")
    public String addCompany() {
        return "company-add";
    }

}
