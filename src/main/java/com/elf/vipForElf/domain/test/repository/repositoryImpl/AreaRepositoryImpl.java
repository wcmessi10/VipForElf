package com.elf.vipForElf.domain.test.repository.repositoryImpl;

import com.elf.vipForElf.domain.test.entity.AreaEntity;
import com.elf.vipForElf.domain.test.repository.AreaRepository;
import com.elf.vipForElf.domain.test.repository.JPA.AreaJPARepository;
import com.elf.vipForElf.domain.test.vo.AreaInfoVO;
import org.springframework.stereotype.Repository;

@Repository
public class AreaRepositoryImpl implements AreaRepository {

    private final AreaJPARepository areaJPARepository;

    public AreaRepositoryImpl(AreaJPARepository areaJPARepository) {
        this.areaJPARepository = areaJPARepository;
    }

    @Override
    public Boolean existsRoomNumber(Long floorId, String roomNumber) {
        return areaJPARepository.existsByFloorIdAndRoomNumber(floorId,roomNumber);
    }

    @Override
    public AreaInfoVO createArea(AreaInfoVO areaInfoVO) {
        AreaEntity areaEntity = new AreaEntity(areaInfoVO);
        AreaInfoVO result = new AreaInfoVO(areaJPARepository.save(areaEntity));
        return result;
    }

    @Override
    public AreaInfoVO update(AreaInfoVO areaInfoVO) {
        AreaEntity areaEntity = areaJPARepository.findById(areaInfoVO.getId()).orElseThrow();
        areaEntity.setOfficeName(areaInfoVO.getOfficeName());
        areaEntity.setMoveInDate(areaInfoVO.getMoveInDate());
        areaEntity.setStatus("MovedIn");
        //TODO moveInHistory 추가 필요
        return new AreaInfoVO(areaJPARepository.save(areaEntity));
    }
}
