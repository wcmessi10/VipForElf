package com.elf.vipForElf.domain.test.service;

import com.elf.vipForElf.domain.test.vo.AreaInfoVO;
import com.elf.vipForElf.domain.test.vo.AreaListVO;
import com.elf.vipForElf.web.dto.MoveInAreaDTO;
import com.elf.vipForElf.web.dto.NewAreaDTO;

import java.util.List;

public interface AreaService {
    AreaInfoVO createArea(NewAreaDTO newAreaDTO);
    AreaInfoVO moveIn(MoveInAreaDTO moveInAreaDTO);
    AreaInfoVO findAreaById(Long id);
    List<AreaListVO> getAreaList(String searchCondition, int page, int size);
    List<AreaListVO> getAreaListByFloor(Long floorId);
    String deleteById(Long id);
}
