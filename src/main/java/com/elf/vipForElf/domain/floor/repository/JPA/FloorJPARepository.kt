package com.elf.vipForElf.domain.floor.repository.JPA

import com.elf.vipForElf.domain.floor.entity.FloorEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FloorJPARepository : JpaRepository<FloorEntity, Long> {
    fun findByBuildingIdOrFloorNumberOrPurposeIgnoreCase(
        buildingId: Long?,
        floorNumber: Int?,
        purpose: String?,
        pageable: Pageable
    ): Page<FloorEntity>
}
