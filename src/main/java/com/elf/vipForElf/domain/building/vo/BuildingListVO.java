package com.elf.vipForElf.domain.building.vo;

import com.elf.vipForElf.domain.building.entity.BuildingEntity;
import lombok.Value;

@Value
public class BuildingListVO {
    String buildingName;
    String buildingNumber;

    public BuildingListVO(BuildingEntity buildingEntity){
        this.buildingName = buildingEntity.getBuildingName();
        this.buildingNumber = buildingEntity.getBuildingNumber();
    }
}
