package com.elf.vipForElf.domain.test.service;

import com.elf.vipForElf.domain.test.vo.BuildingInfoVO;
import com.elf.vipForElf.web.dto.NewBuildingDTO;

import java.util.Optional;

public interface BuildingService {

    BuildingInfoVO putBuilding(NewBuildingDTO newBuildingDTO);
    Optional<BuildingInfoVO> getBuildingById(Long id);
}
