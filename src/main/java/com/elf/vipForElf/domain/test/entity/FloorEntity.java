package com.elf.vipForElf.domain.test.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "elf_t_floor")
@Getter
@Setter
public class FloorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "floor_number", nullable = false)
    private Integer floorNumber;

    @Column(name = "purpose", length = 255)
    private String purpose = "Mixed-use";

    @ManyToOne
    @JoinColumn(name = "building_id", nullable = false)
    private BuildingEntity building;

}
