package com.elf.vipForElf.domain.building.service.serviceImpl;

import com.elf.vipForElf.domain.building.entity.BuildingEntity;
import com.elf.vipForElf.domain.building.repository.BuildingRepository;
import com.elf.vipForElf.domain.building.service.BuildingService;
import com.elf.vipForElf.domain.building.vo.BuildingInfoVO;
import com.elf.vipForElf.domain.building.vo.BuildingListVO;
import com.elf.vipForElf.web.dto.NewBuildingDTO;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuildingServiceImpl implements BuildingService {

    private final BuildingRepository buildingRepository;

    public BuildingServiceImpl(BuildingRepository buildingRepository) {
        this.buildingRepository = buildingRepository;
    }

    @Override
    public BuildingInfoVO putBuilding(NewBuildingDTO newBuildingDTO) {
        BuildingInfoVO buildingInfoVO = new BuildingInfoVO(newBuildingDTO);
        return buildingRepository.create(buildingInfoVO);
    }

    @Override
    public Optional<BuildingInfoVO> getBuildingById(Long id) {
        if(buildingRepository.existsById(id)){
            return buildingRepository.getById(id);
        }
        return Optional.empty();
    }

    @Override
    public List<BuildingListVO> getBuildingList(String searchCondition, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        if (searchCondition.equals("")){
            return buildingRepository.findAll(pageable);
        }else {
            return buildingRepository.findBySearchCondition(searchCondition,pageable);
        }
    }

    @Override
    public String deleteBuildingById(Long id) {
        return buildingRepository.deleteBuildingById(id);
    }

    @Override
    public Boolean existById(Long id) {
        return buildingRepository.existsById(id);
    }

    @Override
    public BuildingEntity getBuildingEntityById(Long id) {
        return buildingRepository.getBuildingEntityById(id);
    }


}
