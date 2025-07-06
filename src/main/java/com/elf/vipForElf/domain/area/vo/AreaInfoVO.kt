package com.elf.vipForElf.domain.area.vo

import com.elf.vipForElf.domain.area.entity.AreaEntity
import com.elf.vipForElf.domain.floor.entity.FloorEntity
import com.elf.vipForElf.web.dto.MoveInAreaDTO
import com.elf.vipForElf.web.dto.NewAreaDTO
import java.time.OffsetDateTime

data class AreaInfoVO(
    val id: Long? = null,
    val status: String? = null,
    val officeName: String? = null,
    val roomNumber: String? = null,
    val areaSize: String? = null,
    val moveInDate: OffsetDateTime? = null,
    val floorEntity: FloorEntity? = null
) {
    constructor(newAreaDTO: NewAreaDTO, floorEntity: FloorEntity) : this(
        id = null,
        status = null,
        officeName = null,
        roomNumber = newAreaDTO.roomNumber,
        moveInDate = null,
        areaSize = newAreaDTO.areaSize,
        floorEntity = floorEntity
    )

    constructor(areaEntity: AreaEntity) : this(
        id = areaEntity.id,
        status = areaEntity.status,
        officeName = areaEntity.officeName,
        roomNumber = areaEntity.roomNumber,
        moveInDate = areaEntity.moveInDate,
        areaSize = areaEntity.areaSize,
        floorEntity = areaEntity.floor
    )

    constructor(moveInAreaDTO: MoveInAreaDTO) : this(
        id = moveInAreaDTO.id,
        officeName = moveInAreaDTO.officeName,
        status = null,
        areaSize = null,
        roomNumber = null,
        floorEntity = null,
        moveInDate = OffsetDateTime.now()
    )
}
