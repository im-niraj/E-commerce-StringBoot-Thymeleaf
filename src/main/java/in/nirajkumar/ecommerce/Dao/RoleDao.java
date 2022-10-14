package in.nirajkumar.ecommerce.dao;

import in.nirajkumar.ecommerce.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends CrudRepository<Role, String> {

}
