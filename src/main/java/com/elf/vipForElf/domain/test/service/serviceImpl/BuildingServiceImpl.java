package com.elf.vipForElf.domain.test.service.serviceImpl;

import com.elf.vipForElf.domain.test.repository.BuildingRepository;
import com.elf.vipForElf.domain.test.service.BuildingService;
import com.elf.vipForElf.domain.test.vo.BuildingInfoVO;
import com.elf.vipForElf.web.dto.NewBuildingDTO;
import org.springframework.stereotype.Service;

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


}
