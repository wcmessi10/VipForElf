package com.elf.vipForElf.domain.test.vo;

import com.elf.vipForElf.domain.test.entity.FloorEntity;
import lombok.Value;

@Value
public class FloorListVO {
    Long id;
    Integer floorNumber;

    public FloorListVO(FloorEntity floorEntity){
        this.id = floorEntity.getId();
        this.floorNumber = floorEntity.getFloorNumber();
    }
}
