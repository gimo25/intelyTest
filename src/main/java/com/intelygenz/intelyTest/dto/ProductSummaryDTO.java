package com.intelygenz.intelyTest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.intelygenz.intelyTest.util.LocalDateTimeDeserializer;
import com.intelygenz.intelyTest.util.LocalDateTimeSerializer;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO class used to hold relevant product details.
 * We can use this class in the future to maintain the PRICES data.
 * @author Giordano Bortolini
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductSummaryDTO {

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonProperty("effective_date")
    private LocalDateTime effectiveDate;

    @JsonProperty("product_id")
    private long productId;

    @JsonProperty("brand_id")
    private long brandId;

    @JsonProperty(access = Access.READ_ONLY)
    private String brandName;

    @JsonProperty(access = Access.READ_ONLY)
    private float price;

    @JsonProperty(access = Access.READ_ONLY)
    private EffectiveDateRange effectiveDateRange;
}
