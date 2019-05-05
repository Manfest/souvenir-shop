package com.korchak.shop.model;

import org.junit.Assert;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class FixerRequestBuilderTest {

  @Test
  public void builderShouldReturnFixer(){
    assertEquals(Fixer.class, FixerRequestBuilder.getInstance()
        .createRequest()
        .setAccessKey("1234")
        .setLatestRates()
        .build().getClass());

  }


}
