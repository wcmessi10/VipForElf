package com.elf.vipForElf.domain.building.service.serviceImpl

import com.elf.vipForElf.domain.building.entity.BuildingEntity
import com.elf.vipForElf.domain.building.repository.BuildingRepository
import com.elf.vipForElf.domain.building.service.BuildingService
import com.elf.vipForElf.domain.building.vo.BuildingInfoVO
import com.elf.vipForElf.domain.building.vo.BuildingListVO
import com.elf.vipForElf.web.dto.NewBuildingDTO
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class BuildingServiceImpl(
    private val buildingRepository: BuildingRepository
) : BuildingService {

    override fun putBuilding(newBuildingDTO: NewBuildingDTO): BuildingInfoVO =
        BuildingInfoVO(newBuildingDTO).let {
            buildingRepository.create(it)
        }

    override fun getBuildingById(id: Long): BuildingInfoVO? =
        buildingRepository.getById(id).takeIf { buildingRepository.existsById(id) }


    override fun getBuildingList(searchCondition: String, page: Int, size: Int): List<BuildingListVO> {
        val pageable = PageRequest.of(page, size)
        return if (searchCondition.isBlank()) {
            buildingRepository.findAll(pageable)
        } else {
            buildingRepository.findBySearchCondition(searchCondition, pageable)
        }
    }

    override fun deleteBuildingById(id: Long): String =
        buildingRepository.deleteBuildingById(id)

    override fun existById(id: Long?): Boolean =
        buildingRepository.existsById(id)

    override fun getBuildingEntityById(id: Long?): BuildingEntity =
        buildingRepository.getBuildingEntityById(id)
}
