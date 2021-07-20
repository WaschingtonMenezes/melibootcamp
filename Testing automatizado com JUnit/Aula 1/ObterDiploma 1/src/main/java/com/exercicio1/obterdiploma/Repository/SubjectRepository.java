package com.exercicio1.obterdiploma.Repository;

import com.exercicio1.obterdiploma.Entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
