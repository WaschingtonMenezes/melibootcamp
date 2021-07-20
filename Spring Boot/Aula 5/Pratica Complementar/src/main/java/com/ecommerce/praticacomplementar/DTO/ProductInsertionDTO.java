package com.ecommerce.praticacomplementar.DTO;

import com.ecommerce.praticacomplementar.Entities.Product;

import java.util.List;

public class ProductInsertionDTO {
    private Product products;
    private long idUser;

    public ProductInsertionDTO(Product products, long idUser) {
        this.products = products;
        this.idUser = idUser;
    }

    public Product getProducts() {
        return products;
    }

    public void setProducts(Product products) {
        this.products = products;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }
}
