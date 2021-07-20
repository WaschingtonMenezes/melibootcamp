package com.ecommerce.praticacomplementar.Controller;

import com.ecommerce.praticacomplementar.DTO.ProductInsertionDTO;
import com.ecommerce.praticacomplementar.Entities.Product;
import com.ecommerce.praticacomplementar.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    ProductController(ProductService service) {
        productService = service;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<Product> insertProduct (ProductInsertionDTO productInsertion) {
        try {
            this.productService.addProduct(productInsertion);
        } catch (Exception err) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.badRequest().body(null);
    }
}
