package com.elf.vipForElf.domain.contract.repository;

import com.elf.vipForElf.domain.contract.vo.ChangeContractVO;
import com.elf.vipForElf.domain.contract.vo.ContractRow;
import com.elf.vipForElf.domain.contract.vo.NewContract;
import com.elf.vipForElf.web.dto.RegisterContractDTO;

import java.util.List;

public interface ContractRepository {
    Boolean checkAvailableContract(Long realEstateListingId, Long realEstateAgencyId);

    RegisterContractDTO registerContract(NewContract newContract, String pdfFileLink);

    String changeStatusByContractId(ChangeContractVO contractId);

    List<ContractRow> getContractListByLandLordId(String landLordId);
}
