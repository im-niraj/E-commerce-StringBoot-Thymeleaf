package in.nirajkumar.ecommerce.Controller;

import java.util.List;

import in.nirajkumar.ecommerce.Dto.UserRepository;
import in.nirajkumar.ecommerce.Model.User;
import in.nirajkumar.ecommerce.Service.LoginSignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginSignupController {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private LoginSignupService loginSignupService;
	
	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		System.out.println("register");
		return "signup_form";
	}
	
	@PostMapping("/process_register")
	public String processRegister(User user, boolean role) {
		String message = loginSignupService.newRegistration(user, role);
		System.out.println(role);
		return "register_success";
	}
	
	@GetMapping("/users")
	public String listUsers(Model model) {
		List<User> listUsers = userRepo.findAll();
		model.addAttribute("listUsers", listUsers);
		
		return "users";
	}
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}

}
