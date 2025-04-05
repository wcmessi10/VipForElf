package com.elf.vipForElf.domain.test.repository.JPA;

import com.elf.vipForElf.domain.test.entity.AreaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AreaJPARepository extends JpaRepository<AreaEntity,Long> {
    Boolean existsByFloorIdAndRoomNumber(Long FloorId,String roomNumber);
}
