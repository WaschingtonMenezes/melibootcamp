package com.dentinhosconsultorio.repositories;

import com.dentinhosconsultorio.entities.Turn;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnRepository extends MongoRepository<Turn, String> {
}
