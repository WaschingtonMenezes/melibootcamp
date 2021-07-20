package com.crud.pedidos.Controller;

import com.crud.pedidos.DTO.ProductInsertionDTO;
import com.crud.pedidos.Entities.Product;
import com.crud.pedidos.Service.ProductService;
import org.apache.coyote.Response;
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
