package in.nirajkumar.ecommerce.Controller;

import in.nirajkumar.ecommerce.Model.Role;
import in.nirajkumar.ecommerce.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/newRole")
    public String addNewRole(@RequestBody Role role){
        roleService.addNewRole(role);
        return "hello";
    }

}
