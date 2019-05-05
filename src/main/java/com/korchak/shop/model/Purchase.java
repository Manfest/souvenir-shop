package com.korchak.shop.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Purchase {

  private LocalDate date;
  private BigDecimal price;
  private Acronim acronim;
  private String productName;

  public Purchase(LocalDate date, BigDecimal price, Acronim acronim, String productName) {
    this.date = date;
    this.price = price;
    this.acronim = acronim;
    this.productName = productName;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public Acronim getAcronim() {
    return acronim;
  }

  public void setAcronim(Acronim acronim) {
    this.acronim = acronim;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public String toString(){
    return (this.getProductName()+ " " + this.getPrice().toString() + " " + this.getAcronim().toString());
  }
}
