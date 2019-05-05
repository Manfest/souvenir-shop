package com.korchak.shop.view;

import com.korchak.shop.model.Acronim;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(ConsoleView.class)
public class ConsoleViewTest {

  @Test
  public void testView(){

    PowerMockito.spy(ConsoleView.class);
    PowerMockito.doNothing().when(ConsoleView.class);

    ConsoleView.showInputWarning();
    ConsoleView.showListPurchases();
    ConsoleView.showClearWarning();
    ConsoleView.askUserForInput();
    ConsoleView.showReportWarning();
    ConsoleView.showPurchaseWarning();
    ConsoleView.showReport(new BigDecimal("3.5"), Acronim.USD);


  }

}
