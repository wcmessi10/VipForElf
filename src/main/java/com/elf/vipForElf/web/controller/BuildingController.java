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

    // 빌딩 리스트 조회 TODO(최신순, 조회순 가능하게)
    @GetMapping(value ="/getBuildingList")
    public ResponseDTO<?> getBuildingList(@RequestParam String searchCondiiton, @RequestParam int page, @RequestParam int size){
        return new ResponseDTO<>(buildingService.getBuildingList(searchCondiiton, page, size));
    }

    @DeleteMapping(value = "/deleteBuildingById")
    public ResponseDTO<?> deleteBuildingById(@RequestParam Long id){
        return new ResponseDTO<>(buildingService.deleteBuildingById(id));
    }
}
