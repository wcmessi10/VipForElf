package com.elf.vipForElf.domain.building.repository

import com.elf.vipForElf.domain.building.entity.BuildingEntity
import com.elf.vipForElf.domain.building.vo.BuildingInfoVO
import com.elf.vipForElf.domain.building.vo.BuildingListVO
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository

@Repository
interface BuildingRepository {

    fun create(buildingInfoVO: BuildingInfoVO): BuildingInfoVO

    fun getById(id: Long): BuildingInfoVO?

    fun existsById(id: Long?): Boolean

    fun findAll(pageable: Pageable): List<BuildingListVO>

    fun findBySearchCondition(searchCondition: String, pageable: Pageable): List<BuildingListVO>

    fun deleteBuildingById(id: Long): String

    fun getBuildingEntityById(id: Long?): BuildingEntity
}
