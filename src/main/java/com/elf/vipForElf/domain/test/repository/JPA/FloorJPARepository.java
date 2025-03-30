package com.elf.vipForElf.domain.test.repository.JPA;

import com.elf.vipForElf.domain.test.entity.FloorEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FloorJPARepository extends JpaRepository<FloorEntity,Long> {

    Page<FloorEntity> findByBuildingIdOrFloorNumberOrPurposeIgnoreCase(Long buildingId, Integer floorNumber, String purpose, Pageable pageable);
}
