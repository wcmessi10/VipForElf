package com.elf.vipForElf.domain.test.repository.repositoryImpl;

import com.elf.vipForElf.domain.test.entity.TestEntity;
import com.elf.vipForElf.domain.test.repository.JPA.TestJPARepository;
import com.elf.vipForElf.domain.test.repository.TestRepository;
import com.elf.vipForElf.domain.test.vo.TestVO;
import com.elf.vipForElf.web.dto.TestDTO;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class TestRepositoryImpl implements TestRepository {
    private final TestJPARepository testJPARepository;

    public TestRepositoryImpl(TestJPARepository testJPARepository) {
        this.testJPARepository = testJPARepository;
    }

    @Override
    public Optional<TestVO> getById(String id) {
        return testJPARepository.findById(id).map(
                TestVO::fromEntity
        );
    }
}
