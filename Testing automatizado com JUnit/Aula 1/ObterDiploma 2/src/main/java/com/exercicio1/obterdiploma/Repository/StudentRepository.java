package com.exercicio1.obterdiploma.Repository;

import com.exercicio1.obterdiploma.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
