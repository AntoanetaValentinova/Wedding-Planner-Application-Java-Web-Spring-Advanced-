package bg.softuni.weedinfplanner.service;

import bg.softuni.weedinfplanner.model.entity.Role;
import bg.softuni.weedinfplanner.model.entity.enums.RoleEnum;

public interface RoleService {

    Role findRoleByName(RoleEnum name);
}
