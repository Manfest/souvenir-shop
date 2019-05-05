package com.korchak.shop.controller;

import com.korchak.shop.config.FixerConfig;
import com.korchak.shop.model.Acronim;
import com.korchak.shop.model.Fixer;
import com.korchak.shop.model.FixerRequestBuilder;
import com.korchak.shop.model.ListPurchase;
import com.korchak.shop.model.Purchase;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONObject;


public class CurrencyController {


   static JSONObject getRates() throws Exception {
    JSONObject object = null;
    StringBuilder builder = new StringBuilder();
    String input;
    Fixer fixer = CurrencyController
        .createRequestFor(FixerConfig.getAccessKey());
    URL url = new URL(fixer.toString());

    try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {


      while ((input = reader.readLine()) != null) {
        builder.append(input);
      }

      JSONObject jsonObject = new JSONObject(builder.toString());

      if(!jsonObject.isNull("rates")) {
        object = jsonObject.getJSONObject("rates");
      } else {
        System.out.println(jsonObject.toString());
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    return object;
  }


   static Fixer createRequestFor(String accessKey) {
    Fixer fixer = FixerRequestBuilder.getInstance()
        .createRequest()
        .setLatestRates()
        .setAccessKey(accessKey)
        .build();
    return fixer;
  }

   static BigDecimal getCurrencySum(Integer year, Acronim currency) throws Exception {

    BigDecimal sum = new BigDecimal("0");
    JSONObject rates = CurrencyController.getRates();

    Map<LocalDate, List<Purchase>> purchases = ListPurchase.getPurchases();
    for (Entry<LocalDate, List<Purchase>> entry : purchases.entrySet()) {
      if (entry.getKey().getYear() == year) {
        for (Purchase p : entry.getValue()) {
          sum = sum
              .add(exchangeCurrency(rates.get(p.getAcronim().toString()).toString(),
                  rates.get(currency.toString()).toString(), p.getPrice()));

        }
      }
    }

    return sum;
  }


   static BigDecimal exchangeCurrency(String currencyFrom,
      String currencyTo, BigDecimal price) {
    BigDecimal fromValue = new BigDecimal(currencyFrom);
    BigDecimal toValue = new BigDecimal(currencyTo);

    BigDecimal result = new BigDecimal("0");

    result = toValue.divide(fromValue,2,RoundingMode.HALF_UP);
    result = result.multiply(price);
    if (result.compareTo(new BigDecimal("0") )!= 0) {
      return result;
    } else {
      return result;
    }
  }


}
