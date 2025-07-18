package com.elf.vipForElf.web.controller

import com.elf.vipForElf.domain.area.service.AreaService
import com.elf.vipForElf.domain.area.vo.AreaInfoVO
import com.elf.vipForElf.domain.area.vo.AreaListVO
import com.elf.vipForElf.web.dto.MoveInAreaDTO
import com.elf.vipForElf.web.dto.NewAreaDTO
import com.elf.vipForElf.web.dto.ResponseDTO
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@Tag(name = "칸", description = "층의 칸 관련 API")
@RestController
@RequestMapping("/area")
class AreaController(
    private val areaService: AreaService
) {

    @PostMapping("/createArea")
    fun createArea(@ModelAttribute newAreaDTO: NewAreaDTO): ResponseDTO<AreaInfoVO> {
        return ResponseDTO(areaService.createArea(newAreaDTO))
    }

    @PostMapping("/moveIn")
    fun moveIn(@ModelAttribute moveInAreaDTO: MoveInAreaDTO): ResponseDTO<AreaInfoVO> {
        return ResponseDTO(areaService.moveIn(moveInAreaDTO))
    }

    @GetMapping("/getById")
    fun findById(@RequestParam id: Long): ResponseDTO<AreaInfoVO> {
        return ResponseDTO(areaService.findAreaById(id))
    }

    @GetMapping("/getAreaList")
    fun getAreaList(
        @RequestParam(required = false) searchCondition: String?,
        @RequestParam page: Int,
        @RequestParam size: Int
    ): ResponseDTO<List<AreaListVO>> {
        val condition = searchCondition ?: ""
        return ResponseDTO(areaService.getAreaList(condition, page, size))
    }

    @GetMapping("/getAreaListByFloor")
    fun getAreaListByFloor(@RequestParam floorId: Long): ResponseDTO<List<AreaListVO>> {
        return ResponseDTO(areaService.getAreaListByFloor(floorId))
    }

    @DeleteMapping("/deleteById")
    fun deleteById(@RequestParam id: Long): ResponseDTO<String> {
        return ResponseDTO(areaService.deleteById(id))
    }
}
