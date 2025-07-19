package com.elf.vipForElf.domain.floor.service;

import com.elf.vipForElf.domain.floor.entity.FloorEntity;
import com.elf.vipForElf.domain.floor.vo.FloorInfoVO;
import com.elf.vipForElf.domain.floor.vo.FloorListVO;
import com.elf.vipForElf.web.dto.NewFloorDTO;

import java.util.List;

public interface FloorService {
    FloorInfoVO createFloor(NewFloorDTO newFloorDTO) throws IllegalAccessException;
    FloorInfoVO getFloorById(Long id);
    List<FloorListVO> getFloorList(String searchCondition, Integer page, Integer size);
    FloorEntity getFloorEntityById(Long id);
}
