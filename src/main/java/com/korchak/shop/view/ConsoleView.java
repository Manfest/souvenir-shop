package com.korchak.shop.view;

import com.korchak.shop.model.Acronim;
import com.korchak.shop.model.ListPurchase;
import com.korchak.shop.model.Purchase;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map.Entry;


public class ConsoleView {

  public static void showListPurchases() {
    if(!ListPurchase.getPurchases().isEmpty()) {
      System.out.println();
      for (Entry<LocalDate, List<Purchase>> entry : ListPurchase.getPurchases().entrySet()) {

        System.out.println(entry.getKey());
        for (Purchase p : entry.getValue()) {
          System.out.println(p.toString());
        }
        System.out.println();
      }
    } else {
      showEmptySetWarning();
    }
  }

  private static void showEmptySetWarning() {
    System.out.println("empty set");
  }

  public static void showPurchaseWarning() {
    System.out.println("wrong purchase command");
  }

  public static void showInputWarning() {
    System.out.println("wrong input");
  }

  public static void showClearWarning() {
    System.out.println("wrong clear command");
  }

  public static void showReportWarning() {
    System.out.println("wrong report command");
  }



  public static void showReport(BigDecimal sum, Acronim acronim) {

    System.out.println("\n" + sum.toString() + " " + acronim.toString() + "\n");

  }

  public static void askUserForInput() {
    System.out.println("enter command:");
  }
}
