package com.elf.vipForElf.domain.test.repository;

import com.elf.vipForElf.domain.test.entity.FloorEntity;
import com.elf.vipForElf.domain.test.vo.FloorInfoVO;
import com.elf.vipForElf.domain.test.vo.FloorListVO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FloorRepository {
    FloorInfoVO createFloor(FloorInfoVO floorInfoVO);
    FloorInfoVO getFloorById(Long id);
    FloorEntity getFloorEntityById(Long id);
    List<FloorListVO> findAll(Pageable pageable);
    List<FloorListVO> findBySearchCondition(String searchCondition, Pageable pageable);
}
