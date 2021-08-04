package com.example.aula3tt.repository;

import com.example.aula3tt.entities.Patient;
import com.example.aula3tt.entities.Turn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TurnRepository extends JpaRepository<Turn, Long> {
    List<Turn> findByDay(LocalDate data);

    @Query("select t from Turn t, TurnStatus ts where t.turn_status.id = ts.id and ts.name = :name")
    List<Turn> findByTurnStatusName(@Param("name") String name);

    @Query("select t from Turn t, TurnStatus ts where t.turn_status.id = ts.id and ts.name = :name and t.day = :day")
    List<Turn> findByDayAndStatus(@Param("name") String name, @Param("day") LocalDate day);

    //@Query("select t from Turn t where t.diarys.dentist.id = :id")
    List<Turn> findByDiarysDentistId(@Param("id") Long id);
}
