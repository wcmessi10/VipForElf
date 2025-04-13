package com.elf.vipForElf.web.controller;

import com.elf.vipForElf.domain.area.service.AreaService;
import com.elf.vipForElf.domain.area.vo.AreaInfoVO;
import com.elf.vipForElf.domain.area.vo.AreaListVO;
import com.elf.vipForElf.web.dto.MoveInAreaDTO;
import com.elf.vipForElf.web.dto.NewAreaDTO;
import com.elf.vipForElf.web.dto.ResponseDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "칸", description = "층의 칸 관련 API")
@RestController
@RequestMapping("/area")
public class AreaController {
    private final AreaService areaService;

    public AreaController(AreaService areaService) {
        this.areaService = areaService;
    }

    @PostMapping("/createArea")
    public ResponseDTO<AreaInfoVO> createArea(@ModelAttribute NewAreaDTO newAreaDTO){
        return new ResponseDTO<>(areaService.createArea(newAreaDTO));
    }

    @PostMapping("/moveIn")
    public ResponseDTO<AreaInfoVO> moveIn(@ModelAttribute MoveInAreaDTO moveInAreaDTO){
        return new ResponseDTO<>(areaService.moveIn(moveInAreaDTO));
    }

    @GetMapping("/getById")
    public ResponseDTO<AreaInfoVO> findById(@RequestParam Long id){
        return new ResponseDTO<>(areaService.findAreaById(id));
    }

    @GetMapping("/getAreaList")
    public ResponseDTO<List<AreaListVO>> getAreaList(@RequestParam(required = false) String searchCondition, @RequestParam int page, @RequestParam int size){
        if(searchCondition==null) searchCondition="";
        return new ResponseDTO<>(areaService.getAreaList(searchCondition,page,size));
    }

    @GetMapping(value = "/getAreaListByFloor")
    public ResponseDTO<List<AreaListVO>> getAreaListByFloor(@RequestParam Long floorId){
        return new ResponseDTO<>(areaService.getAreaListByFloor(floorId));
    }

    @DeleteMapping(value = "/deleteById")
    public ResponseDTO<String> deleteById(@RequestParam Long id){
        return  new ResponseDTO<>(areaService.deleteById(id));
    }
}
