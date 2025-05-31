package com.elf.vipForElf.domain.realEstateListing.entity;

import com.elf.vipForElf.domain.realEstateAgency.entity.RealEstateAgencyEntity;
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
    private Long id;
    @Column(name = "listing_type",nullable = false)
    private String listingType;
    @Column(name = "listing_id", nullable = false)
    private Long listingId;

    @Enumerated(EnumType.STRING)
    @Column(name = "occupancy_type")
    private OccupancyType occupancyType;

    @Column(name = "sale_price",precision = 15, scale = 2)
    private BigDecimal salePrice;     // OFFICE_SALE 전용

    @Column(name = "deposit", precision = 15, scale = 2)
    private BigDecimal deposit;       // COMMERCIAL_LEASE 전용

    @Column(name = "monthly_rent", precision = 15, scale = 2)
    private BigDecimal monthlyRent;   // COMMERCIAL_LEASE, SHARED_OFFICE 공통

    @Column(name = "status")
    private String status;

    @Column(name = "regist_dt")
    private OffsetDateTime regist_dt;

    @ManyToOne
    @JoinColumn(name = "real_estate_agency_id", nullable = false)
    private RealEstateAgencyEntity realEstateAgencyEntity;

    public enum OccupancyType{
        COMMERCIAL_LEASE,   // 임대차 계약 (보증금 + 월세)
        SHARED_OFFICE,      // 공유 오피스 (월 단위 요금제)
        OFFICE_SALE         // 사무실 분양 (매매)
    }
}