package com.ecommerce.praticacomplementar.Service;

import com.ecommerce.praticacomplementar.DTO.ProductInsertionDTO;
import com.ecommerce.praticacomplementar.Entities.Product;
import com.ecommerce.praticacomplementar.Entities.User;
import com.ecommerce.praticacomplementar.Exception.Handle.AccessDeniedException;
import com.ecommerce.praticacomplementar.Exception.Handle.UserNotFoundException;
import com.ecommerce.praticacomplementar.Repository.ProductRepository;
import com.ecommerce.praticacomplementar.Repository.UserRepository;
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

    public Product addProduct(ProductInsertionDTO product) {
        User user = this.userRepository.getUserById(product.getIdUser());
        if (user == null) {
            throw new UserNotFoundException("Usuario não encontrado");
        }
        if (user.getAdmin()) {
            return this.productRepository.createProduct(product.getProducts());
        }
        throw new AccessDeniedException("Acesso negado! Essa ação só pode ser realizada por um administrador.");
    }

}
