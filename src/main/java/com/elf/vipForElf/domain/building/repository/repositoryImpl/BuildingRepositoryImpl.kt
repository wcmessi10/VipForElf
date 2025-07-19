package com.elf.vipForElf.domain.building.repository.repositoryImpl

import com.elf.vipForElf.domain.building.entity.BuildingEntity
import com.elf.vipForElf.domain.building.repository.BuildingRepository
import com.elf.vipForElf.domain.building.repository.JPA.BuildingJPARepository
import com.elf.vipForElf.domain.building.vo.BuildingInfoVO
import com.elf.vipForElf.domain.building.vo.BuildingListVO
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository

@Repository
class BuildingRepositoryImpl(
    private val buildingJPARepository: BuildingJPARepository
) : BuildingRepository {

    override fun create(buildingInfoVO: BuildingInfoVO): BuildingInfoVO {
        val buildingEntity = BuildingEntity(buildingInfoVO)

        if (existsByBuildingNumber(buildingEntity.buildingNumber)) {
            throw IllegalArgumentException("Already existed Building Number")
        }

        return BuildingInfoVO(buildingJPARepository.save(buildingEntity))
    }

    override fun getById(id: Long): BuildingInfoVO? =
        buildingJPARepository.findById(id)
            .map(::BuildingInfoVO)
            .orElse(null)

    override fun existsById(id: Long?): Boolean =
        buildingJPARepository.existsById(id)

    override fun findAll(pageable: Pageable): List<BuildingListVO> =
        buildingJPARepository.findAll(pageable)
            .map(::BuildingListVO)
            .toList()

    override fun findBySearchCondition(searchCondition: String, pageable: Pageable): List<BuildingListVO> =
        buildingJPARepository
            .findByBuildingNameIgnoreCaseOrBuildingNumberIgnoreCase(searchCondition, searchCondition, pageable)
            .map(::BuildingListVO)
            .toList()

    override fun deleteBuildingById(id: Long): String =
        if (existsById(id)) {
            buildingJPARepository.deleteById(id)
            "Succeeded Delete"
        } else {
            "Failed Delete because this is not exist"
        }

    override fun getBuildingEntityById(id: Long?): BuildingEntity =
        buildingJPARepository.findById(id)
            .orElseThrow { NoSuchElementException("Building not found with id: $id") }

    fun existsByBuildingNumber(buildingNumber: String?): Boolean =
        buildingJPARepository.existsByBuildingNumber(buildingNumber)
}
