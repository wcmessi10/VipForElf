package com.elf.vipForElf.domain.test.repository;

import com.elf.vipForElf.domain.test.vo.TestVO;
import com.elf.vipForElf.web.dto.TestDTO;

import java.util.Optional;

public interface TestRepository {
    Optional<TestVO> getById(String id);
}
