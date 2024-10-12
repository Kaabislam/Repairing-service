package com.kaab.repair_service.controller;

import com.kaab.repair_service.model.Technician;
import com.kaab.repair_service.service.TechnicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/technicians")
public class TechnicianController {

    @Autowired
    private TechnicianService technicianService;

    @PostMapping
    public ResponseEntity<Technician> addTechnician(@RequestBody Technician technician) {
        Technician newTechnician = technicianService.saveTechnician(technician);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTechnician);
    }

    @GetMapping
    public ResponseEntity<List<Technician>> getAllTechnicians() {
        List<Technician> technicians = technicianService.getAllTechnicians();
        return ResponseEntity.ok(technicians);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Technician> getTechnicianById(@PathVariable Long id) {
        Optional<Technician> technician = technicianService.getTechnicianById(id);
        return technician.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTechnician(@PathVariable Long id) {
        technicianService.deleteTechnician(id);
        return ResponseEntity.noContent().build();
    }
}
