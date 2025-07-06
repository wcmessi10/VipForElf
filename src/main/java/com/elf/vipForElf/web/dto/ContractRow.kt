package com.elf.vipForElf.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ContractRow {
    Long contractId;
    String listingName;
    String contractStatus;
}
