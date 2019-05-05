package com.korchak.shop.controller;

import com.korchak.shop.config.FixerConfig;
import com.korchak.shop.model.Acronim;
import com.korchak.shop.model.Fixer;
import java.math.BigDecimal;
import org.json.JSONObject;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Rule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

public class CurrencyControllerTest {

  private String accessKey = "d935a8a4b7d002caf7fc098926e7af96";

  @BeforeEach
  public void init() {
    FixerConfig.setAccessKey(accessKey);
  }

  @Test
  public void shouldReturnFixer() {
    assertEquals(Fixer.class, CurrencyController.createRequestFor(accessKey).getClass());
    System.out.println("createRequest method tested");
  }

  @Rule
  ExpectedException exception = ExpectedException.none();
  @Test
  public void shouldReturnJSONObject() {

    try {
      assertEquals(JSONObject.class, CurrencyController.getRates().getClass());
      FixerConfig.setAccessKey("123");
      exception.expect(Exception.class);
      CurrencyController.getRates();

    } catch (Exception e){
      e.printStackTrace();
    }

    System.out.println("getRates method tested");

  }


  @Test
  public void testExchangeCurrency() {

    BigDecimal price = new BigDecimal("5");
    BigDecimal expected = new BigDecimal("50");
    assertEquals(expected,
        CurrencyController.exchangeCurrency("2","20", price) );

    System.out.println("exchangeCurrency method tested");
  }

  @Test
  public void shouldReturnBigDecimal(){
    try {
      assertEquals(BigDecimal.class,
          CurrencyController.getCurrencySum(2019, Acronim.UAH).getClass());
    }catch (Exception e){
      e.printStackTrace();
    }
    System.out.println("getCurrencySum method tested");

  }




}
