package com.elf.vipForElf.domain.test.vo;

import com.elf.vipForElf.domain.test.entity.BuildingEntity;
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
