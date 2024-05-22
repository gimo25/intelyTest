package com.intelygenz.intelyTest.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Getter;

/**
 * Entity class representing the brand.
 *
 * @author Giordano Bortolini
 */
@Entity
@Getter
@Table(name = "BRAND")
public class BrandEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "brand_id", nullable = false)
    private long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "brand")
    private List<PriceEntity> priceDetails;
}
