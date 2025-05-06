package com.elf.vipForElf.area;

import com.elf.vipForElf.domain.area.service.AreaService;
import com.elf.vipForElf.domain.area.vo.AreaInfoVO;
import com.elf.vipForElf.domain.building.service.BuildingService;
import com.elf.vipForElf.domain.building.vo.BuildingInfoVO;
import com.elf.vipForElf.domain.floor.service.FloorService;
import com.elf.vipForElf.domain.floor.vo.FloorInfoVO;
import com.elf.vipForElf.web.dto.MoveInAreaDTO;
import com.elf.vipForElf.web.dto.NewAreaDTO;
import com.elf.vipForElf.web.dto.NewBuildingDTO;
import com.elf.vipForElf.web.dto.NewFloorDTO;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test") // application-test.yml 사용
@Transactional
public class AreaTest {
    @Autowired
    private AreaService areaService;

    @Autowired
    private BuildingService buildingService;

    @Autowired
    private FloorService floorService;

    public AreaInfoVO createTestArea() throws IllegalAccessException {
        NewBuildingDTO newBuildingDTO = new NewBuildingDTO("분당수지 U-Tower","경기도 용인시 수지구 동천동","123-12A2","4D-2321","29127");
        BuildingInfoVO buildingInfoVO = buildingService.putBuilding(newBuildingDTO);
        NewFloorDTO newFloorDTO = new NewFloorDTO(3,"입주",buildingInfoVO.getId());
        FloorInfoVO floorInfoVO = floorService.createFloor(newFloorDTO);
        NewAreaDTO newAreaDTO = new NewAreaDTO("1002A","32X24mm^2",floorInfoVO.getId());
        return areaService.createArea(newAreaDTO);
    }
    @Test
    public void moveIn() throws IllegalAccessException {
        AreaInfoVO newAreaInfoVO = createTestArea();
        MoveInAreaDTO moveInAreaDTO =
                new MoveInAreaDTO(newAreaInfoVO.getId(), "베리워즈");
        AreaInfoVO moveAreaInfoVO = areaService.moveIn(moveInAreaDTO);
        assertNotNull(moveAreaInfoVO);
        assertEquals("베리워즈",moveAreaInfoVO.getOfficeName());
    }
}
