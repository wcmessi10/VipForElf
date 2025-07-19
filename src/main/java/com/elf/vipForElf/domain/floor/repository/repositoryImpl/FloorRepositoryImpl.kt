package com.elf.vipForElf.domain.floor.repository.repositoryImpl

import com.elf.vipForElf.domain.floor.entity.FloorEntity
import com.elf.vipForElf.domain.floor.repository.FloorRepository
import com.elf.vipForElf.domain.floor.repository.JPA.FloorJPARepository
import com.elf.vipForElf.domain.floor.vo.FloorInfoVO
import com.elf.vipForElf.domain.floor.vo.FloorListVO
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository

@Repository
class FloorRepositoryImpl(
    private val floorJPARepository: FloorJPARepository
) : FloorRepository {

    override fun createFloor(floorInfoVO: FloorInfoVO): FloorInfoVO {
        val floorEntity = FloorEntity().applyFromVO(floorInfoVO)
        return FloorInfoVO(floorJPARepository.save(floorEntity))
    }


    override fun getFloorById(id: Long): FloorInfoVO =
        FloorInfoVO(
            floorJPARepository.findById(id)
                .orElseThrow { IllegalArgumentException("No Floor by this id") }
        )

    override fun getFloorEntityById(id: Long): FloorEntity =
        floorJPARepository.findById(id)
            .orElseThrow { NoSuchElementException("No FloorEntity by this id") }

    override fun findAll(pageable: Pageable): List<FloorListVO> =
        floorJPARepository.findAll(pageable).content.map(::FloorListVO)


    override fun findBySearchCondition(searchCondition: String, pageable: Pageable): List<FloorListVO> {
        val buildingId = searchCondition.toLongOrNull()
        val floorNumber = searchCondition.toIntOrNull()

        return floorJPARepository
            .findByBuildingIdOrFloorNumberOrPurposeIgnoreCase(
                buildingId,
                floorNumber,
                searchCondition,
                pageable
            ).content
            .map(::FloorListVO)
    }
}
