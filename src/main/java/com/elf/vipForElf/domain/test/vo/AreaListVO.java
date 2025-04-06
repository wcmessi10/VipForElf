package com.elf.vipForElf.domain.test.vo;

import com.elf.vipForElf.domain.test.entity.AreaEntity;
import lombok.Value;

@Value
public class AreaListVO {
    Long id;
    String officeName;
    String roomNumber;

    public AreaListVO(AreaEntity areaEntity){
        this.id= areaEntity.getId();
        this.officeName = areaEntity.getOfficeName();
        this.roomNumber = areaEntity.getRoomNumber();
    }
}
