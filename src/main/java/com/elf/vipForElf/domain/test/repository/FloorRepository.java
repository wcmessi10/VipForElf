package com.elf.vipForElf.domain.test.repository;

import com.elf.vipForElf.domain.test.vo.FloorInfoVO;

public interface FloorRepository {
    FloorInfoVO createFloor(FloorInfoVO floorInfoVO);
    FloorInfoVO getFloorById(Long id);
}
