package com.elf.vipForElf.domain.building.repository.JPA

import com.elf.vipForElf.domain.building.entity.BuildingEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BuildingJPARepository : JpaRepository<BuildingEntity, Long> {
    fun existsByBuildingNumber(buildingNumber: String?): Boolean

    fun findByBuildingNameIgnoreCaseOrBuildingNumberIgnoreCase(
        searchCondition1: String,
        searchCondition2: String,
        pageable: Pageable
    ): Page<BuildingEntity>
}
