package com.intelygenz.intelyTest.repository;

import com.intelygenz.intelyTest.model.PriceEntity;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * JPA repository for brand details.
 *
 * @author Giordano Bortolini
 */
@Repository
public interface IPriceRepository extends JpaRepository<PriceEntity, Long> {

  @Query("from PriceEntity p where p.brand.id = :brandId and p.product.id = :productId and startDate <= :effectiveDate and endDate >= :effectiveDate")
  List<PriceEntity> findPriceSummaryByFilter(
      long brandId, long productId, LocalDateTime effectiveDate);
}
