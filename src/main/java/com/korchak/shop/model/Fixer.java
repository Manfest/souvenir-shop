package com.korchak.shop.model;

import java.net.URL;
import java.util.List;

public class Fixer {

  private String urlString;
  private String accessKey;


  public Fixer() {
  }


  public String getUrlString() {
    return urlString;
  }

  public void setUrlString(String urlString) {
    this.urlString = urlString;
  }

  public String getAccessKey() {
    return accessKey;
  }

  public void setAccessKey(String accessKey) {
    this.accessKey = accessKey;
  }


  public String toString() {
    return (getUrlString() + "?access_key=" + getAccessKey());
  }

}
