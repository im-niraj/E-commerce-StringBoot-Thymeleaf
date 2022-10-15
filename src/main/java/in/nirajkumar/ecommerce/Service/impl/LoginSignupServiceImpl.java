package in.nirajkumar.ecommerce.Service.impl;

import in.nirajkumar.ecommerce.Dto.RoleRepository;
import in.nirajkumar.ecommerce.Dto.UserRepository;
import in.nirajkumar.ecommerce.Model.Role;
import in.nirajkumar.ecommerce.Model.User;
import in.nirajkumar.ecommerce.Service.LoginSignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginSignupServiceImpl implements LoginSignupService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String newRegistration(User user, boolean roleField) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        if(roleField){
            Role role = roleRepository.findById("ADMIN").get();
            user.getRole().add(role);
            userRepository.save(user);
            return "User Register Successfully.";
        }
        Role role = roleRepository.findById("USER").get();
        user.getRole().add(role);
        userRepository.save(user);
        return "User Register Successfully.";
    }

}
