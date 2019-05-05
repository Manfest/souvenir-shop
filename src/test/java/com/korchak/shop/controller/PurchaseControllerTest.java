package com.korchak.shop.controller;

import static org.junit.jupiter.api.Assertions.*;

import com.korchak.shop.model.Acronim;
import com.korchak.shop.model.Purchase;
import com.korchak.shop.view.ConsoleView;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;


public class PurchaseControllerTest {

  private static Purchase purchase;

  @BeforeAll
  static void init() {
    purchase = new Purchase(LocalDate.parse("2019-03-03"), new BigDecimal("2.5"),
        Acronim.UAH, "Sweets");

  }

  @Test
  public void testAddCommand() {

    PurchaseController.addPurchase(new Purchase(LocalDate.parse("2019-03-04"),
        new BigDecimal("5"), Acronim.USD, "Juice"));
    assertEquals(1, PurchaseController.getPurchases().size());


  }

  @Test
  public void testDeleteCommand() {

    PurchaseController.addPurchase(purchase);
    PurchaseController.deletePurchase(LocalDate.parse("2019-03-03"));
    assertEquals(0, PurchaseController.getPurchases().size());


  }

  @Test
  public void testReportCommand() {

    BigDecimal expected = new BigDecimal("0");
    try {
      assertEquals(expected, PurchaseController.getReportCurrency(2019, Acronim.USD));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
