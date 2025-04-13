package com.elf.vipForElf.domain.floor.repository.JPA;

import com.elf.vipForElf.domain.floor.entity.FloorEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FloorJPARepository extends JpaRepository<FloorEntity,Long> {

    Page<FloorEntity> findByBuildingIdOrFloorNumberOrPurposeIgnoreCase(Long buildingId, Integer floorNumber, String purpose, Pageable pageable);
}
