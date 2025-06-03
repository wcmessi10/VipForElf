package com.elf.vipForElf.domain.contract.repository;

import com.elf.vipForElf.domain.contract.vo.NewContract;
import com.elf.vipForElf.web.dto.RegisterContractDTO;

public interface ContractRepository {
    Boolean checkAvailableContract(Long realEstateListingId, Long realEstateAgencyId);

    RegisterContractDTO registerContract(NewContract newContract,String pdfFileLink);
}
