package com.ecommerce.praticacomplementar.Repository;

import com.ecommerce.praticacomplementar.Entities.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private List<User> userList = new ArrayList<>();

    public User getUserById(long id) {
        return userList.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
    }

}
