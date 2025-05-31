package com.elf.vipForElf.domain.contract.repository.repositoryImpl;

import com.elf.vipForElf.domain.contract.repository.ContractRepository;
import com.elf.vipForElf.domain.contract.repository.JPA.ContractJPARepository;
import org.springframework.stereotype.Repository;

@Repository
public class ContractRepositoryImpl implements ContractRepository {
    private final ContractJPARepository contractJPARepository;

    public ContractRepositoryImpl(ContractJPARepository contractJPARepository) {
        this.contractJPARepository = contractJPARepository;
    }
}
