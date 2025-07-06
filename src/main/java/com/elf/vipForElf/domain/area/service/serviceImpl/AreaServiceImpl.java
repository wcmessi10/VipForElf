package com.elf.vipForElf.domain.area.service.serviceImpl;

import com.elf.vipForElf.domain.area.vo.AreaInfoVO;
import com.elf.vipForElf.domain.area.vo.AreaListVO;
import com.elf.vipForElf.domain.floor.entity.FloorEntity;
import com.elf.vipForElf.domain.area.repository.AreaRepository;
import com.elf.vipForElf.domain.area.service.AreaService;
import com.elf.vipForElf.domain.floor.service.FloorService;
import com.elf.vipForElf.web.dto.MoveInAreaDTO;
import com.elf.vipForElf.web.dto.NewAreaDTO;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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
        if(!roomNumberCheck(newAreaDTO.getFloorId(), newAreaDTO.getRoomNumber())){
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
        return areaRepository.update(areaInfoVO);
    }

    @Override
    public AreaInfoVO findAreaById(Long id) {
        AreaInfoVO areaInfoVO = areaRepository.findById(id);
        return null;
    }

    @Override
    public List<AreaListVO> getAreaList(String searchCondition, int page, int size) {
        Pageable pageable = PageRequest.of(page,size);
        if(searchCondition.isEmpty()){
            List<AreaListVO> areaListVOList = areaRepository.findAll(pageable);
            return areaListVOList;
        }else{
            List<AreaListVO> areaListVOList= areaRepository.findAreaBySearchCondition(searchCondition,pageable);
            return areaListVOList;
        }
    }

    @Override
    public List<AreaListVO> getAreaListByFloor(Long floorId) {
        return areaRepository.findByFloorId(floorId);
    }

    @Override
    public String deleteById(Long id) {
        if(areaRepository.deleteById(id)){
            return "Delete Complete";
        }else{
            throw new IllegalArgumentException("Wrong Area id");
        }
    }

    private Boolean roomNumberCheck(Long floorId, String roomNumber){
        return areaRepository.existsRoomNumber(floorId,roomNumber);
    }
}
