package com.elf.vipForElf.domain.moveInHistory.repository.JPA;

import com.elf.vipForElf.domain.moveInHistory.entity.MoveInHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoveInHistoryJPARepository extends JpaRepository<MoveInHistoryEntity,String> {
}
