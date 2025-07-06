package com.elf.vipForElf.domain.realEstateListing.entity;

import com.elf.vipForElf.domain.realEstateAgency.entity.RealEstateAgencyEntity;
import com.elf.vipForElf.web.dto.NewRealEstateListingDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Table(name = "elf_t_real_estate_listing")
@Getter
@Setter
@NoArgsConstructor
public class RealEstateListingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(name = "listing_type",nullable = false)
    public String listingType;
    @Column(name = "listing_id", nullable = false)
    public Long listingId; // 매물의 id(건물 id or 공간 id)

    @Column(name="listing_name",nullable = false)
    public String listingName;

    @Enumerated(EnumType.STRING)
    @Column(name = "occupancy_type")
    public OccupancyType occupancyType;

    @Column(name = "sale_price",precision = 15, scale = 2)
    public BigDecimal salePrice = BigDecimal.ZERO;     // OFFICE_SALE 전용

    @Column(name = "deposit", precision = 15, scale = 2)
    public BigDecimal deposit = BigDecimal.ZERO;       // COMMERCIAL_LEASE 전용

    @Column(name = "monthly_rent", precision = 15, scale = 2)
    public BigDecimal monthlyRent = BigDecimal.ZERO;   // COMMERCIAL_LEASE, SHARED_OFFICE 공통

    @Column(name = "status")
    public String status;

    @Column(name = "regist_dt")
    public OffsetDateTime regist_dt;

    @ManyToOne
    @JoinColumn(name = "real_estate_agency_id", nullable = false)
    public RealEstateAgencyEntity realEstateAgencyEntity;

    public enum OccupancyType{
        COMMERCIAL_LEASE,   // 임대차 계약 (보증금 + 월세)
        SHARED_OFFICE,      // 공유 오피스 (월 단위 요금제)
        OFFICE_SALE         // 사무실 분양 (매매)
    }

    public RealEstateListingEntity(NewRealEstateListingDTO newRealEstateListingDTO, RealEstateAgencyEntity realEstateAgency) throws IllegalAccessException {
        this.listingId = newRealEstateListingDTO.getListingId();
        this.listingType = newRealEstateListingDTO.getListingType();
        this.listingName = newRealEstateListingDTO.getListingName();
        this.status = "Register";
        this.occupancyType = newRealEstateListingDTO.getOccupancyType();
        switch (newRealEstateListingDTO.getOccupancyType()){
            case OFFICE_SALE -> {
                this.salePrice = newRealEstateListingDTO.getSalePrice();
            }
            case SHARED_OFFICE -> {
                this.deposit = newRealEstateListingDTO.getDeposit();
                this.monthlyRent = newRealEstateListingDTO.getMonthlyRent();
            }
            case COMMERCIAL_LEASE -> {
                this.deposit = newRealEstateListingDTO.getDeposit();
            }
            case null, default -> {
                throw new IllegalAccessException("입주 타입을 고르시오");
            }
        }
        this.regist_dt = OffsetDateTime.now();
        this.realEstateAgencyEntity = realEstateAgency;
    }
}