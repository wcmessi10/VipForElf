package com.elf.vipForElf.domain.realEstateListing.repository.repositoryImpl;

import com.elf.vipForElf.domain.realEstateListing.repository.JPA.RealEstateListingJPARepository;
import com.elf.vipForElf.domain.realEstateListing.repository.RealEstateListingRepository;
import org.springframework.stereotype.Repository;

@Repository
public class RealEstateListingRepositoryImpl implements RealEstateListingRepository {
    private final RealEstateListingJPARepository realEstateListingJPARepository;

    public RealEstateListingRepositoryImpl(RealEstateListingJPARepository realEstateListingJPARepository) {
        this.realEstateListingJPARepository = realEstateListingJPARepository;
    }
}
