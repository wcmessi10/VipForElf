package com.elf.vipForElf.domain.building.vo

import com.elf.vipForElf.domain.building.entity.BuildingEntity
import com.elf.vipForElf.web.dto.NewBuildingDTO

data class BuildingInfoVO(
    val id: Long? = null,
    val buildingName: String,
    val address: String?,
    val buildingNumber: String?,
    val businessNumber: String?,
    val zipcode: String?
) {
    constructor(newBuildingDTO: NewBuildingDTO) : this(
        id = null,
        buildingName = newBuildingDTO.buildingName ?: "",
        address = newBuildingDTO.address ?: "",
        buildingNumber = newBuildingDTO.buildingNumber ?: "",
        businessNumber = newBuildingDTO.businessNumber ?: "",
        zipcode = newBuildingDTO.zipcode ?: ""
    ) {
        require(zipcode?.length == 5) { "ZipCode is wrong" }
    }

    constructor(buildingEntity: BuildingEntity) : this(
        id = buildingEntity.id,
        buildingName = buildingEntity.buildingName,
        address = buildingEntity.address,
        buildingNumber = buildingEntity.buildingNumber,
        businessNumber = buildingEntity.businessNumber,
        zipcode = buildingEntity.zipcode
    )
}
