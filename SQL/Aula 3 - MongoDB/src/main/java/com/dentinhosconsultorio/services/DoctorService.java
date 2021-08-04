package com.dentinhosconsultorio.services;

import com.dentinhosconsultorio.entities.Doctor;
import com.dentinhosconsultorio.entities.Patient;
import com.dentinhosconsultorio.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    private DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public Doctor createDoctor(Doctor doctor) {
        return  this.doctorRepository.save(doctor);
    }

    public List<Doctor> getAllDoctors() {
        return this.doctorRepository.findAll();
    }
}
