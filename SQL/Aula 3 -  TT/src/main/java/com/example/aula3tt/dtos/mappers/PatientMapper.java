package com.example.aula3tt.dtos.mappers;

import com.example.aula3tt.dtos.PatientByDayDTO;
import com.example.aula3tt.entities.Patient;
import com.example.aula3tt.entities.Turn;

import java.util.List;
import java.util.stream.Collectors;

public class PatientMapper {
    public static List<PatientByDayDTO> convert (List<Turn> listTurn) {
        return listTurn
                .stream()
                .map(turn -> new PatientByDayDTO(turn.getPatient().getName() + " " + turn.getPatient().getLast_name(),
                                                    turn.getDay(), turn.getDiarys().getDentist().getName(),
                                                    turn.getTurn_status().getName(),
                                                    turn.getDiarys().getStart_time(),
                                                    turn.getDiarys().getEnding_time())).collect(Collectors.toList());
    }
}
