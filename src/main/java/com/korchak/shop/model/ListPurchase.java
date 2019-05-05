package com.korchak.shop.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListPurchase {

  private static Map<LocalDate, List<Purchase>> purchases = new HashMap<>();


  private ListPurchase() {
  }

  public static Map<LocalDate, List<Purchase>> getPurchases() {
    return purchases;
  }

  public static void setPurchases(Map<LocalDate, List<Purchase>> purchases) {
    ListPurchase.purchases = purchases;
  }

  public static void addPurchase(Purchase purchase){
    if(purchases.containsKey(purchase.getDate())){
      purchases.get(purchase.getDate()).add(purchase);

    } else {
      List<Purchase> newList = new ArrayList<>();
      newList.add(purchase);
      purchases.put(purchase.getDate(),newList);
    }
  }

  public static void deletePurchaseByDate(LocalDate date){
    purchases.remove(date);
  }




}
