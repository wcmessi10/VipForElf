package com.elf.vipForElf.domain.building.entity;

import com.elf.vipForElf.domain.building.vo.BuildingInfoVO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Entity
@Table(name = "elf_t_building")
@Getter
@Setter
@NoArgsConstructor
public class BuildingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "building_name", nullable = false, length = 255)
    public String buildingName;

    @Column(name = "address", length = 255)
    public String address;

    @Column(name = "building_number", length = 10)
    public String buildingNumber;

    @Column(name = "business_number", length = 50)
    public String businessNumber;

    @Column(name = "zipcode", length = 5)
    public String zipcode;

    @Column(name = "create_date")
    public OffsetDateTime createDate = OffsetDateTime.now();

    public BuildingEntity(BuildingInfoVO buildingInfoVO){
        this.buildingName = buildingInfoVO.getBuildingName();
        this.buildingNumber = buildingInfoVO.getBuildingNumber();
        this.businessNumber = buildingInfoVO.getBusinessNumber();
        this.address = buildingInfoVO.getAddress();
        this.zipcode = buildingInfoVO.getZipcode();
    }
}
