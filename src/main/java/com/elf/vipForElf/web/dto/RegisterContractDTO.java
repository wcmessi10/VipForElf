package com.elf.vipForElf.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RegisterContractDTO {
    Long contractId;

    public RegisterContractDTO(Long contractId){
        this.contractId = contractId;
    }
}
