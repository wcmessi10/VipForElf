package com.elf.vipForElf.domain.area.vo

import com.elf.vipForElf.domain.area.entity.AreaEntity

data class AreaListVO(
    val id: Long,
    val officeName: String,
    val roomNumber: String
) {
    constructor(areaEntity: AreaEntity) : this(
        id = areaEntity.id,
        officeName = areaEntity.officeName,
        roomNumber = areaEntity.roomNumber
    )
}
