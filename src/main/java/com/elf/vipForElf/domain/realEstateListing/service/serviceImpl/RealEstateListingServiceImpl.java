package com.elf.vipForElf.domain.realEstateListing.service.serviceImpl;

import com.elf.vipForElf.domain.realEstateAgency.entity.RealEstateAgencyEntity;
import com.elf.vipForElf.domain.realEstateAgency.repository.RealEstateAgencyRepository;
import com.elf.vipForElf.domain.realEstateListing.repository.RealEstateListingRepository;
import com.elf.vipForElf.domain.realEstateListing.service.RealEstateListingService;
import com.elf.vipForElf.domain.realEstateListing.vo.RealEstateListingRow;
import com.elf.vipForElf.web.dto.NewRealEstateListingDTO;
import com.elf.vipForElf.web.dto.RealEstateListingListDTO;
import com.elf.vipForElf.web.dto.RegistedRealEstateListingDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RealEstateListingServiceImpl implements RealEstateListingService {
    private final RealEstateListingRepository realEstateListingRepository;

    private final RealEstateAgencyRepository realEstateAgencyRepository;

    public RealEstateListingServiceImpl(RealEstateListingRepository realEstateListingRepository, RealEstateAgencyRepository realEstateAgencyRepository) {
        this.realEstateListingRepository = realEstateListingRepository;
        this.realEstateAgencyRepository = realEstateAgencyRepository;
    }

    @Override
    public RegistedRealEstateListingDTO registRealEstateListing(NewRealEstateListingDTO newRealEstateListingDTO) throws IllegalAccessException {
        RealEstateAgencyEntity realEstateAgencyEntity = realEstateAgencyRepository.getById(newRealEstateListingDTO.getRealEstateAgencyId());
        RegistedRealEstateListingDTO registedRealEstateListingDTO = realEstateListingRepository.registRealEstateListing(newRealEstateListingDTO,realEstateAgencyEntity);
        return registedRealEstateListingDTO;
    }

    @Override
    public RealEstateListingListDTO getRealEstateListingList(Integer page, Integer size, String searchCondition) {
        Long totalCount = realEstateListingRepository.getTotalCount();
        List<RealEstateListingRow> realEstateListingRowList = realEstateListingRepository.getRealEstateListingList(page,size,searchCondition);
        RealEstateListingListDTO realEstateListingListDTO = new RealEstateListingListDTO(totalCount,realEstateListingRowList);
        return realEstateListingListDTO;
    }

    @Override
    public RegistedRealEstateListingDTO getRealEstateListingDetail(Long id) {
        return realEstateListingRepository.getById(id);
    }
}
