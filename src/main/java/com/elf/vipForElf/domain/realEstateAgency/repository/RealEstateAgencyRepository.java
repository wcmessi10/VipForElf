package com.elf.vipForElf.domain.realEstateAgency.repository;

import com.elf.vipForElf.domain.realEstateAgency.entity.RealEstateAgencyEntity;
import com.elf.vipForElf.domain.realEstateAgency.vo.RealEstateAgencyRow;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RealEstateAgencyRepository {
    RealEstateAgencyEntity save(RealEstateAgencyEntity realEstateAgencyEntity);
    List<RealEstateAgencyRow> getRealEstateAgencyList(String searchCondition, Pageable pageable);
    Long getTotalCount();
    RealEstateAgencyEntity getById(Long id);
}
