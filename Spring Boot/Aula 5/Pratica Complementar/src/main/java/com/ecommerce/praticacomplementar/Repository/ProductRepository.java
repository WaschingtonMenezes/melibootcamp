package com.ecommerce.praticacomplementar.Repository;

import com.ecommerce.praticacomplementar.Entities.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> productsList = new ArrayList<>();

    @Autowired
    ObjectMapper mapper;

    public Product createProduct (Product product) {
        productsList.add(product);
        return product;
    }

}
