package com.reto2.repository;

import com.reto2.model.Hairproducts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import com.reto2.interfaces.InterfaceHairproducts;

@Repository
public class hairproductsRepositorio {
    @Autowired
    private InterfaceHairproducts repository;

    public List<Hairproducts> getAll() {
        return repository.findAll();
    }

    public Optional<Hairproducts> getClothe(String reference) {
        return repository.findById(reference);
    }
    public Hairproducts create(Hairproducts clothe) {
        return repository.save(clothe);
    }

    public void update(Hairproducts clothe) {
        repository.save(clothe);
    }

    public void delete(Hairproducts clothe) {
        repository.delete(clothe);
    }
}
