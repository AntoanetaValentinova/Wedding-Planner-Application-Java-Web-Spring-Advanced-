package bg.softuni.weedinfplanner.service.impl;

import bg.softuni.weedinfplanner.model.entity.Address;
import bg.softuni.weedinfplanner.repository.AddressRepository;
import bg.softuni.weedinfplanner.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Optional<Address> getAddressById(Long id) {
        return this.addressRepository.findById(id);
    }

    @Override
    public Address save(Address address) {
        return this.addressRepository.save(address);
    }
}
