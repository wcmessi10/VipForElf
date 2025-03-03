package com.elf.vipForElf.domain.test.service.serviceImpl;

import com.elf.vipForElf.domain.test.repository.TestRepository;
import com.elf.vipForElf.domain.test.service.TestService;
import com.elf.vipForElf.web.dto.TestDTO;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
    private final TestRepository testRepository;

    public TestServiceImpl(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @Override
    public TestDTO getById(String id) {
        return testRepository.getById(id).map(
                test -> new TestDTO(test.getId(),test.getTest())
        ).orElseThrow();
    }
}
