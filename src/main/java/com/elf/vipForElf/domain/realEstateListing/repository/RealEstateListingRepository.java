package com.elf.vipForElf.domain.realEstateListing.repository;

import com.elf.vipForElf.domain.realEstateAgency.entity.RealEstateAgencyEntity;
import com.elf.vipForElf.web.dto.NewRealEstateListingDTO;
import com.elf.vipForElf.web.dto.RegistedRealEstateListingDTO;

public interface RealEstateListingRepository {
    RegistedRealEstateListingDTO registRealEstateListing(NewRealEstateListingDTO newRealEstateListingDTO, RealEstateAgencyEntity realEstateAgencyEntity) throws IllegalAccessException;
}
