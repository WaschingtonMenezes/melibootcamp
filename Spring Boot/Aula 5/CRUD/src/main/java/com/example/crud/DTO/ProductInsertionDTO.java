package com.example.crud.DTO;


import com.example.crud.Entities.Product;

public class ProductInsertionDTO {
    private Product product;
    private long idUser;

    public ProductInsertionDTO(Product product, long idUser) {
        this.product = product;
        this.idUser = idUser;
    }

    public Product getProduct() {
        return product;
    }

    public void setProducts(Product product) {
        this.product = product;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }
}
