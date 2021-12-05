package bg.softuni.weedinfplanner.service.impl;

import bg.softuni.weedinfplanner.model.entity.BaseUser;
import bg.softuni.weedinfplanner.repository.SupplierRepository;
import bg.softuni.weedinfplanner.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WPUserServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    private final SupplierRepository supplierRepository;

    public WPUserServiceImpl(UserRepository userRepository, SupplierRepository supplierRepository) {
        this.userRepository = userRepository;
        this.supplierRepository = supplierRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        //check if user with the given email exist
        BaseUser userSupplierByEmail = this.userRepository.findUserByEmail(email).orElse(null);

        //if not -> check for supplier with same email
        if(userSupplierByEmail==null) {
            userSupplierByEmail = this.supplierRepository.findSupplierByEmail(email).orElse(null);
        }

        if (userSupplierByEmail==null) {
            throw new UsernameNotFoundException("User with email "+ email + " not found!");
        }
        return mapToUserDetails(userSupplierByEmail);
    }

    private UserDetails mapToUserDetails(BaseUser userSupplierByEmail) {
        List<GrantedAuthority> authorities =
                userSupplierByEmail
                        .getRoles()
                        .stream()
                        .map(r-> new SimpleGrantedAuthority("ROLE_"+r.getName().name()))
                        .collect(Collectors.toList());
       return new User(userSupplierByEmail.getEmail(),userSupplierByEmail.getPassword(),authorities);

    }
}
