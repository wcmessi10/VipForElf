package com.elf.vipForElf.web.controller;

import com.elf.vipForElf.domain.contract.service.ContractService;
import com.elf.vipForElf.web.dto.NewContractDTO;
import com.elf.vipForElf.web.dto.ResponseDTO;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/contract")
public class ContactController {
    private final ContractService contractService;

    public ContactController(ContractService contractService) {
        this.contractService = contractService;
    }

    @PostMapping("/newContract")
    public ResponseDTO<?> newContract(@RequestPart(name = "body") NewContractDTO newContractDTO,
                                      @RequestPart(name = "file") MultipartFile contractFile) throws IllegalAccessException {
        return new ResponseDTO<>(contractService.newContract(newContractDTO,contractFile));
    }
}
