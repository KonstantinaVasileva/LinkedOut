package bg.softuni.LinkedOut.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("currentDate", new Date());
        return "index";
    }

}
