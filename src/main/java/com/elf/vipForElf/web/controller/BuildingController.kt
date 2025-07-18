package com.elf.vipForElf.web.controller

import com.elf.vipForElf.domain.building.service.BuildingService
import com.elf.vipForElf.domain.building.vo.BuildingInfoVO
import com.elf.vipForElf.domain.building.vo.BuildingListVO
import com.elf.vipForElf.web.dto.NewBuildingDTO
import com.elf.vipForElf.web.dto.ResponseDTO
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*
import java.util.Optional

@Tag(name = "빌딩", description = "빌딩 관련 API")
@RestController
@RequestMapping("/building")
class BuildingController(
    private val buildingService: BuildingService
) {

    // 빌딩 추가
    @PostMapping("/putBuilding")
    fun putBuilding(
        @RequestBody newBuildingDTO: NewBuildingDTO
    ): ResponseDTO<BuildingInfoVO> {
        return ResponseDTO(
            buildingService.putBuilding(newBuildingDTO)
        )
    }

    // 빌딩 고유값(ID)으로 단건 조회
    @GetMapping("/getBuildingById")
    fun getBuildingById(
        @RequestParam id: Long
    ): ResponseDTO<Optional<BuildingInfoVO>> {
        return ResponseDTO(
            buildingService.getBuildingById(id)
        )
    }

    // 빌딩 리스트 조회 TODO(최신순, 조회순 가능하게)
    @GetMapping("/getBuildingList")
    fun getBuildingList(
        @RequestParam(required = false) searchCondition: String?,
        @RequestParam page: Int,
        @RequestParam size: Int
    ): ResponseDTO<List<BuildingListVO>> {
        val condition = searchCondition ?: "" // ✅ null일 때 기본값
        return ResponseDTO(
            buildingService.getBuildingList(condition, page, size)
        )
    }

    @DeleteMapping("/deleteBuildingById")
    fun deleteBuildingById(
        @RequestParam id: Long
    ): ResponseDTO<String> {
        return ResponseDTO(
            buildingService.deleteBuildingById(id)
        )
    }
}
