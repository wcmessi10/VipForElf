package com.elf.vipForElf.domain.realEstateAgency.service.serviceImpl;

import com.elf.vipForElf.domain.realEstateAgency.entity.RealEstateAgencyEntity;
import com.elf.vipForElf.domain.realEstateAgency.repository.RealEstateAgencyRepository;
import com.elf.vipForElf.domain.realEstateAgency.service.RealEstateAgencyService;
import com.elf.vipForElf.domain.realEstateAgency.vo.RegistedEstateAgencyVO;
import com.elf.vipForElf.web.dto.NewRealEstateAgencyDTO;
import org.springframework.stereotype.Service;

@Service
public class RealEstateAgencyServiceImpl implements RealEstateAgencyService {

    private final RealEstateAgencyRepository realEstateAgencyRepository;

    public RealEstateAgencyServiceImpl(RealEstateAgencyRepository realEstateAgencyRepository) {
        this.realEstateAgencyRepository = realEstateAgencyRepository;
    }

    @Override
    public RegistedEstateAgencyVO registerNew(NewRealEstateAgencyDTO newRealEstateAgencyDTO) {
        RealEstateAgencyEntity newEntity = new RealEstateAgencyEntity(newRealEstateAgencyDTO);
        RegistedEstateAgencyVO successRegistVO = new RegistedEstateAgencyVO(realEstateAgencyRepository.save(newEntity));
        return successRegistVO;
    }
}
