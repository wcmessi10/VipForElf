package com.elf.vipForElf.domain.test.repository;

import com.elf.vipForElf.domain.test.vo.AreaInfoVO;

public interface AreaRepository {

    Boolean existsRoomNumber(Long floorId, String roomNumber);
    AreaInfoVO createArea(AreaInfoVO areaInfoVO);
    AreaInfoVO update(AreaInfoVO areaInfoVO);
}
