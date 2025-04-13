package com.elf.vipForElf.domain.area.repository;

import com.elf.vipForElf.domain.area.vo.AreaInfoVO;
import com.elf.vipForElf.domain.area.vo.AreaListVO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AreaRepository {

    Boolean existsRoomNumber(Long floorId, String roomNumber);
    AreaInfoVO createArea(AreaInfoVO areaInfoVO);
    AreaInfoVO update(AreaInfoVO areaInfoVO);
    AreaInfoVO findById(Long id);
    List<AreaListVO> findAll(Pageable pageable);
    List<AreaListVO> findAreaBySearchCondition(String searchCondition, Pageable pageable);
    List<AreaListVO> findByFloorId(Long floorId);
    Boolean deleteById(Long id);
}
