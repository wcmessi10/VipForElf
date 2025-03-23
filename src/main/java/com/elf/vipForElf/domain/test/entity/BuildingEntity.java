package com.elf.vipForElf.domain.test.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Entity
@Table(name = "elf_t_building")
@Getter
@Setter
public class BuildingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "building_name", nullable = false, length = 255)
    private String buildingName;

    @Column(name = "address", length = 255)
    private String address;

    @Column(name = "building_number", length = 10)
    private String buildingNumber;

    @Column(name = "business_number", length = 50)
    private String businessNumber;

    @Column(name = "zipcode", length = 5)
    private String zipcode;

    @Column(name = "create_date")
    private OffsetDateTime createDate = OffsetDateTime.now();
}
