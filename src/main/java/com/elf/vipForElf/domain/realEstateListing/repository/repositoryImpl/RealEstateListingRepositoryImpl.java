package com.elf.vipForElf.domain.realEstateListing.repository.repositoryImpl;

import com.elf.vipForElf.domain.realEstateAgency.entity.RealEstateAgencyEntity;
import com.elf.vipForElf.domain.realEstateListing.entity.RealEstateListingEntity;
import com.elf.vipForElf.domain.realEstateListing.repository.JPA.RealEstateListingJPARepository;
import com.elf.vipForElf.domain.realEstateListing.repository.RealEstateListingRepository;
import com.elf.vipForElf.web.dto.NewRealEstateListingDTO;
import com.elf.vipForElf.web.dto.RegistedRealEstateListingDTO;
import org.springframework.stereotype.Repository;

@Repository
public class RealEstateListingRepositoryImpl implements RealEstateListingRepository {
    private final RealEstateListingJPARepository realEstateListingJPARepository;

    public RealEstateListingRepositoryImpl(RealEstateListingJPARepository realEstateListingJPARepository) {
        this.realEstateListingJPARepository = realEstateListingJPARepository;
    }

    @Override
    public RegistedRealEstateListingDTO registRealEstateListing(NewRealEstateListingDTO newRealEstateListingDTO, RealEstateAgencyEntity realEstateAgencyEntity) throws IllegalAccessException {
        RealEstateListingEntity realEstateListingEntity = new RealEstateListingEntity(newRealEstateListingDTO,realEstateAgencyEntity);
        return new RegistedRealEstateListingDTO(realEstateListingJPARepository.save(realEstateListingEntity));
    }
}
