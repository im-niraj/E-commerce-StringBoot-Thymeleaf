package in.nirajkumar.ecommerce.Service;

import in.nirajkumar.ecommerce.Dao.RoleDao;
import in.nirajkumar.ecommerce.Dao.UserDao;
import in.nirajkumar.ecommerce.Entity.Role;
import in.nirajkumar.ecommerce.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    public User registerNewUser(User user, String role){
        if(role != null){
            Role role1 = roleDao.findById(role).get();
            user.getRole().add(role1);
            return userDao.save(user);
        }
        Role role1 = roleDao.findById("user").get();
        user.getRole().add(role1);
        return userDao.save(user);

    }

    public User roleMapping(String username, String role){
         Role role1 = roleDao.findById(role).get();
         User user = userDao.findById(username).get();
         user.getRole().add(role1);
         return userDao.save(user);
    }
}