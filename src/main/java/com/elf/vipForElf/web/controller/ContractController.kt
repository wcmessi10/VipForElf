package com.elf.vipForElf.web.controller

import com.elf.vipForElf.domain.contract.service.ContractService
import com.elf.vipForElf.domain.contract.vo.ContractRow
import com.elf.vipForElf.web.dto.*
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/contract")
class ContractController(
    private val contractService: ContractService
) {

    @PostMapping("/newContract")
    fun newContract(
        @RequestPart(name = "body") newContractDTO: NewContractDTO,
        @RequestPart(name = "file") contractFile: MultipartFile
    ): ResponseDTO<RegisterContractDTO> {
        return ResponseDTO(
            contractService.newContract(newContractDTO, contractFile)
        )
    }

    @PostMapping("/checkContract")
    fun checkContract(
        @RequestBody contractIdDTO: ContractIdDTO
    ): ResponseDTO<String> {
        return ResponseDTO(
            contractService.checkContract(contractIdDTO)
        )
    }

    @PostMapping("/rejectContractByLandLord")
    fun rejectContractByLandLord(
        @RequestBody contractIdDTO: ContractIdDTO
    ): ResponseDTO<String> {
        return ResponseDTO(
            contractService.rejectContractByLandLord(contractIdDTO)
        )
    }

    @PostMapping("/rejectContractByTenant")
    fun rejectContractByTenant(
        @RequestBody contractIdDTO: ContractIdDTO
    ): ResponseDTO<String> {
        return ResponseDTO(
            contractService.rejectContractByTenant(contractIdDTO)
        )
    }

    @PostMapping("/submitContract")
    fun submitContract(
        @RequestBody contractIdDTO: ContractIdDTO
    ): ResponseDTO<String> {
        return ResponseDTO(
            contractService.submitContract(contractIdDTO)
        )
    }

    @GetMapping("/getContractListByLandLordId")
    fun getContractListByLandLordId(
        @RequestParam landLordId: String
    ): ResponseDTO<List<ContractRow>> {
        return ResponseDTO(
            contractService.getContractListByLandLordId(landLordId)
        )
    }
}
