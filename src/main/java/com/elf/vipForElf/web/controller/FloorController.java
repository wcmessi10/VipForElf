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
}
