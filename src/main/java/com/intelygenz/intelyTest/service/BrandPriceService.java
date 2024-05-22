package com.intelygenz.intelyTest.service;

import com.intelygenz.intelyTest.dto.ProductSummaryDTO;
import com.intelygenz.intelyTest.model.PriceEntity;
import com.intelygenz.intelyTest.repository.IPriceRepository;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class for brand price related stuff.
 *
 * @author Giordano Bortolini
 */
@Service
public class BrandPriceService implements IBrandPriceService {

  private static final String MESSAGE = "Peticion a las %s del dia %s del producto No. %s para la brand %s (%s)";
  private final IPriceRepository priceRepository;

  @Autowired
  public BrandPriceService(IPriceRepository brandRepository) {
    this.priceRepository = brandRepository;
  }

  @Override
  public String getHigherPriorityProductPriceDetails(ProductSummaryDTO productDetails) {

    ProductSummaryDTO summary = getProductSummary(productDetails.getBrandId(),
        productDetails.getProductId(), productDetails.getEffectiveDate());

    LocalDateTime effectiveDate = productDetails.getEffectiveDate();

    return String.format(MESSAGE, effectiveDate.toLocalTime().toString(),
        effectiveDate.getDayOfMonth(), summary.getProductId(), summary.getBrandId(),
        summary.getBrandName());
  }

  @Override
  public float getBrandPrice(long brandId, long productId, LocalDateTime effectiveDate) {

    ProductSummaryDTO brandPrice = getProductSummary(brandId, productId, effectiveDate);

    return brandPrice.getPrice();
  }

  private ProductSummaryDTO getProductSummary(
      long brandId, long productId, LocalDateTime effectiveDate) {

    List<PriceEntity> prices = priceRepository.findPriceSummaryByFilter(
        brandId, productId, effectiveDate);

    return prices.stream().max(Comparator.comparingInt(PriceEntity::getPriority))
        .map(PriceEntity::toDTO).orElse(new ProductSummaryDTO());
  }
}
