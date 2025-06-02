package com.elf.vipForElf.domain.realEstateListing.repository;

import com.elf.vipForElf.domain.realEstateAgency.entity.RealEstateAgencyEntity;
import com.elf.vipForElf.domain.realEstateListing.vo.RealEstateListingRow;
import com.elf.vipForElf.web.dto.NewRealEstateListingDTO;
import com.elf.vipForElf.web.dto.RegistedRealEstateListingDTO;

import java.util.List;

public interface RealEstateListingRepository {
    RegistedRealEstateListingDTO registRealEstateListing(NewRealEstateListingDTO newRealEstateListingDTO, RealEstateAgencyEntity realEstateAgencyEntity) throws IllegalAccessException;
    Long getTotalCount();
    List<RealEstateListingRow> getRealEstateListingList(Integer page, Integer size,String searchCondition);
    RegistedRealEstateListingDTO getById(Long id);
}
