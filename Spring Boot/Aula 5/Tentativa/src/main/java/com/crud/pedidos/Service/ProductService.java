package com.crud.pedidos.Service;

import com.crud.pedidos.DTO.ProductInsertionDTO;
import com.crud.pedidos.Entities.Product;
import com.crud.pedidos.Entities.User;
import com.crud.pedidos.Exception.AccessDeniedException;
import com.crud.pedidos.Exception.UserNotFoundException;
import com.crud.pedidos.Repository.ProductRepository;
import com.crud.pedidos.Repository.UserRepository;
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
