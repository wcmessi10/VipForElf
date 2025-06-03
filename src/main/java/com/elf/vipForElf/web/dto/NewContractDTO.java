package com.elf.vipForElf.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Getter
@NoArgsConstructor
public class NewContractDTO {
    Long realEstateListingId;
    Long realEstateAgencyId;
    String landLordId;
    OffsetDateTime moveInDt;
}
