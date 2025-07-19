package com.elf.vipForElf.domain.building.entity

import com.elf.vipForElf.domain.building.vo.BuildingInfoVO
import jakarta.persistence.*
import java.time.OffsetDateTime

@Entity
@Table(name = "elf_t_building")
class BuildingEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "building_name", nullable = false, length = 255)
    var buildingName: String,

    @Column(name = "address", length = 255)
    var address: String? = null,

    @Column(name = "building_number", length = 10)
    var buildingNumber: String? = null,

    @Column(name = "business_number", length = 50)
    var businessNumber: String? = null,

    @Column(name = "zipcode", length = 5)
    var zipcode: String? = null,

    @Column(name = "create_date")
    var createDate: OffsetDateTime = OffsetDateTime.now()
) {
    constructor() : this(
        buildingName = "",
        address = null,
        buildingNumber = null,
        businessNumber = null,
        zipcode = null
    )

    constructor(buildingInfoVO: BuildingInfoVO) : this(
        buildingName = buildingInfoVO.buildingName,
        buildingNumber = buildingInfoVO.buildingNumber,
        businessNumber = buildingInfoVO.businessNumber,
        address = buildingInfoVO.address,
        zipcode = buildingInfoVO.zipcode
    )
}
