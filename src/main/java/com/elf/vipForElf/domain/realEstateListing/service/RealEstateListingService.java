package com.elf.vipForElf.domain.realEstateListing.service;

import com.elf.vipForElf.domain.realEstateListing.vo.RealEstateListingListDTO;
import com.elf.vipForElf.web.dto.NewRealEstateListingDTO;
import com.elf.vipForElf.web.dto.RegistedRealEstateListingDTO;

public interface RealEstateListingService {
    RegistedRealEstateListingDTO registRealEstateListing(NewRealEstateListingDTO newRealEstateListingDTO) throws IllegalAccessException;
    RealEstateListingListDTO getRealEstateListingList(Integer page, Integer size, String searchCondition);
    RegistedRealEstateListingDTO getRealEstateListingDetail(Long id);
}
