package com.elf.vipForElf.domain.test.service.serviceImpl;

import com.elf.vipForElf.domain.test.entity.BuildingEntity;
import com.elf.vipForElf.domain.test.entity.FloorEntity;
import com.elf.vipForElf.domain.test.repository.FloorRepository;
import com.elf.vipForElf.domain.test.service.BuildingService;
import com.elf.vipForElf.domain.test.service.FloorService;
import com.elf.vipForElf.domain.test.vo.BuildingInfoVO;
import com.elf.vipForElf.domain.test.vo.FloorInfoVO;
import com.elf.vipForElf.domain.test.vo.FloorListVO;
import com.elf.vipForElf.web.dto.NewFloorDTO;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FloorServiceImpl implements FloorService {
    private final FloorRepository floorRepository;
    private final BuildingService buildingService;
    public FloorServiceImpl(FloorRepository floorRepository, BuildingService buildingService) {
        this.floorRepository = floorRepository;
        this.buildingService = buildingService;
    }

    @Override
    public FloorInfoVO createFloor(NewFloorDTO newFloorDTO) throws IllegalAccessException {
        if(!buildingService.existById(newFloorDTO.getBuildingId())){
            throw new IllegalAccessException("Buidling Id is not exists");
        }
        BuildingInfoVO buildingInfoVO = buildingService.getBuildingById(newFloorDTO.getBuildingId()).get();
        BuildingEntity buildingEntity = buildingService.getBuildingEntityById(newFloorDTO.getBuildingId());
        FloorInfoVO floorInfoVO = new FloorInfoVO(newFloorDTO,buildingEntity);
        return floorRepository.createFloor(floorInfoVO);
    }

    @Override
    public FloorInfoVO getFloorById(Long id) {
        return floorRepository.getFloorById(id);
    }

    @Override
    public List<FloorListVO> getFloorList(String searchCondition, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page,size);
        if(searchCondition.equals("")){
            return floorRepository.findAll(pageable);
        }
        return floorRepository.findBySearchCondition(searchCondition,pageable);
    }

    @Override
    public FloorEntity getFloorEntityById(Long id) {
        return floorRepository.getFloorEntityById(id);
    }
}
