package com.elf.vipForElf.domain.contract.service;

import com.elf.vipForElf.web.dto.ContractIdDTO;
import com.elf.vipForElf.web.dto.NewContractDTO;
import com.elf.vipForElf.web.dto.RegisterContractDTO;
import org.springframework.web.multipart.MultipartFile;

public interface ContractService {
    RegisterContractDTO newContract(NewContractDTO newContractDTO, MultipartFile contractFile) throws IllegalAccessException;

    String checkContract(ContractIdDTO contractIdDTO);

    String rejectContractByLandLord(ContractIdDTO contractIdDTO);

    String rejectContractByTenant(ContractIdDTO contractIdDTO);
    String submitContract(ContractIdDTO contractIdDTO);
}
