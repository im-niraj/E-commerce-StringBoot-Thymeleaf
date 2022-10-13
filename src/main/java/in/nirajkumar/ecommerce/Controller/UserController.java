package in.nirajkumar.ecommerce.Controller;

import in.nirajkumar.ecommerce.Entity.User;
import in.nirajkumar.ecommerce.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping({"/registerNewUser"})
    public User registerNewUser(@RequestBody User user, @RequestParam(required = false) String role){
        return userService.registerNewUser(user, role);
    }

    @PutMapping(value = {"/roleMapping"},params = {"username","role"})
    public User roleMapping(@RequestParam String username, @RequestParam String role){
        return userService.roleMapping(username, role);
    }


    @GetMapping({"/forAdmin"})
    public String forAdmin(){
        return "This URL is only accessible to admin";
    }

    @GetMapping({"/forUser"})
    public String forUser(){
        return "This URL is only accessible to the user";
    }
}
