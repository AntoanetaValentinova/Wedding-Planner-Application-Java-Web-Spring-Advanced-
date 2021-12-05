package bg.softuni.weedinfplanner.repository;

import bg.softuni.weedinfplanner.model.entity.Role;
import bg.softuni.weedinfplanner.model.entity.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findRoleByName(RoleEnum name);
}
