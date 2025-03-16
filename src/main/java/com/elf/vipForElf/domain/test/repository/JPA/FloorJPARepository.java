package com.elf.vipForElf.domain.test.repository.JPA;

import com.elf.vipForElf.domain.test.entity.FloorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FloorJPARepository extends JpaRepository<FloorEntity,String> {
}
