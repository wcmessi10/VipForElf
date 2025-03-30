package com.elf.vipForElf.web.controller;

import com.elf.vipForElf.domain.test.service.FloorService;
import com.elf.vipForElf.web.dto.NewFloorDTO;
import com.elf.vipForElf.web.dto.ResponseDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/floor")
public class FloorController {
    private final FloorService floorService;

    public FloorController(FloorService floorService) {
        this.floorService = floorService;
    }

    @PostMapping(value = "/createFloor")
    public ResponseDTO<?> createFloor(@RequestBody NewFloorDTO newFloorDTO) throws IllegalAccessException {
        return new ResponseDTO<>(floorService.createFloor(newFloorDTO));
    }

    @GetMapping(value = "/getFloorById")
    public ResponseDTO<?> getFloorById(@RequestParam Long id){
        return new ResponseDTO<>(floorService.getFloorById(id));
    }

    @GetMapping(value = "/getFloorList")
    public ResponseDTO<?> getFloorList(@RequestParam(required = false) String searchCondition, Integer page, Integer size){
        if(searchCondition==null) searchCondition="";
        return new ResponseDTO<>(floorService.getFloorList(searchCondition,page,size));
    }
}
