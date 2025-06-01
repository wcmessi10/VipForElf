package com.elf.vipForElf.domain.realEstateAgency.entity;

import com.elf.vipForElf.web.dto.NewRealEstateAgencyDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Entity
@Table(name = "elf_t_real_estate_agency")
@Getter
@Setter
@NoArgsConstructor
public class RealEstateAgencyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "real_estate_agency_name", nullable = false)
    private String realEstateAgencyName;

    @Column(name = "regist_dt")
    private OffsetDateTime registDt;

    @Column(name = "contact", nullable = false)
    private String contact;

    @Column(name = "description")
    private String description;

    public RealEstateAgencyEntity(NewRealEstateAgencyDTO newRealEstateAgencyDTO){
        this.realEstateAgencyName = newRealEstateAgencyDTO.getRealEstateAgencyName();
        this.contact = newRealEstateAgencyDTO.getContact();
        this.description = newRealEstateAgencyDTO.getDescription();
    }
}
