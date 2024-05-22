package com.intelygenz.intelyTest.service;

import com.intelygenz.intelyTest.dto.ProductSummaryDTO;
import java.time.LocalDateTime;

/**
 * Interface to be used as a port to have different calculations for brand price related stuff.
 *
 * @author Giordano Bortolini
 */
public interface IBrandPriceService {
    String getHigherPriorityProductPriceDetails(ProductSummaryDTO productDetails);

    float getBrandPrice(long brandId, long productId, LocalDateTime effectiveDate);
}
