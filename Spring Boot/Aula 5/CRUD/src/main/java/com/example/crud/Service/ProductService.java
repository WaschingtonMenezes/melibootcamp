package com.example.crud.Service;

import com.example.crud.DTO.ProductInsertionDTO;
import com.example.crud.Entities.Product;
import com.example.crud.Entities.User;
import com.example.crud.Exception.AccessDeniedException;
import com.example.crud.Exception.UserNotFoundException;
import com.example.crud.Repository.ProductRepository;
import com.example.crud.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    public ProductService(ProductRepository productRepository, UserRepository userRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    public ProductService() {

    }

    public Product addProduct(ProductInsertionDTO product) {
        User user = this.userRepository.getById(product.getIdUser());
        if (user == null) {
            throw new UserNotFoundException("Usuario não encontrado");
        }
        if (user.getAdmin()) {
            return this.productRepository.save(product.getProduct());
        }
        throw new AccessDeniedException("Acesso negado! Essa ação só pode ser realizada por um administrador.");
    }

}
