package com.elf.vipForElf.domain.floor.repository.repositoryImpl;

import com.elf.vipForElf.domain.floor.entity.FloorEntity;
import com.elf.vipForElf.domain.floor.repository.FloorRepository;
import com.elf.vipForElf.domain.floor.repository.JPA.FloorJPARepository;
import com.elf.vipForElf.domain.floor.vo.FloorInfoVO;
import com.elf.vipForElf.domain.floor.vo.FloorListVO;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public FloorInfoVO getFloorById(Long id) {
        FloorEntity floorEntity = floorJPARepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("No Floor by this id")
        );
        return new FloorInfoVO(floorEntity);
    }

    @Override
    public FloorEntity getFloorEntityById(Long id) {
        return floorJPARepository.findById(id).orElseThrow();
    }

    @Override
    public List<FloorListVO> findAll(Pageable pageable) {
        return floorJPARepository.findAll(pageable).stream().map(
                FloorListVO::new
        ).toList();
    }

    @Override
    public List<FloorListVO> findBySearchCondition(String searchCondition, Pageable pageable) {
        Long buildingId = null;
        Integer floorNumber = null;

        // buildingId로 사용하기 위해 Long으로 파싱 시도
        try {
            buildingId = Long.parseLong(searchCondition);
        } catch (NumberFormatException e) {
            // 숫자가 아니면 예외 발생 -> buildingId는 null로 유지
        }

        // floorNumber로 사용하기 위해 Integer로 파싱 시도
        try {
            floorNumber = Integer.parseInt(searchCondition);
        } catch (NumberFormatException e) {
            // 숫자가 아니면 예외 발생 -> floorNumber는 null로 유지
        }
        return floorJPARepository.findByBuildingIdOrFloorNumberOrPurposeIgnoreCase(buildingId, floorNumber, searchCondition,pageable).stream().map(
                FloorListVO::new
        ).toList();
    }
}
