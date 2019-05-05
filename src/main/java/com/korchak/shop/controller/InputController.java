package com.korchak.shop.controller;

import com.korchak.shop.model.Acronim;
import com.korchak.shop.model.Purchase;
import com.korchak.shop.view.ConsoleView;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class InputController {

  private static Scanner scanner = new Scanner(System.in);


  public static void scan() {
    ConsoleView.askUserForInput();
    String inputLine;
    try {
      inputLine = scanner.nextLine();
      checkInputCommand(inputLine);
    } catch (Exception e) {
      e.printStackTrace();

    }


  }

  private static void checkInputCommand(String inputLine) {
    if (inputLine.length() != 0) {
      String[] commands = inputLine.split(" ");

      if (commands[0].equalsIgnoreCase("purchase")) {
        if (commands.length == 5) {
          checkPurchaseCommand(commands);
          scan();
        } else {
          ConsoleView.showInputWarning();
          scan();
        }
      } else if (commands[0].equalsIgnoreCase("all")) {
        if (commands.length == 1) {
          checkAllCommand();
          scan();
        } else {
          ConsoleView.showInputWarning();
          scan();
        }
      } else if (commands[0].equalsIgnoreCase("clear")) {
        if (commands.length == 2) {
          checkClearCommand(commands);
          scan();
        } else {
          ConsoleView.showInputWarning();
          scan();
        }

      } else if (commands[0].equalsIgnoreCase("report")) {
        if (commands.length == 3) {
          checkReportCommand(commands);
          scan();
        } else {
          ConsoleView.showInputWarning();
          scan();
        }

      } else if (commands[0].equalsIgnoreCase("exit")) {
        scanner.close();
      } else {
        ConsoleView.showInputWarning();
        scan();
      }

    } else {
      ConsoleView.showInputWarning();
      scan();
    }
  }

  private static void checkPurchaseCommand(String[] commands) {
    try {

      LocalDate localDate = LocalDate.parse(commands[1]);
      BigDecimal price = new BigDecimal(commands[2]);
      Acronim acronim = Acronim.valueOf(commands[3]);
      String productName = String.valueOf(commands[4]);
      Purchase purchase = new Purchase(localDate, price, acronim, productName);
      PurchaseController.addPurchase(purchase);
      ConsoleView.showListPurchases();
    } catch (Exception e) {
      ConsoleView.showPurchaseWarning();
    }

  }

  private static void checkAllCommand() {
    ConsoleView.showListPurchases();
  }

  private static void checkClearCommand(String[] command) {
    try {
      LocalDate date = LocalDate.parse(command[1]);
      PurchaseController.deletePurchase(date);
      ConsoleView.showListPurchases();
    } catch (Exception e) {
      ConsoleView.showClearWarning();
    }

  }

  private static void checkReportCommand(String[] commands) {
    try {
      Integer year = Integer.valueOf(commands[1]);
      Acronim acronim = Acronim.valueOf(commands[2]);

      ConsoleView.showReport(PurchaseController.getReportCurrency(year, acronim), acronim);
    } catch (Exception e) {
      ConsoleView.showReportWarning();
      e.printStackTrace();
    }
  }


}
