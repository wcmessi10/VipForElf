package com.elf.vipForElf.domain.test.service;

import com.elf.vipForElf.domain.test.vo.AreaInfoVO;
import com.elf.vipForElf.web.dto.MoveInAreaDTO;
import com.elf.vipForElf.web.dto.NewAreaDTO;

public interface AreaService {
    AreaInfoVO createArea(NewAreaDTO newAreaDTO);
    AreaInfoVO moveIn(MoveInAreaDTO moveInAreaDTO);
}
