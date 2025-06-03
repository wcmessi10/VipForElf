package com.elf.vipForElf.domain.contract.service;

import com.elf.vipForElf.web.dto.NewContractDTO;
import com.elf.vipForElf.web.dto.RegisterContractDTO;
import org.springframework.web.multipart.MultipartFile;

public interface ContractService {
    RegisterContractDTO newContract(NewContractDTO newContractDTO, MultipartFile contractFile) throws IllegalAccessException;
}
