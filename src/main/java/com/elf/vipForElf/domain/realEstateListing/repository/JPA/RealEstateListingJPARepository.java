package com.elf.vipForElf.domain.realEstateListing.repository.JPA;

import com.elf.vipForElf.domain.realEstateListing.entity.RealEstateListingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RealEstateListingJPARepository extends JpaRepository<RealEstateListingEntity,Long> {
}
