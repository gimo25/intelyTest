package com.intelygenz.intelyTest.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import com.intelygenz.intelyTest.repository.IPriceRepository;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Integration testing to test product information and brand price retrieval.
 *
 * @author Giordano Bortolini
 */
@SpringBootTest
@AutoConfigureMockMvc
@Sql(value = {"/data.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_CLASS)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class BrandPriceIntegrationTest {

  @Autowired
  private IPriceRepository productRepository;

  @Autowired
  private MockMvc mockMvc;

  private static final String JSON_REQUEST_BODY =
      "{ \"effective_date\": \"%s\", \"product_id\": %s, \"brand_id\": %s }";
  private static final String BRAND_ID = "1";
  private static final String PRODUCT_ID = "35455";

  @Test
  void it_should_return_brand_details_for_date_test_1() throws Exception {
    final String expectedResponse =
        "Peticion a las 10:00 del dia 14 del producto No. 35455 para la brand 1 (ZARA)";

    runTest("2020-06-14-10.00.00", expectedResponse, 35.5);
  }

  @Test
  void it_should_return_brand_details_for_date_test_2() throws Exception {

    final String expectedResponse =
        "Peticion a las 16:00 del dia 14 del producto No. 35455 para la brand 1 (ZARA)";

    runTest("2020-06-14-16.00.00", expectedResponse, 25.45);
  }

  @Test
  void it_should_return_brand_details_for_date_test_3() throws Exception {

    final String expectedResponse =
        "Peticion a las 21:00 del dia 14 del producto No. 35455 para la brand 1 (ZARA)";

    runTest("2020-06-14-21.00.00", expectedResponse, 35.5);
  }

  @Test
  void it_should_return_brand_details_for_date_test_4() throws Exception {

    final String expectedResponse =
        "Peticion a las 10:00 del dia 15 del producto No. 35455 para la brand 1 (ZARA)";

    runTest("2020-06-15-10.00.00", expectedResponse, 30.5);
  }

  @Test
  void it_should_return_brand_details_for_date_test_5() throws Exception {

    final String expectedResponse =
        "Peticion a las 21:00 del dia 16 del producto No. 35455 para la brand 1 (ZARA)";

    runTest("2020-06-16-21.00.00", expectedResponse, 38.95);
  }

  private void runTest(
      String effectiveDate, String expectedMessage, double expectedPrice) throws Exception {

    this.mockMvc.perform(post("/product/pvp/summary")
            .contentType(MediaType.APPLICATION_JSON)
            .content(String.format(JSON_REQUEST_BODY, effectiveDate, PRODUCT_ID, BRAND_ID)))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$").isString())
        .andExpect(jsonPath("$").value(expectedMessage));

    this.mockMvc.perform(get("/product/pvp/price")
            .param("brand_id", BRAND_ID)
            .param("product_id", PRODUCT_ID)
            .param("effective_date", effectiveDate)
            .contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$").value(expectedPrice));
  }
}
