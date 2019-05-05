package com.korchak.shop.config;

public class FixerConfig {

  private static String accessKey;


  public static String getAccessKey() {
    return accessKey;
  }

  public static void setAccessKey(String accessKey) {
    FixerConfig.accessKey = accessKey;
  }
}
