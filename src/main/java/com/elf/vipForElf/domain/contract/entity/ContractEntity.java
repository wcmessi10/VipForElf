package com.elf.vipForElf.domain.contract.entity;

import com.elf.vipForElf.domain.realEstateAgency.entity.RealEstateAgencyEntity;
import com.elf.vipForElf.domain.realEstateListing.entity.RealEstateListingEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.OffsetDateTime;

@Entity
@Data
@Table(name = "elf_t_contract")
public class ContractEntity {
    @Id
    @Column(name = "contract_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contractId;

    @ManyToOne
    @JoinColumn(name = "real_estate_agency_id", nullable = false)
    private RealEstateAgencyEntity realEstateAgencyEntity;

    @Column(name = "land_lord_id")
    private String landLordId;

    @ManyToOne
    @JoinColumn(name = "real_estate_listing_id")
    private RealEstateListingEntity realEstateListingEntity;

    @Column(name = "contract_pdf_link")
    private String contractPdfLink;

    @Enumerated(EnumType.STRING)
    @Column(name = "contract_status")
    private ContractStatus contractStatus;

    @Column(name = "regist_dt")
    private OffsetDateTime registDt = OffsetDateTime.now();

    @Column(name = "last_update_dt")
    private OffsetDateTime lastUpdateDt;

    @Column(name = "move_in_dt")
    private OffsetDateTime moveInDt;

    public enum ContractStatus{
        APPLY_FOR_CONTRACT,
        REVIEWED_BY_LANDLORD,
        REJECT_BY_LANDLORD,
        REJECT_BY_TENANT,
        SUBMIT_CONTRACT
    }
}
