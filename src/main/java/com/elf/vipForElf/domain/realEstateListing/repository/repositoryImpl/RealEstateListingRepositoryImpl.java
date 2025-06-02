package com.elf.vipForElf.domain.realEstateListing.repository.repositoryImpl;

import com.elf.vipForElf.domain.realEstateAgency.entity.RealEstateAgencyEntity;
import com.elf.vipForElf.domain.realEstateListing.entity.RealEstateListingEntity;
import com.elf.vipForElf.domain.realEstateListing.repository.JPA.RealEstateListingJPARepository;
import com.elf.vipForElf.domain.realEstateListing.repository.RealEstateListingRepository;
import com.elf.vipForElf.domain.realEstateListing.vo.RealEstateListingRow;
import com.elf.vipForElf.web.dto.NewRealEstateListingDTO;
import com.elf.vipForElf.web.dto.RegistedRealEstateListingDTO;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public Long getTotalCount() {
        return realEstateListingJPARepository.count();
    }

    @Override
    public List<RealEstateListingRow> getRealEstateListingList(Integer page, Integer size, String searchCondition) {
        Pageable pageable = PageRequest.of(page,size, Sort.by("registDt"));
        return realEstateListingJPARepository.findByListingNameContainingIgnoreCase(searchCondition,pageable).stream()
                .map(RealEstateListingRow::new).toList();
    }

    @Override
    public RegistedRealEstateListingDTO getById(Long id) {
        return new RegistedRealEstateListingDTO(realEstateListingJPARepository.findById(id).orElseThrow());
    }
}
