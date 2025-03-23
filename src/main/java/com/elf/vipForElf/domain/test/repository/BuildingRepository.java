package com.elf.vipForElf.domain.test.repository;

import com.elf.vipForElf.domain.test.vo.BuildingInfoVO;

import java.util.Optional;

public interface BuildingRepository {
    BuildingInfoVO create(BuildingInfoVO buildingInfoVO);
    Optional<BuildingInfoVO> getById(Long id);
    boolean existsById(Long id);
}
