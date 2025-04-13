package com.elf.vipForElf.domain.moveInHistory.repository.repositoryImpl;

import com.elf.vipForElf.domain.moveInHistory.repository.JPA.MoveInHistoryJPARepository;
import com.elf.vipForElf.domain.moveInHistory.repository.MoveInHistoryRepository;
import org.springframework.stereotype.Repository;

@Repository
public class MoveInHistoryRepositoryImpl implements MoveInHistoryRepository {
    private final MoveInHistoryJPARepository moveInHistoryJPARepository;

    public MoveInHistoryRepositoryImpl(MoveInHistoryJPARepository moveInHistoryJPARepository) {
        this.moveInHistoryJPARepository = moveInHistoryJPARepository;
    }
}
