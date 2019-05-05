package com.korchak.shop.model;

public class FixerRequestBuilder {

  private Fixer fixer;

  private FixerRequestBuilder() {
  }


  public static FixerRequestBuilder getInstance(){
    return new FixerRequestBuilder();
  }

  public FixerRequestBuilder createRequest() {
    fixer = new Fixer();
    return this;
  }


  public FixerRequestBuilder setLatestRates() {
    String url = "http://data.fixer.io/api/latest";
    fixer.setUrlString(url);
    return this;
  }

  public FixerRequestBuilder setAccessKey(String key) {
    fixer.setAccessKey(key);
    return this;
  }

  public Fixer build() {
    return fixer;
  }


}
