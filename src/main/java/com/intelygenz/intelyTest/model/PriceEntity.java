package com.intelygenz.intelyTest.model;

import com.intelygenz.intelyTest.dto.EffectiveDateRange;
import com.intelygenz.intelyTest.dto.ProductSummaryDTO;
import com.intelygenz.intelyTest.util.TimestampToLocalDateTimeConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Getter;

/**
 * Entity class representing the Brand preferences.
 *
 * @author Giordano Bortolini
 */
@Entity
@Getter
@Table(name = "PRICES")
public class PriceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "price_list", nullable = false)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private BrandEntity brand;

    @Convert(converter = TimestampToLocalDateTimeConverter.class)
    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Convert(converter = TimestampToLocalDateTimeConverter.class)
    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "priority")
    private int priority;

    @Column(name = "price")
    private Float price;

    @Column(name = "curr")
    private String currency;

    public ProductSummaryDTO toDTO() {
        ProductSummaryDTO productDetails = new ProductSummaryDTO();

        productDetails.setBrandId(this.brand.getId());
        productDetails.setProductId(this.product.getId());
        productDetails.setBrandName(this.brand.getName());
        productDetails.setPrice(this.price);
        productDetails.setEffectiveDateRange(new EffectiveDateRange(this.startDate, this.endDate));

        return productDetails;
    }
}
