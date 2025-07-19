package com.elf.vipForElf.domain.floor.repository

import com.elf.vipForElf.domain.floor.entity.FloorEntity
import com.elf.vipForElf.domain.floor.vo.FloorInfoVO
import com.elf.vipForElf.domain.floor.vo.FloorListVO
import org.springframework.data.domain.Pageable

interface FloorRepository {
    fun createFloor(floorInfoVO: FloorInfoVO): FloorInfoVO
    fun getFloorById(id: Long): FloorInfoVO
    fun getFloorEntityById(id: Long): FloorEntity
    fun findAll(pageable: Pageable): List<FloorListVO>
    fun findBySearchCondition(searchCondition: String, pageable: Pageable): List<FloorListVO>
}
