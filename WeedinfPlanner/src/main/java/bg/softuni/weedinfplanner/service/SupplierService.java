package bg.softuni.weedinfplanner.service;

import bg.softuni.weedinfplanner.model.binding.SupplierProfileUpdateBindingModel;
import bg.softuni.weedinfplanner.model.entity.Supplier;
import bg.softuni.weedinfplanner.model.service.SupplierRegisterServiceModel;
import bg.softuni.weedinfplanner.model.service.SuppliersAllServiceModel;
import bg.softuni.weedinfplanner.model.view.SupplierProfileViewModel;

import java.security.Principal;
import java.util.List;

public interface SupplierService {


    void save(SupplierRegisterServiceModel supplierRegisterServiceModel);

    SupplierProfileViewModel getSupplierProfileViewModelByEmail(String email);

    Supplier findSupplierByEmail(String email);

    void updateSupplierProfile(SupplierProfileUpdateBindingModel supplierProfileUpdateBindingModel, Principal principal);

    Object getCurrentUserCompanyName(Principal principal);

    List<SuppliersAllServiceModel> findAllSuppliers();

    boolean existByEmail(String email);

    void makeSupplierAdmin(String email);

    void removeAdminRole(String email);

}
