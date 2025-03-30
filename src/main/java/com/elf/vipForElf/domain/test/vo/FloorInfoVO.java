package com.elf.vipForElf.domain.test.vo;

import com.elf.vipForElf.domain.test.entity.BuildingEntity;
import com.elf.vipForElf.domain.test.entity.FloorEntity;
import com.elf.vipForElf.web.dto.NewFloorDTO;
import lombok.Value;

@Value
public class FloorInfoVO {
    Long id;
    Integer floorNumber;
    String purpose;
    BuildingEntity buildingEntity;
    public FloorInfoVO(NewFloorDTO newFloorDTO,BuildingEntity buildingEntity){
        this.id=null;
        this.floorNumber = newFloorDTO.getFloorNumber();
        this.purpose = newFloorDTO.getPurpose();
        this.buildingEntity = buildingEntity;
    }

    public FloorInfoVO(FloorEntity floorEntity){
        this.id = floorEntity.getId();
        this.purpose = floorEntity.getPurpose();
        this.floorNumber=floorEntity.getFloorNumber();
        this.buildingEntity = floorEntity.getBuilding();
    }
}
