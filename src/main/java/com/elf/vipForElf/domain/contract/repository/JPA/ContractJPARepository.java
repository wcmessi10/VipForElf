package com.elf.vipForElf.domain.contract.repository.JPA;

import com.elf.vipForElf.domain.contract.entity.ContractEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractJPARepository extends JpaRepository<ContractEntity,Long> {
    Boolean existsByRealEstateListingEntity_Id(Long id);
    Boolean existsByRealEstateAgencyEntity_Id(Long id);

    ContractEntity findByContractId(Long contractId);
}
