package com.elf.vipForElf.domain.test.service;

import com.elf.vipForElf.domain.test.entity.BuildingEntity;
import com.elf.vipForElf.domain.test.vo.BuildingInfoVO;
import com.elf.vipForElf.domain.test.vo.BuildingListVO;
import com.elf.vipForElf.web.dto.NewBuildingDTO;

import java.util.List;
import java.util.Optional;

public interface BuildingService {

    BuildingInfoVO putBuilding(NewBuildingDTO newBuildingDTO);
    Optional<BuildingInfoVO> getBuildingById(Long id);
    List<BuildingListVO> getBuildingList(String searchCondition, int page, int size);
    String deleteBuildingById(Long id);
    Boolean existById(Long id);
    BuildingEntity getBuildingEntityById(Long id);
}
