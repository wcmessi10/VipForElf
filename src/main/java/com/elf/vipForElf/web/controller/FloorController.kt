package com.elf.vipForElf.web.controller

import com.elf.vipForElf.domain.floor.service.FloorService
import com.elf.vipForElf.domain.floor.vo.FloorInfoVO
import com.elf.vipForElf.domain.floor.vo.FloorListVO
import com.elf.vipForElf.web.dto.NewFloorDTO
import com.elf.vipForElf.web.dto.ResponseDTO
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@Tag(name = "층", description = "층 관련 API")
@RestController
@RequestMapping("/floor")
class FloorController(
    private val floorService: FloorService
) {

    @PostMapping("/createFloor")
    fun createFloor(
        @RequestBody newFloorDTO: NewFloorDTO
    ): ResponseDTO<FloorInfoVO> {
        return ResponseDTO(
            floorService.createFloor(newFloorDTO)
        )
    }

    @GetMapping("/getFloorById")
    fun getFloorById(
        @RequestParam id: Long
    ): ResponseDTO<FloorInfoVO> {
        return ResponseDTO(
            floorService.getFloorById(id)
        )
    }

    @GetMapping("/getFloorList")
    fun getFloorList(
        @RequestParam(required = false) searchCondition: String?,
        @RequestParam page: Int,
        @RequestParam size: Int
    ): ResponseDTO<List<FloorListVO>> {
        val condition = searchCondition ?: ""
        return ResponseDTO(
            floorService.getFloorList(condition, page, size)
        )
    }
}
