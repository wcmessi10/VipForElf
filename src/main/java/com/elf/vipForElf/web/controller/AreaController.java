package com.elf.vipForElf.web.controller;

import com.elf.vipForElf.domain.test.service.AreaService;
import com.elf.vipForElf.web.dto.MoveInAreaDTO;
import com.elf.vipForElf.web.dto.NewAreaDTO;
import com.elf.vipForElf.web.dto.ResponseDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/area")
public class AreaController {
    private final AreaService areaService;

    public AreaController(AreaService areaService) {
        this.areaService = areaService;
    }

    @PostMapping("/createArea")
    public ResponseDTO<?> createArea(@ModelAttribute NewAreaDTO newAreaDTO){
        return new ResponseDTO<>(areaService.createArea(newAreaDTO));
    }

    @PostMapping("/moveIn")
    public ResponseDTO<?> moveIn(@ModelAttribute MoveInAreaDTO moveInAreaDTO){
        return new ResponseDTO<>(areaService.moveIn(moveInAreaDTO));
    }

    @GetMapping("/getById")
    public ResponseDTO<?> findById(@RequestParam Long id){
        return new ResponseDTO<>(areaService.findAreaById(id));
    }

    @GetMapping("/getAreaList")
    public ResponseDTO<?> getAreaList(@RequestParam(required = false) String searchCondition, @RequestParam int page, @RequestParam int size){
        if(searchCondition==null) searchCondition="";
        return new ResponseDTO<>(areaService.getAreaList(searchCondition,page,size));
    }

    @GetMapping(value = "/getAreaListByFloor")
    public ResponseDTO<?> getAreaListByFloor(@RequestParam Long floorId){
        return new ResponseDTO<>(areaService.getAreaListByFloor(floorId));
    }

    @DeleteMapping(value = "/deleteById")
    public ResponseDTO<?> deleteById(@RequestParam Long id){
        return  new ResponseDTO<>(areaService.deleteById(id));
    }
}
