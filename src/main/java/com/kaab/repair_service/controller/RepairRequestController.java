package com.kaab.repair_service.controller;

import com.kaab.repair_service.model.RepairRequest;
import com.kaab.repair_service.service.RepairRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/repair-requests")
public class RepairRequestController {

    @Autowired
    private RepairRequestService repairRequestService;

    @PostMapping
    public ResponseEntity<RepairRequest> createRepairRequest(@RequestBody RepairRequest repairRequest) {
        RepairRequest newRepairRequest = repairRequestService.saveRepairRequest(repairRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(newRepairRequest);
    }

    @GetMapping
    public ResponseEntity<List<RepairRequest>> getAllRepairRequests() {
        List<RepairRequest> repairRequests = repairRequestService.getAllRepairRequests();
        return ResponseEntity.ok(repairRequests);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RepairRequest> getRepairRequestById(@PathVariable Long id) {
        Optional<RepairRequest> repairRequest = repairRequestService.getRepairRequestById(id);
        return repairRequest.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRepairRequest(@PathVariable Long id) {
        repairRequestService.deleteRepairRequest(id);
        return ResponseEntity.noContent().build();
    }
}
