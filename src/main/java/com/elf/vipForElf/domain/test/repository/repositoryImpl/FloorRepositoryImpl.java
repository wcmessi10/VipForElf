package com.elf.vipForElf.domain.test.repository.repositoryImpl;

import com.elf.vipForElf.domain.test.entity.FloorEntity;
import com.elf.vipForElf.domain.test.repository.FloorRepository;
import com.elf.vipForElf.domain.test.repository.JPA.FloorJPARepository;
import com.elf.vipForElf.domain.test.vo.FloorInfoVO;
import org.springframework.stereotype.Repository;

@Repository
public class FloorRepositoryImpl implements FloorRepository {
    private final FloorJPARepository floorJPARepository;

    public FloorRepositoryImpl(FloorJPARepository floorJPARepository) {
        this.floorJPARepository = floorJPARepository;
    }

    @Override
    public FloorInfoVO createFloor(FloorInfoVO floorInfoVO) {
        FloorEntity floorEntity = new FloorEntity().floorEntity(floorInfoVO);
        return new FloorInfoVO(floorJPARepository.save(floorEntity));
    }
}
