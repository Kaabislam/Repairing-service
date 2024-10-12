package com.kaab.repair_service.repository;

import com.kaab.repair_service.model.RepairRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepairRequestRepository extends JpaRepository<RepairRequest, Long> {
}
