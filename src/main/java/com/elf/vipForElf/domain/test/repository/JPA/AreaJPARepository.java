package com.elf.vipForElf.domain.test.repository.JPA;

import com.elf.vipForElf.domain.test.entity.AreaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AreaJPARepository extends JpaRepository<AreaEntity,Long> {
    Boolean existsByFloorIdAndRoomNumber(Long FloorId,String roomNumber);
    Page<AreaEntity> findByIdOrOfficeNameIgnoreCaseOrRoomNumberIgnoreCase(Long id, String officeName, String roomNumber, Pageable pageable);
    List<AreaEntity> findByFloorId(Long floorId);
}
