package com.elf.vipForElf.domain.floor.service.serviceImpl

import com.elf.vipForElf.domain.building.service.BuildingService
import com.elf.vipForElf.domain.floor.entity.FloorEntity
import com.elf.vipForElf.domain.floor.repository.FloorRepository
import com.elf.vipForElf.domain.floor.service.FloorService
import com.elf.vipForElf.domain.floor.vo.FloorInfoVO
import com.elf.vipForElf.domain.floor.vo.FloorListVO
import com.elf.vipForElf.web.dto.NewFloorDTO
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class FloorServiceImpl(
    private val floorRepository: FloorRepository,
    private val buildingService: BuildingService
) : FloorService {

    @Throws(IllegalAccessException::class)
    override fun createFloor(newFloorDTO: NewFloorDTO): FloorInfoVO {
        if (!buildingService.existById(newFloorDTO.buildingId)) {
            throw IllegalAccessException("Building Id does not exist")
        }

        val buildingEntity = buildingService.getBuildingEntityById(newFloorDTO.buildingId)
        val floorInfoVO = FloorInfoVO(newFloorDTO, buildingEntity)

        return floorRepository.createFloor(floorInfoVO)
    }

    override fun getFloorById(id: Long): FloorInfoVO =
        floorRepository.getFloorById(id)

    override fun getFloorList(searchCondition: String, page: Int, size: Int): List<FloorListVO> {
        val pageable = PageRequest.of(page, size)
        return if (searchCondition.isBlank()) {
            floorRepository.findAll(pageable)
        } else {
            floorRepository.findBySearchCondition(searchCondition, pageable)
        }
    }

    override fun getFloorEntityById(id: Long): FloorEntity =
        floorRepository.getFloorEntityById(id)
}
