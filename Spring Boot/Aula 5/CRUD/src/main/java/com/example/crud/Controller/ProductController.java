package com.example.crud.Controller;

import com.example.crud.DTO.ProductInsertionDTO;
import com.example.crud.Entities.Product;
import com.example.crud.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    ProductController(ProductService service) {
        productService = service;
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Product> insertProduct (@RequestBody ProductInsertionDTO productInsertion) {
        try {
            this.productService.addProduct(productInsertion);
            return ResponseEntity.created(null).build();
        } catch (Exception err) {
            System.out.println(err);
            return null;
            //return ResponseEntity.badRequest().body(err.getMessage());
        }
    }
}
