package com.reto2.service;

import com.reto2.model.Hairproducts;
import com.reto2.repository.hairproductsRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class hairproductsService {
    @Autowired
    private hairproductsRepositorio clotheRepository;

    public List<Hairproducts> getAll() {
        return clotheRepository.getAll();
    }

    public Optional<Hairproducts> getClothe(String reference) {
        return clotheRepository.getClothe(reference);
    }

    public Hairproducts create(Hairproducts accesory) {
        if (accesory.getReference() == null) {
            return accesory;
        } else {
            return clotheRepository.create(accesory);
        }
    }

    public Hairproducts update(Hairproducts accesory) {

        if (accesory.getReference() != null) {
            Optional<Hairproducts> accesoryDb = clotheRepository.getClothe(accesory.getReference());
            if (!accesoryDb.isEmpty()) {

                if (accesory.getBrand()!= null) {
                    accesoryDb.get().setBrand(accesory.getBrand());
                }

                if (accesory.getCategory() != null) {
                    accesoryDb.get().setCategory(accesory.getCategory());
                }

                if (accesory.getName() != null) {
                    accesoryDb.get().setName(accesory.getName());
                }

                if (accesory.getDescription() != null) {
                    accesoryDb.get().setDescription(accesory.getDescription());
                }

                if (accesory.getPrice() != 0.0) {
                    accesoryDb.get().setPrice(accesory.getPrice());
                }

                if (accesory.getQuantity() != 0) {
                    accesoryDb.get().setQuantity(accesory.getQuantity());
                }

                if (accesory.getPhotography() != null) {
                    accesoryDb.get().setPhotography(accesory.getPhotography());
                }

                accesoryDb.get().setAvailability(accesory.isAvailability());
                clotheRepository.update(accesoryDb.get());
                return accesoryDb.get();
            } else {
                return accesory;
            }
        } else {
            return accesory;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getClothe(reference).map(gadget -> {
            clotheRepository.delete(gadget);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
