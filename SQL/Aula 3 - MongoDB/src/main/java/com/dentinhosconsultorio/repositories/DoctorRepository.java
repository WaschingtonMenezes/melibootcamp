package com.dentinhosconsultorio.repositories;

import com.dentinhosconsultorio.entities.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends MongoRepository<Doctor, String> {
}
