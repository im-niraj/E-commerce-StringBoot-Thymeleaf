package in.nirajkumar.ecommerce.Service.impl;

import in.nirajkumar.ecommerce.Dto.RoleRepository;
import in.nirajkumar.ecommerce.Model.Role;
import in.nirajkumar.ecommerce.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void addNewRole(Role role) {
        roleRepository.save(role);
    }
}
