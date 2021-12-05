package bg.softuni.weedinfplanner.service;

import bg.softuni.weedinfplanner.model.entity.Address;


import java.util.Optional;

public interface AddressService {

    Optional<Address> getAddressById(Long id);

    Address save(Address address);
}
