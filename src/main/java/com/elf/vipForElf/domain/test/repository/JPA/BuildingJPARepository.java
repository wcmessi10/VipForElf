package com.elf.vipForElf.domain.test.repository.JPA;

import com.elf.vipForElf.domain.test.entity.BuildingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingJPARepository extends JpaRepository<BuildingEntity, Long> {
    boolean existsByBuildingNumber(String buildingNumber);
}
