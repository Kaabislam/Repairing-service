package com.kaab.repair_service.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Technician {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String expertise;
    private String email;
    private String phoneNumber;

    @OneToMany(mappedBy = "technician", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RepairRequest> repairRequests;

    // Getters and Setters
}