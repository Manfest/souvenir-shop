package com.korchak.shop;

import com.korchak.shop.config.FixerConfig;
import com.korchak.shop.controller.InputController;
import com.korchak.shop.model.Fixer;
import com.korchak.shop.model.FixerRequestBuilder;

public class Director {
  private static String accessKey = "d935a8a4b7d002caf7fc098926e7af96";

  private Director() {
  }

  public static void runApp(){
    FixerConfig.setAccessKey(accessKey);
    InputController.scan();

  }


}
