package com.olearylab.patient_service.service;

import com.olearylab.patient_service.dto.PatientResponseDTO;
import com.olearylab.patient_service.mapper.PatientMapper;
import com.olearylab.patient_service.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;

    public List<PatientResponseDTO> getPatients() {
        return patientRepository.findAll().stream().map(PatientMapper::toDTO).toList();
    }
}
