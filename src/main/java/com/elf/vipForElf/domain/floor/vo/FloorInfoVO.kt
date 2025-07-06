package com.elf.vipForElf.domain.floor.vo

import com.elf.vipForElf.domain.building.entity.BuildingEntity
import com.elf.vipForElf.domain.floor.entity.FloorEntity
import com.elf.vipForElf.web.dto.NewFloorDTO

data class FloorInfoVO(
    val id: Long? = null,
    val floorNumber: Int,
    val purpose: String,
    val buildingEntity: BuildingEntity
) {
    constructor(newFloorDTO: NewFloorDTO, buildingEntity: BuildingEntity) : this(
        id = null,
        floorNumber = newFloorDTO.floorNumber ?: 0,
        purpose = newFloorDTO.purpose ?: "",
        buildingEntity = buildingEntity
    )

    constructor(floorEntity: FloorEntity) : this(
        id = floorEntity.id,
        floorNumber = floorEntity.floorNumber,
        purpose = floorEntity.purpose,
        buildingEntity = floorEntity.building
    )
}
