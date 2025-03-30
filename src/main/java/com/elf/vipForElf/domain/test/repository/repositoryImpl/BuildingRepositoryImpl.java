package com.elf.vipForElf.domain.test.repository.repositoryImpl;

import com.elf.vipForElf.domain.test.entity.BuildingEntity;
import com.elf.vipForElf.domain.test.repository.BuildingRepository;
import com.elf.vipForElf.domain.test.repository.JPA.BuildingJPARepository;
import com.elf.vipForElf.domain.test.vo.BuildingInfoVO;
import com.elf.vipForElf.domain.test.vo.BuildingListVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository {
    private final BuildingJPARepository buildingJPARepository;

    public BuildingRepositoryImpl(BuildingJPARepository buildingJPARepository) {
        this.buildingJPARepository = buildingJPARepository;
    }

    @Override
    public BuildingInfoVO create(BuildingInfoVO buildingInfoVO) {
        BuildingEntity buildingEntity = new BuildingEntity(buildingInfoVO);
        if(existsByBuildingNumber(buildingEntity.getBuildingNumber())){
            throw new IllegalArgumentException("Already existed Building Number");
        }
        return new BuildingInfoVO(buildingJPARepository.save(buildingEntity));

    }

    @Override
    public Optional<BuildingInfoVO> getById(Long id) {
        return buildingJPARepository.findById(id).map(
                BuildingInfoVO::new
        );
    }

    @Override
    public boolean existsById(Long id) {
        return buildingJPARepository.existsById(id);
    }

    @Override
    public List<BuildingListVO> findAll(Pageable pageable) {

        Page<BuildingEntity> buildingEntityList = buildingJPARepository.findAll(pageable);
        return buildingEntityList.stream().map(
                BuildingListVO::new
        ).toList();
    }

    @Override
    public List<BuildingListVO> findBySearchCondition(String searchCondition, Pageable pageable) {
        return buildingJPARepository.findByBuildingNameIgnoreCaseOrBuildingNumberIgnoreCase(searchCondition,searchCondition, pageable)
                .stream().map(BuildingListVO::new).toList();
    }

    @Override
    public String deleteBuildingById(Long id) {
        if(existsById(id)){
            buildingJPARepository.deleteById(id);
            return "Succeeded Delete";
        }
        return "Failed Delete because this is not exist";
    }

    @Override
    public BuildingEntity getBuildingEntityById(Long id) {
        return buildingJPARepository.findById(id).get();
    }

    public boolean existsByBuildingNumber(String buildingNumber){
        return buildingJPARepository.existsByBuildingNumber(buildingNumber);
    }
}
