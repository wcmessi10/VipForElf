package com.elf.vipForElf.domain.contract.vo;

import com.elf.vipForElf.web.dto.NewContractDTO;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class NewContract {
    Long realEstateListingId;
    Long realEstateAgencyId;
    String landLordId;
    OffsetDateTime moveInDt;

    public NewContract(NewContractDTO newContractDTO){
        this.realEstateAgencyId = newContractDTO.getRealEstateAgencyId();
        this.realEstateListingId = newContractDTO.getRealEstateListingId();
        this.moveInDt = newContractDTO.getMoveInDt();
        this.landLordId = newContractDTO.getLandLordId();
    }
}
