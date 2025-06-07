package com.elf.vipForElf.domain.contract.vo;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class ChangeContractVO {
    Long contractId;
    String status;
}
