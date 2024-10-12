package com.kaab.repair_service.service;

import com.kaab.repair_service.model.RepairRequest;
import com.kaab.repair_service.repository.RepairRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RepairRequestService {

    @Autowired
    private RepairRequestRepository repairRequestRepository;

    public RepairRequest saveRepairRequest(RepairRequest repairRequest) {
        return repairRequestRepository.save(repairRequest);
    }

    public List<RepairRequest> getAllRepairRequests() {
        return repairRequestRepository.findAll();
    }

    public Optional<RepairRequest> getRepairRequestById(Long id) {
        return repairRequestRepository.findById(id);
    }

    public void deleteRepairRequest(Long id) {
        repairRequestRepository.deleteById(id);
    }
}
