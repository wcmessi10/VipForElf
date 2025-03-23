package com.elf.vipForElf.domain.test.vo;

import com.elf.vipForElf.domain.test.entity.BuildingEntity;
import com.elf.vipForElf.web.dto.NewBuildingDTO;
import lombok.Value;

@Value
public class BuildingInfoVO {
    Long id;
    String buildingName;
    String address;
    String buildingNumber;
    String businessNumber;
    String zipcode;

    public BuildingInfoVO(NewBuildingDTO newBuildingDTO){
        if(newBuildingDTO.getZipcode().length() !=5){
            throw new IllegalArgumentException("ZipCode is wrong");
        }
        this.id = null;
        this.buildingName = newBuildingDTO.getBuildingName();
        this.buildingNumber = newBuildingDTO.getBuildingNumber();
        this.address = newBuildingDTO.getAddress();
        this.zipcode = newBuildingDTO.getZipcode();
        this.businessNumber = newBuildingDTO.getBusinessNumber();
    }

    public BuildingInfoVO(BuildingEntity buildingEntity){
        this.id = buildingEntity.getId();
        this.buildingName = buildingEntity.getBuildingName();
        this.address = buildingEntity.getAddress();
        this.buildingNumber = buildingEntity.getBuildingNumber();
        this.zipcode = buildingEntity.getZipcode();
        this.businessNumber = buildingEntity.getBusinessNumber();
    }
}
