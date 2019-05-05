package com.korchak.shop.controller;

import com.korchak.shop.model.Acronim;
import com.korchak.shop.model.ListPurchase;
import com.korchak.shop.model.Purchase;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class PurchaseController {



  static Map<LocalDate, List<Purchase>> getPurchases() {
    return ListPurchase.getPurchases();
  }


  static void addPurchase(Purchase purchase){
    ListPurchase.addPurchase(purchase);
  }

  static void deletePurchase(LocalDate date){
    ListPurchase.deletePurchaseByDate(date);
  }

  static BigDecimal getReportCurrency(Integer year, Acronim currency) throws Exception{

    BigDecimal sum = new BigDecimal("0");

    if(!ListPurchase.getPurchases().isEmpty()) {

      sum = CurrencyController.getCurrencySum(year, currency);

      return sum;
    }else {
      return sum;
    }
  }


}
