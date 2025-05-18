package com.elf.vipForElf.domain.realEstateAgency.repository.repositoryImpl;

import com.elf.vipForElf.domain.realEstateAgency.repository.JPA.RealEstateAgencyJPARepository;
import com.elf.vipForElf.domain.realEstateAgency.repository.RealEstateAgencyRepository;
import org.springframework.stereotype.Repository;

@Repository
public class RealEstateAgencyRepositoryImpl implements RealEstateAgencyRepository {
    private final RealEstateAgencyJPARepository realEstateAgencyJPARepository;

    public RealEstateAgencyRepositoryImpl(RealEstateAgencyJPARepository realEstateAgencyJPARepository) {
        this.realEstateAgencyJPARepository = realEstateAgencyJPARepository;
    }
}
