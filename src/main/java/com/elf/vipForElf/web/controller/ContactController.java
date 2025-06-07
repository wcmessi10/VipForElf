package com.elf.vipForElf.web.controller;

import com.elf.vipForElf.domain.contract.service.ContractService;
import com.elf.vipForElf.web.dto.ContractIdDTO;
import com.elf.vipForElf.web.dto.NewContractDTO;
import com.elf.vipForElf.web.dto.RegisterContractDTO;
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
    public ResponseDTO<RegisterContractDTO> newContract(@RequestPart(name = "body") NewContractDTO newContractDTO,
                                                        @RequestPart(name = "file") MultipartFile contractFile) throws IllegalAccessException {
        return new ResponseDTO<>(contractService.newContract(newContractDTO,contractFile));
    }

    @PostMapping("/checkContract")
    public ResponseDTO<String> checkContract(@RequestBody ContractIdDTO contractIdDTO){
        return new ResponseDTO<>(contractService.checkContract(contractIdDTO));
    }

    @PostMapping("/rejectContractByLandLord")
    public ResponseDTO<String> rejectContractByLandLord(@RequestBody ContractIdDTO contractIdDTO){
        return new ResponseDTO<>(contractService.rejectContractByLandLord(contractIdDTO));
    }

    @PostMapping("/rejectContractByTenant")
    public ResponseDTO<String> rejectContractByTenant(@RequestBody ContractIdDTO contractIdDTO){
        return new ResponseDTO<>(contractService.rejectContractByTenant(contractIdDTO));
    }

    @PostMapping("/submitContract")
    public ResponseDTO<String> submitContract(@RequestBody ContractIdDTO contractIdDTO){
        return new ResponseDTO<>(contractService.submitContract(contractIdDTO));
    }
}
