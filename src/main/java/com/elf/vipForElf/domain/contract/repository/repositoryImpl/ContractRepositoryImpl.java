package com.elf.vipForElf.domain.contract.repository.repositoryImpl;

import com.elf.vipForElf.domain.contract.entity.ContractEntity;
import com.elf.vipForElf.domain.contract.repository.ContractRepository;
import com.elf.vipForElf.domain.contract.repository.JPA.ContractJPARepository;
import com.elf.vipForElf.domain.contract.vo.NewContract;
import com.elf.vipForElf.domain.realEstateAgency.entity.RealEstateAgencyEntity;
import com.elf.vipForElf.domain.realEstateListing.entity.RealEstateListingEntity;
import com.elf.vipForElf.web.dto.RegisterContractDTO;
import org.springframework.stereotype.Repository;

@Repository
public class ContractRepositoryImpl implements ContractRepository {
    private final ContractJPARepository contractJPARepository;

    public ContractRepositoryImpl(ContractJPARepository contractJPARepository) {
        this.contractJPARepository = contractJPARepository;
    }

    @Override
    public Boolean checkAvailableContract(Long realEstateListingId, Long realEstateAgencyId) {
        if(contractJPARepository.existsByRealEstateListingEntity_Id(realEstateListingId)
            && contractJPARepository.existsByRealEstateAgencyEntity_Id(realEstateAgencyId)){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public RegisterContractDTO registerContract(NewContract newContract,String pdfFileLink) {
        RealEstateListingEntity realEstateListingEntity = new RealEstateListingEntity();
        realEstateListingEntity.setId(newContract.getRealEstateListingId());
        RealEstateAgencyEntity realEstateAgencyEntity = new RealEstateAgencyEntity();
        realEstateAgencyEntity.setId(newContract.getRealEstateAgencyId());
        ContractEntity contractEntity = new ContractEntity(newContract,realEstateAgencyEntity,realEstateListingEntity,pdfFileLink);
        return new RegisterContractDTO(contractJPARepository.save(contractEntity).getContractId());
    }
}
