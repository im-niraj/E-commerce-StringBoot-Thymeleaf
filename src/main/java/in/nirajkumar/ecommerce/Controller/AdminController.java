package in.nirajkumar.ecommerce.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {


    @GetMapping("/forAdmin")
    public String forAdmin(){
        return "forAdmin";
    }
}
