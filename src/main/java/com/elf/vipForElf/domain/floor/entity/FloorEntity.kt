package com.elf.vipForElf.domain.floor.entity

import com.elf.vipForElf.domain.building.entity.BuildingEntity
import com.elf.vipForElf.domain.floor.vo.FloorInfoVO
import jakarta.persistence.*

@Entity
@Table(name = "elf_t_floor")
class FloorEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "floor_number", nullable = false)
    var floorNumber: Int,

    @Column(name = "purpose", length = 255)
    var purpose: String = "Mixed-use",

    @ManyToOne
    @JoinColumn(name = "building_id", nullable = false)
    var building: BuildingEntity
) {
    constructor() : this(
        id = null,
        floorNumber = 0,
        purpose = "Mixed-use",
        building = BuildingEntity()
    )

    fun applyFromVO(floorInfoVO: FloorInfoVO): FloorEntity {
        this.floorNumber = floorInfoVO.floorNumber
        this.purpose = floorInfoVO.purpose ?: "Mixed-use"
        this.building = floorInfoVO.buildingEntity
        return this
    }
}
