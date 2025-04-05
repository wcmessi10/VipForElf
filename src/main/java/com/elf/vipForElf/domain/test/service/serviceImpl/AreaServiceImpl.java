package com.elf.vipForElf.domain.test.service.serviceImpl;

import com.elf.vipForElf.domain.test.entity.FloorEntity;
import com.elf.vipForElf.domain.test.repository.AreaRepository;
import com.elf.vipForElf.domain.test.service.AreaService;
import com.elf.vipForElf.domain.test.service.FloorService;
import com.elf.vipForElf.domain.test.vo.AreaInfoVO;
import com.elf.vipForElf.web.dto.MoveInAreaDTO;
import com.elf.vipForElf.web.dto.NewAreaDTO;
import org.springframework.stereotype.Service;

@Service
public class AreaServiceImpl implements AreaService {

    private final AreaRepository areaRepository;

    private final FloorService floorService;

    public AreaServiceImpl(AreaRepository areaRepository, FloorService floorService) {
        this.areaRepository = areaRepository;
        this.floorService = floorService;
    }

    @Override
    public AreaInfoVO createArea(NewAreaDTO newAreaDTO) {
        if(roomNumberCheck(newAreaDTO.getFloorId(), newAreaDTO.getRoomNumber())){
            FloorEntity floorEntity = floorService.getFloorEntityById(newAreaDTO.getFloorId());
            AreaInfoVO areaInfoVO = new AreaInfoVO(newAreaDTO,floorEntity);
            return areaRepository.createArea(areaInfoVO);
        }else{
            throw new IllegalArgumentException("이미 있는 Room Number");
        }
    }

    @Override
    public AreaInfoVO moveIn(MoveInAreaDTO moveInAreaDTO) {
        AreaInfoVO areaInfoVO = new AreaInfoVO(moveInAreaDTO);
        areaRepository.update(areaInfoVO);
        return null;
    }

    private Boolean roomNumberCheck(Long floorId, String roomNumber){
        return areaRepository.existsRoomNumber(floorId,roomNumber);
    }
}
