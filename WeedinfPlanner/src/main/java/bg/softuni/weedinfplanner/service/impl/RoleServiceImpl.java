package bg.softuni.weedinfplanner.service.impl;

import bg.softuni.weedinfplanner.model.entity.Role;
import bg.softuni.weedinfplanner.model.entity.enums.RoleEnum;
import bg.softuni.weedinfplanner.repository.RoleRepository;
import bg.softuni.weedinfplanner.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findRoleByName(RoleEnum name) {
        return this.roleRepository.findRoleByName(name);
    }
}
