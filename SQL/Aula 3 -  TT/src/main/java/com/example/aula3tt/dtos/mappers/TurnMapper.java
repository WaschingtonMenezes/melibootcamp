package com.example.aula3tt.dtos.mappers;

import com.example.aula3tt.dtos.PatientByDayDTO;
import com.example.aula3tt.dtos.TurnDentistDTO;
import com.example.aula3tt.entities.Turn;

import java.util.List;
import java.util.stream.Collectors;

public class TurnMapper {
    public static List<TurnDentistDTO> convert (List<Turn> listTurn) {
        return listTurn
                .stream()
                .map(turn -> new TurnDentistDTO(turn.getDiarys().getDentist().getName(),
                                                turn.getPatient(),
                                                turn.getDiarys().getStart_time(),
                                                turn.getDiarys().getEnding_time(),
                                                turn.getDay())).collect(Collectors.toList());
    }
}
