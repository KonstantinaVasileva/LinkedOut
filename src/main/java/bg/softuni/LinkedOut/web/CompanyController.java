//package bg.softuni.LinkedOut.web;
//
//import bg.softuni.LinkedOut.model.entity.Company;
//import bg.softuni.LinkedOut.service.CompanyService;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import java.util.List;
//
//@Controller
//public class CompanyController {
//
//
//    private CompanyService companyService;
//
//    @GetMapping("/form")
//    public String showForm(Model model) {
//        // Fetching the list of companies from the service layer
//        List<Company> companies = companyService.getAllCompanies();
//
//        // Add the list of companies to the model
//        model.addAttribute("companies", companies);
//
//        return "form";
//    }
//}
//
