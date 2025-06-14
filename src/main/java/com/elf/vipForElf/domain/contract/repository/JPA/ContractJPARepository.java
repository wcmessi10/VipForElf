package com.elf.vipForElf.domain.contract.repository.JPA;

import com.elf.vipForElf.domain.contract.entity.ContractEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContractJPARepository extends JpaRepository<ContractEntity,Long> {
    Boolean existsByRealEstateListingEntity_Id(Long id);
    Boolean existsByRealEstateAgencyEntity_Id(Long id);

    ContractEntity findByContractId(Long contractId);

    List<ContractEntity> findByLandLordId(String landLordId);
}
