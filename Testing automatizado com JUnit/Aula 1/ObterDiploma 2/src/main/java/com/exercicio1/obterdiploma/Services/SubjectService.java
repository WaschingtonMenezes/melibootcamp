package com.exercicio1.obterdiploma.Services;

import com.exercicio1.obterdiploma.DTO.SubjectDTO;
import com.exercicio1.obterdiploma.Entities.Subject;
import com.exercicio1.obterdiploma.Repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectService {
    private SubjectRepository subjectRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public List<Subject> addSubjectLists (List<SubjectDTO> subjectDTOS) {
        List<Subject> subjectList = new ArrayList<>();

        subjectDTOS.forEach(subject -> subjectList.add(this.subjectRepository.save(new Subject(subject.getSubject(), subject.getNote()))));
        return subjectList;
    }
}
