package com.elf.vipForElf.domain.contract.service.serviceImpl;

import com.elf.vipForElf.domain.contract.repository.ContractRepository;
import com.elf.vipForElf.domain.contract.service.ContractService;
import org.springframework.stereotype.Service;

@Service
public class ContractServiceImpl implements ContractService {
    private final ContractRepository contractRepository;

    public ContractServiceImpl(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }
}
