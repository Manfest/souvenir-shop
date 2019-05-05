package com.korchak.shop.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ListPurchaseTest {


  @Test
  public void addMethodTest() {

    ListPurchase.addPurchase(new Purchase(LocalDate.parse("2019-04-04"),
        new BigDecimal("3"), Acronim.UAH, "Sweets"));

    assertEquals(1, ListPurchase.getPurchases().size());
  }

  @Test
  public void deleteMethodTest(){
    ListPurchase.deletePurchaseByDate(LocalDate.parse("2019-04-04"));
    assertEquals(0, ListPurchase.getPurchases().size());
  }





}
