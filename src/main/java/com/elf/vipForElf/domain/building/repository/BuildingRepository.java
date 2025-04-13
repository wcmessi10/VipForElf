package com.elf.vipForElf.domain.building.repository;

import com.elf.vipForElf.domain.building.entity.BuildingEntity;
import com.elf.vipForElf.domain.building.vo.BuildingInfoVO;
import com.elf.vipForElf.domain.building.vo.BuildingListVO;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BuildingRepository {
    BuildingInfoVO create(BuildingInfoVO buildingInfoVO);
    Optional<BuildingInfoVO> getById(Long id);
    boolean existsById(Long id);
    List<BuildingListVO> findAll(Pageable pageable);
    List<BuildingListVO> findBySearchCondition(String searchCondition, Pageable pageable);
    String deleteBuildingById(Long id);
    BuildingEntity getBuildingEntityById(Long id);
}
