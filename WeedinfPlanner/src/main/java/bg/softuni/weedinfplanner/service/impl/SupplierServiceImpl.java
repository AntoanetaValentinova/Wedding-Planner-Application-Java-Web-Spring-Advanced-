package bg.softuni.weedinfplanner.service.impl;

import bg.softuni.weedinfplanner.model.binding.SupplierProfileUpdateBindingModel;
import bg.softuni.weedinfplanner.model.entity.Address;
import bg.softuni.weedinfplanner.model.entity.Supplier;
import bg.softuni.weedinfplanner.model.entity.enums.RoleEnum;
import bg.softuni.weedinfplanner.model.service.SupplierProfileUpdateServiceModel;
import bg.softuni.weedinfplanner.model.service.SupplierRegisterServiceModel;
import bg.softuni.weedinfplanner.model.service.SuppliersAllServiceModel;
import bg.softuni.weedinfplanner.model.view.AddressViewModel;
import bg.softuni.weedinfplanner.model.view.SupplierProfileViewModel;
import bg.softuni.weedinfplanner.repository.SupplierRepository;
import bg.softuni.weedinfplanner.service.*;
import bg.softuni.weedinfplanner.service.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;
    private final CategorySupplierService categorySupplierService;
    private final AddressService addressService;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;
    private final ModelMapper modelMapper;
    private final CityService cityService;
    private final WPUserServiceImpl wpUserService;


    public SupplierServiceImpl(SupplierRepository supplierRepository, CategorySupplierService categorySupplierService, AddressService addressService, PasswordEncoder passwordEncoder, RoleService roleService, ModelMapper modelMapper, CityService cityService, WPUserServiceImpl wpUserService) {
        this.supplierRepository = supplierRepository;
        this.categorySupplierService = categorySupplierService;
        this.addressService = addressService;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
        this.modelMapper = modelMapper;
        this.cityService = cityService;
        this.wpUserService = wpUserService;
    }


    @Override
    public void save(SupplierRegisterServiceModel supplierRegisterServiceModel) {
        //save address
        Address address = this.modelMapper.map(supplierRegisterServiceModel, Address.class);
        address.setCity(this.cityService.findByName(supplierRegisterServiceModel.getCity()));
        Address savedAddress = this.addressService.save(address);

        //save supplier
        Supplier supplierEntity = this.modelMapper.map(supplierRegisterServiceModel, Supplier.class);
        supplierEntity.setPassword(this.passwordEncoder.encode(supplierRegisterServiceModel.getPassword()));
        supplierEntity.setAddress(savedAddress);
        supplierEntity.setRoles(Set.of(this.roleService.findRoleByName(RoleEnum.SUPPLIER)));

        Supplier registeredSupplier = this.supplierRepository.save(supplierEntity);

        UserDetails principal = this.wpUserService.loadUserByUsername(registeredSupplier.getEmail());
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                principal,
                registeredSupplier.getPassword(),
                principal.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }


    @Override
    public Supplier findSupplierByEmail(String email) {
        return this.supplierRepository.findSupplierByEmail(email).orElseThrow(() -> new ObjectNotFoundException());
    }

    @Override
    public void updateSupplierProfile(SupplierProfileUpdateBindingModel supplierProfileUpdateBindingModel, Principal principal) {
        //map binding model to service model
        SupplierProfileUpdateServiceModel supplierProfileUpdateServiceModel
                = this.modelMapper.map(supplierProfileUpdateBindingModel, SupplierProfileUpdateServiceModel.class);
        //map service model to supplier entity and set properties
        Supplier supplier=findSupplierByEmail(principal.getName());
        supplier.setCompanyName(supplierProfileUpdateServiceModel.getCompanyName());
        supplier.setPhoneNumber(supplierProfileUpdateServiceModel.getPhoneNumber());
        //update address entity
        Address address = this.addressService.getAddressById(supplier.getAddress().getId()).orElseThrow(() -> new ObjectNotFoundException());
                address.setAddress(supplierProfileUpdateServiceModel.getAddress())
                .setCity(this.cityService.findByName(supplierProfileUpdateServiceModel.getCityName()));
                this.addressService.save(address);
        //update supplier address
        supplier.setAddress(address);
        // save supplier
        this.supplierRepository.save(supplier);
    }

    @Override
    public Object getCurrentUserCompanyName(Principal principal) {
        return this.supplierRepository.findSupplierByEmail(principal.getName()).get().getCompanyName();
    }

    @Override
    public List<SuppliersAllServiceModel> findAllSuppliers() {
        return  this.supplierRepository.findAll()
                .stream()
                .map(supplier -> {
                    SuppliersAllServiceModel suppliersAllServiceModel = this.modelMapper.map(supplier, SuppliersAllServiceModel.class);
                    supplier.getRoles()
                            .forEach(role -> suppliersAllServiceModel.getRoleEnums().add(role.getName()));
                    return suppliersAllServiceModel;
                })
                .collect(Collectors.toList());
    }

    @Override
    public boolean existByEmail(String email) {
        return this.supplierRepository.existsByEmail(email);
    }

    @Override
    public void makeSupplierAdmin(String email) {
        Supplier supplier = this.supplierRepository.findSupplierByEmail(email).orElseThrow(() -> new ObjectNotFoundException());
        supplier.getRoles().add(this.roleService.findRoleByName(RoleEnum.ADMIN));
        this.supplierRepository.save(supplier);
    }

    @Override
    public void removeAdminRole(String email) {
        Supplier supplier = this.supplierRepository.findSupplierByEmail(email).orElseThrow(() -> new ObjectNotFoundException());
        supplier.getRoles().remove(this.roleService.findRoleByName(RoleEnum.ADMIN));
        this.supplierRepository.save(supplier);
    }

    @Override
    public SupplierProfileViewModel getSupplierProfileViewModelByEmail(String email) {
        SupplierProfileViewModel supplierProfileViewModel1 = this.supplierRepository.findSupplierByEmail(email)
                .map(supplier -> {
                    SupplierProfileViewModel supplierProfileViewModel =
                            this.modelMapper.map(supplier, SupplierProfileViewModel.class);
                    supplierProfileViewModel.setAddress(new AddressViewModel()
                            .setAddress(supplier.getAddress().getAddress())
                            .setCityName(supplier.getAddress().getCity().getName()));
                    return supplierProfileViewModel;
                })
                .orElseThrow(() -> new ObjectNotFoundException());
        return supplierProfileViewModel1;
    }

}
