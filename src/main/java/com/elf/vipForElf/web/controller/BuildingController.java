package com.elf.vipForElf.web.controller;

import com.elf.vipForElf.domain.test.service.BuildingService;
import com.elf.vipForElf.domain.test.vo.BuildingInfoVO;
import com.elf.vipForElf.domain.test.vo.BuildingListVO;
import com.elf.vipForElf.web.dto.NewBuildingDTO;
import com.elf.vipForElf.web.dto.ResponseDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "빌딩",description = "빌딩 관련 API")
@RestController
@RequestMapping("/building")
public class BuildingController {
    private final BuildingService buildingService;

    public BuildingController(BuildingService buildingService) {
        this.buildingService = buildingService;
    }

    // 빌딩 추가
    @PostMapping(value = "/putBuilding")
    public ResponseDTO<BuildingInfoVO> putBuilding(@RequestBody NewBuildingDTO newBuildingDTO){
        return new ResponseDTO<>(buildingService.putBuilding(newBuildingDTO));
    }

    // 빌딩고유값(ID)으로 단건 조회
    @GetMapping(value = "/getBuildingById")
    public ResponseDTO<Optional<BuildingInfoVO>> getBuildingById(@RequestParam Long id){
        return new ResponseDTO<>(buildingService.getBuildingById(id));
    }

    // 빌딩 리스트 조회 TODO(최신순, 조회순 가능하게)
    @GetMapping(value ="/getBuildingList")
    public ResponseDTO<List<BuildingListVO>> getBuildingList(@RequestParam(required = false) String searchCondiiton, @RequestParam int page, @RequestParam int size){
        if(searchCondiiton==null) searchCondiiton="";
        return new ResponseDTO<>(buildingService.getBuildingList(searchCondiiton, page, size));
    }

    @DeleteMapping(value = "/deleteBuildingById")
    public ResponseDTO<String> deleteBuildingById(@RequestParam Long id){
        return new ResponseDTO<>(buildingService.deleteBuildingById(id));
    }
}
