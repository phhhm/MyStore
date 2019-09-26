package controller;

import com.sun.org.apache.xml.internal.security.utils.Base64;
import model.Prouduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import service.ProuductService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class MyController {
    @Autowired
    ProuductService prouductService;

    private Path path;

    @GetMapping({"/", "/home", "/index"})
    public String home(Model model){
        List<Prouduct> prouductList = prouductService.getAll();
        model.addAttribute("prouductList", prouductList);
        return "home";
    }

    @PostMapping("/prouduct")
    public String save(Prouduct prouduct, HttpServletRequest request){
        MultipartFile productImage = prouduct.getImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "/resources/images/" + prouduct.getId() + ".jpg");

        if (productImage != null && !productImage.isEmpty()) {
            try {
                File file = new File(path.toString());
                productImage.transferTo(file);
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Product image saving failed", e);
            }
        }
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
