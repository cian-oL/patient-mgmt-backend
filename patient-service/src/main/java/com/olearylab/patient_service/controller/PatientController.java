package com.olearylab.patient_service.controller;

import com.olearylab.patient_service.dto.PatientRequestDTO;
import com.olearylab.patient_service.dto.PatientResponseDTO;
import com.olearylab.patient_service.service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;

    @GetMapping
    public ResponseEntity<List<PatientResponseDTO>> getPatients() {
        return ResponseEntity.ok(patientService.getPatients());
    }

    @PostMapping
    public ResponseEntity<PatientResponseDTO> createPatient(
            @Valid @RequestBody PatientRequestDTO patientRequestDTO
    ) {
        return ResponseEntity.ok(patientService.createPatient(patientRequestDTO));
    }
}
