package com.elf.vipForElf.domain.test.repository.JPA;

import com.elf.vipForElf.domain.test.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestJPARepository extends JpaRepository<TestEntity,String> {
}
