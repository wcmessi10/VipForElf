package com.elf.vipForElf.domain.realEstateAgency.repository.JPA;

import com.elf.vipForElf.domain.realEstateAgency.entity.RealEstateAgencyEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RealEstateAgencyJPARepository extends JpaRepository<RealEstateAgencyEntity,Long> {
    Page<RealEstateAgencyEntity> findByRealEstateAgencyNameContainingIgnoreCaseOrContactContainingIgnoreCase(String searchCondition1,String searchCondition2, Pageable pageable);
}
