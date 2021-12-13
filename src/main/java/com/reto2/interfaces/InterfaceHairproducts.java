package com.reto2.interfaces;

import com.reto2.model.Hairproducts;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InterfaceHairproducts extends MongoRepository<Hairproducts, String> {

}
