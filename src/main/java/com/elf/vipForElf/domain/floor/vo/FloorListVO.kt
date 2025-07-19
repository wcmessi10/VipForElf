package com.elf.vipForElf.domain.floor.vo

import com.elf.vipForElf.domain.floor.entity.FloorEntity

data class FloorListVO(
    val id: Long?,
    val floorNumber: Int
) {
    constructor(floorEntity: FloorEntity) : this(
        id = floorEntity.id,
        floorNumber = floorEntity.floorNumber
    )
}
