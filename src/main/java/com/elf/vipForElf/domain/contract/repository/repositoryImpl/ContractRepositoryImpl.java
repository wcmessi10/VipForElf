package com.elf.vipForElf.domain.contract.repository.repositoryImpl;

import com.elf.vipForElf.domain.contract.entity.ContractEntity;
import com.elf.vipForElf.domain.contract.repository.ContractRepository;
import com.elf.vipForElf.domain.contract.repository.JPA.ContractJPARepository;
import com.elf.vipForElf.domain.contract.vo.ChangeContractVO;
import com.elf.vipForElf.domain.contract.vo.NewContract;
import com.elf.vipForElf.domain.realEstateAgency.entity.RealEstateAgencyEntity;
import com.elf.vipForElf.domain.realEstateListing.entity.RealEstateListingEntity;
import com.elf.vipForElf.web.dto.ContractRow;
import com.elf.vipForElf.web.dto.RegisterContractDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public String changeStatusByContractId(ChangeContractVO changeContractVO) {
        ContractEntity contractEntity = contractJPARepository.findByContractId(changeContractVO.getContractId());
        switch (changeContractVO.getStatus()){
            case "Register":
                contractEntity.setContractStatus(ContractEntity.ContractStatus.APPLY_FOR_CONTRACT);
                break;
            case "Reviewed":
                contractEntity.setContractStatus(ContractEntity.ContractStatus.REVIEWED_BY_LANDLORD);
                break;
            case "Reject_By_LandLord":
                contractEntity.setContractStatus(ContractEntity.ContractStatus.REJECT_BY_LANDLORD);
                break;
            case "Reject_By_Tenant":
                contractEntity.setContractStatus(ContractEntity.ContractStatus.REJECT_BY_TENANT);
                break;
            case "Submit":
                contractEntity.setContractStatus(ContractEntity.ContractStatus.SUBMIT_CONTRACT);
                break;
        }
        return contractJPARepository.save(contractEntity).getContractStatus().name();
    }

    @Override
    public List<ContractRow> getContractListByLandLordId(String landLordId) {
        return contractJPARepository.findByLandLordId(landLordId).stream()
                .map(contractEntity ->{
                    String listingName = contractEntity.getRealEstateListingEntity() != null
                            ? contractEntity.getRealEstateListingEntity().getListingName()
                            : null;
                    return new ContractRow(
                            contractEntity.getContractId(),
                            listingName,
                            contractEntity.getContractStatus().name()
                    );
                })
                .toList();
    }
}
