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
 * Entity class representing the product.
 *
 * @author Giordano Bortolini
 */
@Entity
@Getter
@Table(name = "PRODUCT")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "product_id", nullable = false)
    private long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "product")
    private List<PriceEntity> priceDetails;
}
