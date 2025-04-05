package com.elf.vipForElf.domain.test.vo;

import com.elf.vipForElf.domain.test.entity.AreaEntity;
import com.elf.vipForElf.domain.test.entity.FloorEntity;
import com.elf.vipForElf.web.dto.MoveInAreaDTO;
import com.elf.vipForElf.web.dto.NewAreaDTO;
import lombok.Value;

import java.time.OffsetDateTime;

@Value
public class AreaInfoVO {
    Long id;
    String status;
    String officeName;
    String roomNumber;
    String areaSize;
    OffsetDateTime moveInDate;
    FloorEntity floorEntity;

    public AreaInfoVO(NewAreaDTO newAreaDTO, FloorEntity floorEntity){
        this.id = null;
        this.status = null;
        this.officeName = null;
        this.roomNumber = newAreaDTO.getRoomNumber();
        this.moveInDate = null;
        this.areaSize = newAreaDTO.getAreaSize();
        this.floorEntity = floorEntity;
    }
    public AreaInfoVO(AreaEntity areaEntity){
        this.id = areaEntity.getId();
        this.status = areaEntity.getStatus();
        this.officeName = areaEntity.getOfficeName();
        this.roomNumber = areaEntity.getRoomNumber();
        this.moveInDate = areaEntity.getMoveInDate();
        this.areaSize = areaEntity.getAreaSize();
        this.floorEntity = areaEntity.getFloor();
    }
    public AreaInfoVO(MoveInAreaDTO moveInAreaDTO){
        this.id = moveInAreaDTO.getId();
        this.officeName = moveInAreaDTO.getOfficeName();
        this.status = null;
        this.areaSize = null;
        this.roomNumber = null;
        this.floorEntity = null;
        this.moveInDate = OffsetDateTime.now();
    }
}
