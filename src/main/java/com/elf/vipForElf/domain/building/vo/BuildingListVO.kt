package com.elf.vipForElf.domain.building.vo

import com.elf.vipForElf.domain.building.entity.BuildingEntity

data class BuildingListVO(
    val buildingName: String,
    val buildingNumber: String
) {
    constructor(buildingEntity: BuildingEntity) : this(
        buildingName = buildingEntity.buildingName,
        buildingNumber = buildingEntity.buildingNumber ?: ""
    )
}
