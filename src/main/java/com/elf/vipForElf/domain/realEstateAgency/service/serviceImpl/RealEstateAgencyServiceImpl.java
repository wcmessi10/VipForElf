package com.elf.vipForElf.domain.realEstateAgency.service.serviceImpl;

import com.elf.vipForElf.domain.realEstateAgency.entity.RealEstateAgencyEntity;
import com.elf.vipForElf.domain.realEstateAgency.repository.RealEstateAgencyRepository;
import com.elf.vipForElf.domain.realEstateAgency.service.RealEstateAgencyService;
import com.elf.vipForElf.domain.realEstateAgency.vo.RealEstateAgency;
import com.elf.vipForElf.domain.realEstateAgency.vo.RealEstateAgencyRow;
import com.elf.vipForElf.domain.realEstateAgency.vo.RegistedEstateAgencyVO;
import com.elf.vipForElf.web.dto.NewRealEstateAgencyDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<RealEstateAgencyRow> getRealEstateAgencyList(String searchCondition, Pageable pageable) {
        return realEstateAgencyRepository.getRealEstateAgencyList(searchCondition,pageable);
    }

    @Override
    public Long getTotalCount() {
        return realEstateAgencyRepository.getTotalCount();
    }

    @Override
    public RealEstateAgency getRealEstateAgencyDetail(Long id) {
        RealEstateAgencyEntity realEstateAgencyEntity = realEstateAgencyRepository.getById(id);
        return new RealEstateAgency(realEstateAgencyEntity);
    }
}
