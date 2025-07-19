package com.elf.vipForElf.domain.floor.service

import com.elf.vipForElf.domain.floor.entity.FloorEntity
import com.elf.vipForElf.domain.floor.vo.FloorInfoVO
import com.elf.vipForElf.domain.floor.vo.FloorListVO
import com.elf.vipForElf.web.dto.NewFloorDTO

interface FloorService {
    @Throws(IllegalAccessException::class)
    fun createFloor(newFloorDTO: NewFloorDTO): FloorInfoVO

    fun getFloorById(id: Long): FloorInfoVO

    fun getFloorList(searchCondition: String, page: Int, size: Int): List<FloorListVO>

    fun getFloorEntityById(id: Long): FloorEntity
}
