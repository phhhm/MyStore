package controller;

import com.sun.org.apache.xml.internal.security.utils.Base64;
import model.Prouduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.ProuductService;

import java.util.List;

@Controller
public class MyController {
    @Autowired
    ProuductService prouductService;

    @GetMapping({"/", "/home", "/index"})
    public String home(Model model){
        List<Prouduct> prouductList = prouductService.getAll();
        model.addAttribute("prouductList", prouductList);
        return "home";
    }

    @PostMapping("/prouduct")
    public String save(Prouduct prouduct){
        prouductService.save(prouduct);
        return "redirect:home";
    }

    @GetMapping("/find")
    public String find(@RequestParam("name")String name, Model model){
        Prouduct prouduct = prouductService.findByName(name);
        model.addAttribute("prouduct", prouduct);
        return "find";
    }

    @GetMapping("/new_prouduct")
    public String newProuduct(Model model){
        Prouduct prouduct = new Prouduct();
        model.addAttribute("prouduct", prouduct);
        return "new_prouduct";
    }
}
