package com.intelygenz.intelyTest.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.intelygenz.intelyTest.dto.ProductSummaryDTO;
import com.intelygenz.intelyTest.service.BrandPriceService;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Giordano Bortolini
 */
@RestController
@RequestMapping(value = "product/pvp",
    produces = {APPLICATION_JSON_VALUE}, consumes = {APPLICATION_JSON_VALUE})
public class ProductController {

    private final BrandPriceService productService;

    @Autowired
    public ProductController(BrandPriceService productService) {
        this.productService = productService;
    }

    @PostMapping(value = "/summary")
    public ResponseEntity<String> getProductDetails(@RequestBody ProductSummaryDTO filter) {
        return ResponseEntity.ok(productService.getHigherPriorityProductPriceDetails(filter));
    }

    @GetMapping(value = "/price")
    public ResponseEntity<Float> getProductDetails(
        @RequestParam("brand_id") long brandId,
        @RequestParam("product_id") long productId,
        @RequestParam("effective_date") @DateTimeFormat(pattern = "yyyy-MM-dd-HH.mm.ss") LocalDateTime effectiveDate) {
        return ResponseEntity.ok(productService.getBrandPrice(brandId, productId, effectiveDate));
    }

}
