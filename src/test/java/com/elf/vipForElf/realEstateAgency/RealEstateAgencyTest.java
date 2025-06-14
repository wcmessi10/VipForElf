package com.elf.vipForElf.realEstateAgency;

import com.elf.vipForElf.domain.area.service.AreaService;
import com.elf.vipForElf.domain.area.vo.AreaInfoVO;
import com.elf.vipForElf.domain.building.service.BuildingService;
import com.elf.vipForElf.domain.building.vo.BuildingInfoVO;
import com.elf.vipForElf.domain.contract.service.ContractService;
import com.elf.vipForElf.domain.floor.service.FloorService;
import com.elf.vipForElf.domain.floor.vo.FloorInfoVO;
import com.elf.vipForElf.domain.realEstateAgency.service.RealEstateAgencyService;
import com.elf.vipForElf.domain.realEstateListing.entity.RealEstateListingEntity;
import com.elf.vipForElf.domain.realEstateListing.service.RealEstateListingService;
import com.elf.vipForElf.web.dto.*;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@SpringBootTest
@ActiveProfiles("test") // application-test.yml 사용
@Transactional
public class RealEstateAgencyTest {
    private static final Logger log = LoggerFactory.getLogger(RealEstateAgencyTest.class);
    @Autowired
    private ContractService contractService;

    @Autowired
    private RealEstateAgencyService realEstateAgencyService;

    @Autowired
    private RealEstateListingService realEstateListingService;

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

    public NewRealEstateListingDTO testRealEstateListing() throws IllegalAccessException {
        AreaInfoVO areaInfoVO = createTestArea();
        NewRealEstateListingDTO newRealEstateListingDTO = new NewRealEstateListingDTO();
        newRealEstateListingDTO.setListingType("Area");
        newRealEstateListingDTO.setListingId(areaInfoVO.getId());
        newRealEstateListingDTO.setListingName(areaInfoVO.getRoomNumber());
        newRealEstateListingDTO.setOccupancyType(RealEstateListingEntity.OccupancyType.OFFICE_SALE);
        newRealEstateListingDTO.setSalePrice(BigDecimal.valueOf(10000L));
        newRealEstateListingDTO.setRealEstateAgencyId(createRealEstateAgency());
        newRealEstateListingDTO.setStatus("Register");
        return newRealEstateListingDTO;
    }

    public RegistedRealEstateListingDTO createRealEstateListing(NewRealEstateListingDTO newRealEstateListingDTO) throws IllegalAccessException {
        return realEstateListingService.registRealEstateListing(newRealEstateListingDTO);
    }

    public Long createRealEstateAgency(){
        NewRealEstateAgencyDTO newRealEstateAgencyDTO = new NewRealEstateAgencyDTO("test부동산","010-1111-2222","test부동산이에요");
        return realEstateAgencyService.registerNew(newRealEstateAgencyDTO).getId();
    }
    public ContractIdDTO createTestContract() throws IllegalAccessException {
        NewRealEstateListingDTO newRealEstateListingDTO = testRealEstateListing();
        RegistedRealEstateListingDTO registedRealEstateListingDTO = createRealEstateListing(newRealEstateListingDTO);
        log.debug("test newContractDTO: {}, {}",registedRealEstateListingDTO.getListingId(),newRealEstateListingDTO.getRealEstateAgencyId() );
        NewContractDTO newContractDTO = new NewContractDTO(
                registedRealEstateListingDTO.getListingId(),
                newRealEstateListingDTO.getRealEstateAgencyId(),
                "testLandLord",
                OffsetDateTime.now().plusDays(30L)
        );
        String content = "test file content";
        MockMultipartFile multipartFile = new MockMultipartFile(
                "file",                      // parameter name
                "test.txt",                  // original file name
                "text/plain",                // content type
                content.getBytes()           // file content
        );
        Long contractId = contractService.newContract(newContractDTO,multipartFile).getContractId();
        return new ContractIdDTO(contractId);
    }

    @Test
    public void realEstateTenantOnboardingProcess() throws IllegalAccessException {
        ContractIdDTO contractIdDTO = createTestContract();
        contractService.submitContract(contractIdDTO);
    }


}
