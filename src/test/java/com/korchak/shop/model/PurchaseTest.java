package com.korchak.shop.model;

import com.korchak.shop.model.Acronim;
import com.korchak.shop.model.Purchase;
import java.math.BigDecimal;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PurchaseTest {
  private static Purchase purchase;

  @BeforeAll
  public static void init(){

    purchase = new Purchase(LocalDate.parse("2019-03-03"), new BigDecimal("2.5"),
        Acronim.UAH, "Sweets");


  }


  @Test
  public void purchaseGettersAndSettersTest(){

    assertEquals("2019-03-03", purchase.getDate().toString());
    assertEquals(2.5, purchase.getPrice().doubleValue(), 0);
    assertEquals("UAH", purchase.getAcronim().toString());
    assertEquals("Sweets", purchase.getProductName());

    purchase.setDate(LocalDate.parse("2019-05-03"));
    purchase.setAcronim(Acronim.USD);
    purchase.setPrice(new BigDecimal("10.50"));
    purchase.setProductName("Juice");
    assertEquals("2019-05-03", purchase.getDate().toString());
    assertEquals(10.5, purchase.getPrice().doubleValue(), 0);
    assertEquals("USD", purchase.getAcronim().toString());
    assertEquals("Juice", purchase.getProductName());
  }

  @Test
  public void toStringShouldReturnPurchaseString(){
    assertEquals("Juice 10.50 USD", purchase.toString());
  }

}
