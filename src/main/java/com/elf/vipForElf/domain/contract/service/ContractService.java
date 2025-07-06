package com.elf.vipForElf.domain.contract.service;

import com.elf.vipForElf.domain.contract.vo.ContractRow;
import com.elf.vipForElf.web.dto.ContractIdDTO;
import com.elf.vipForElf.web.dto.NewContractDTO;
import com.elf.vipForElf.web.dto.RegisterContractDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ContractService {
    RegisterContractDTO newContract(NewContractDTO newContractDTO, MultipartFile contractFile) throws IllegalAccessException;

    String checkContract(ContractIdDTO contractIdDTO);

    String rejectContractByLandLord(ContractIdDTO contractIdDTO);

    String rejectContractByTenant(ContractIdDTO contractIdDTO);
    String submitContract(ContractIdDTO contractIdDTO);

    List<ContractRow> getContractListByLandLordId(String landLordId);
}
