package com.elf.vipForElf.domain.realEstateAgency.repository.repositoryImpl;

import com.elf.vipForElf.domain.realEstateAgency.entity.RealEstateAgencyEntity;
import com.elf.vipForElf.domain.realEstateAgency.repository.JPA.RealEstateAgencyJPARepository;
import com.elf.vipForElf.domain.realEstateAgency.repository.RealEstateAgencyRepository;
import com.elf.vipForElf.domain.realEstateAgency.vo.RealEstateAgencyRow;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RealEstateAgencyRepositoryImpl implements RealEstateAgencyRepository {
    private final RealEstateAgencyJPARepository realEstateAgencyJPARepository;

    public RealEstateAgencyRepositoryImpl(RealEstateAgencyJPARepository realEstateAgencyJPARepository) {
        this.realEstateAgencyJPARepository = realEstateAgencyJPARepository;
    }

    @Override
    public RealEstateAgencyEntity save(RealEstateAgencyEntity realEstateAgencyEntity) {
        return realEstateAgencyJPARepository.save(realEstateAgencyEntity);
    }

    @Override
    public List<RealEstateAgencyRow> getRealEstateAgencyList(String searchCondition, Pageable pageable) {
        Page<RealEstateAgencyEntity> realEstateAgencyEntityPage = realEstateAgencyJPARepository.findByRealEstateAgencyNameContainingIgnoreCaseOrContactContainingIgnoreCase(searchCondition,searchCondition,pageable);
        return realEstateAgencyEntityPage.stream().map(
                RealEstateAgencyRow:: new
        ).toList();
    }

    @Override
    public Long getTotalCount() {
        return realEstateAgencyJPARepository.count();
    }

    @Override
    public RealEstateAgencyEntity getById(Long id) {
        return realEstateAgencyJPARepository.findById(id).orElseThrow();
    }
}
