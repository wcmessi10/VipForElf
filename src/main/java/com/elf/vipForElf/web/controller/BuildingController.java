package com.elf.vipForElf.web.controller;

import com.elf.vipForElf.domain.test.service.BuildingService;
import com.elf.vipForElf.web.dto.NewBuildingDTO;
import com.elf.vipForElf.web.dto.ResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/building")
public class BuildingController {
    private final BuildingService buildingService;

    public BuildingController(BuildingService buildingService) {
        this.buildingService = buildingService;
    }

    // 빌딩 추가
    @PostMapping(value = "/putBuilding")
    public ResponseDTO<?> putBuilding(@RequestBody NewBuildingDTO newBuildingDTO){
        return new ResponseDTO<>(buildingService.putBuilding(newBuildingDTO));
    }

    // 빌딩고유값(ID)으로 단건 조회
    @GetMapping(value = "/getBuildingById")
    public ResponseDTO<?> getBuildingById(@RequestParam Long id){
        return new ResponseDTO<>(buildingService.getBuildingById(id));
    }
}
