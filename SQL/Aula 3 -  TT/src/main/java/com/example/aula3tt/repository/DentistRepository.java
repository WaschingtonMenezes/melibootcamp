package com.example.aula3tt.repository;

import com.example.aula3tt.entities.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DentistRepository extends JpaRepository<Dentist, Long> {
    @Query("select d from Dentist d, Diary di, Turn t where di.dentist.id = d.id and di.id = t.id and t.day = :day group by d having count(t.id) >= :turns")
    List<Dentist> findByNumbersOfTurnsOnDayGreaterThan(@Param("day") LocalDate day, @Param("turns") Long turns);
}
