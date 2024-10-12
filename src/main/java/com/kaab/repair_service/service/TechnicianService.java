package com.kaab.repair_service.service;

import com.kaab.repair_service.model.Technician;
import com.kaab.repair_service.repository.TechnicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TechnicianService {

    @Autowired
    private TechnicianRepository technicianRepository;

    public Technician saveTechnician(Technician technician) {
        return technicianRepository.save(technician);
    }

    public List<Technician> getAllTechnicians() {
        return technicianRepository.findAll();
    }

    public Optional<Technician> getTechnicianById(Long id) {
        return technicianRepository.findById(id);
    }

    public void deleteTechnician(Long id) {
        technicianRepository.deleteById(id);
    }
}

