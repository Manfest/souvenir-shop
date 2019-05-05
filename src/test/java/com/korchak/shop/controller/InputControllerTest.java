package com.korchak.shop.controller;

import com.korchak.shop.config.FixerConfig;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
public class InputControllerTest {
  private static String accessKey = "d935a8a4b7d002caf7fc098926e7af96";

  @BeforeAll
  public static void init(){
    FixerConfig.setAccessKey(accessKey);
  }

  @Test
  public void testScan(){

    System.setIn(new ByteArrayInputStream(("purchase 2019-03-03 2.5 USD Candy\n"
        + "all\n"
        + "report 2019 UAH\n"
        + "clear 2019-03-03\n"
        + "all\n"
        + "clear\n"
        + "report 2019\n"
        + "purchase 2019\n"
        + "delete\n"
        + "exit").getBytes()));

    PowerMockito.spy(InputController.class);
    PowerMockito.doNothing().when(InputController.class);

    InputController.scan();

    System.setIn(System.in);


  }

}
