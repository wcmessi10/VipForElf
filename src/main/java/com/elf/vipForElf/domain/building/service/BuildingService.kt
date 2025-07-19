package com.elf.vipForElf.domain.building.service

import com.elf.vipForElf.domain.building.entity.BuildingEntity
import com.elf.vipForElf.domain.building.vo.BuildingInfoVO
import com.elf.vipForElf.domain.building.vo.BuildingListVO
import com.elf.vipForElf.web.dto.NewBuildingDTO

interface BuildingService {

    fun putBuilding(newBuildingDTO: NewBuildingDTO): BuildingInfoVO

    fun getBuildingById(id: Long): BuildingInfoVO?

    fun getBuildingList(searchCondition: String, page: Int, size: Int): List<BuildingListVO>

    fun deleteBuildingById(id: Long): String

    fun existById(id: Long): Boolean

    fun getBuildingEntityById(id: Long): BuildingEntity
}
