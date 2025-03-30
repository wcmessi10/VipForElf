package com.elf.vipForElf.domain.test.service;

import com.elf.vipForElf.domain.test.vo.FloorInfoVO;
import com.elf.vipForElf.web.dto.NewFloorDTO;

public interface FloorService {
    FloorInfoVO createFloor(NewFloorDTO newFloorDTO) throws IllegalAccessException;
}
