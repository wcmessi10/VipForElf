package com.elf.vipForElf.domain.floor.entity;

import com.elf.vipForElf.domain.building.entity.BuildingEntity;
import com.elf.vipForElf.domain.floor.vo.FloorInfoVO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "elf_t_floor")
@Getter
@Setter
@NoArgsConstructor
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

    public FloorEntity floorEntity(FloorInfoVO floorInfoVO){
        FloorEntity floorEntity = new FloorEntity();
        floorEntity.setFloorNumber(floorInfoVO.getFloorNumber());
        floorEntity.setPurpose(floorInfoVO.getPurpose());
        floorEntity.setBuilding(floorInfoVO.getBuildingEntity());
        return floorEntity;
    }
}
