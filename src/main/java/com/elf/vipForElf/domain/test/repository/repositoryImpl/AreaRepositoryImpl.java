package com.elf.vipForElf.domain.test.repository.repositoryImpl;

import com.elf.vipForElf.domain.test.entity.AreaEntity;
import com.elf.vipForElf.domain.test.repository.AreaRepository;
import com.elf.vipForElf.domain.test.repository.JPA.AreaJPARepository;
import com.elf.vipForElf.domain.test.vo.AreaInfoVO;
import com.elf.vipForElf.domain.test.vo.AreaListVO;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

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
        //Todo 나가는거 고려
        areaEntity.setStatus("MovedIn");
        //TODO moveInHistory 추가 필요
        return new AreaInfoVO(areaJPARepository.save(areaEntity));
    }

    @Override
    public AreaInfoVO findById(Long id) {
        AreaInfoVO areaInfoVO = new AreaInfoVO(areaJPARepository.findById(id).orElseThrow());
        return areaInfoVO;
    }

    @Override
    public List<AreaListVO> findAll(Pageable pageable) {
        return areaJPARepository.findAll(pageable).stream().map(
                AreaListVO::new
        ).toList();
    }

    @Override
    public List<AreaListVO> findAreaBySearchCondition(String searchCondition, Pageable pageable) {
        Long id = null;
        try{
            id = Long.parseLong(searchCondition);
        }catch (NumberFormatException e){

        }
        return areaJPARepository.findByIdOrOfficeNameIgnoreCaseOrRoomNumberIgnoreCase(id,searchCondition,searchCondition,pageable).stream()
                .map(AreaListVO::new).toList();
    }

    @Override
    public List<AreaListVO> findByFloorId(Long floorId) {
        return areaJPARepository.findByFloorId(floorId).stream()
                .map(AreaListVO::new).toList();
    }

    @Override
    public Boolean deleteById(Long id) {
        if(areaJPARepository.existsById(id)){
            areaJPARepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
