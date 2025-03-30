package com.elf.vipForElf.domain.test.service;

import com.elf.vipForElf.domain.test.vo.FloorInfoVO;
import com.elf.vipForElf.domain.test.vo.FloorListVO;
import com.elf.vipForElf.web.dto.NewFloorDTO;

import java.util.List;

public interface FloorService {
    FloorInfoVO createFloor(NewFloorDTO newFloorDTO) throws IllegalAccessException;
    FloorInfoVO getFloorById(Long id);
    List<FloorListVO> getFloorList(String searchCondition, Integer page, Integer size);
}
