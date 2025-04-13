package com.elf.vipForElf.domain.building.repository.JPA;

import com.elf.vipForElf.domain.building.entity.BuildingEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingJPARepository extends JpaRepository<BuildingEntity, Long> {
    boolean existsByBuildingNumber(String buildingNumber);
    Page<BuildingEntity> findByBuildingNameIgnoreCaseOrBuildingNumberIgnoreCase(String searchCondition1, String searchCondition2, Pageable pageable);
}
