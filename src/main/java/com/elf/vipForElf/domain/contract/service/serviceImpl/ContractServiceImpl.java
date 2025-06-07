package com.elf.vipForElf.domain.contract.service.serviceImpl;

import com.elf.vipForElf.domain.contract.repository.ContractRepository;
import com.elf.vipForElf.domain.contract.service.ContractService;
import com.elf.vipForElf.domain.contract.vo.ChangeContractVO;
import com.elf.vipForElf.domain.contract.vo.NewContract;
import com.elf.vipForElf.web.dto.ContractIdDTO;
import com.elf.vipForElf.web.dto.NewContractDTO;
import com.elf.vipForElf.web.dto.RegisterContractDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ContractServiceImpl implements ContractService {
    private final ContractRepository contractRepository;

    public ContractServiceImpl(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @Override
    public RegisterContractDTO newContract(NewContractDTO newContractDTO, MultipartFile contractFile) throws IllegalAccessException {
        //TODO 현재는 파일명으로 저장하나, 나중에는 링크 만들어야함
        if(contractRepository.checkAvailableContract(newContractDTO.getRealEstateListingId(), newContractDTO.getRealEstateAgencyId())){
            NewContract newContract = new NewContract(newContractDTO);
            return contractRepository.registerContract(newContract,contractFile.getOriginalFilename());
        }else{
            throw new IllegalAccessException("이미 다른 부동산에서 존재한 계약");
        }
    }

    @Override
    public String checkContract(ContractIdDTO contractIdDTO) {
        ChangeContractVO changeContractVO = new ChangeContractVO(contractIdDTO.getContractId(),"Reviewed");
        return contractRepository.changeStatusByContractId(changeContractVO);

    }

    @Override
    public String rejectContractByLandLord(ContractIdDTO contractIdDTO) {
        ChangeContractVO changeContractVO = new ChangeContractVO(contractIdDTO.getContractId(),"Reject_By_LandLord");
        return contractRepository.changeStatusByContractId(changeContractVO);
    }

    @Override
    public String rejectContractByTenant(ContractIdDTO contractIdDTO) {
        ChangeContractVO changeContractVO = new ChangeContractVO(contractIdDTO.getContractId(), "Reject_By_Tenant");
        return contractRepository.changeStatusByContractId(changeContractVO);
    }

    @Override
    public String submitContract(ContractIdDTO contractIdDTO) {
        ChangeContractVO changeContractVO = new ChangeContractVO(contractIdDTO.getContractId(),"Submit");
        return contractRepository.changeStatusByContractId(changeContractVO);
    }
}
