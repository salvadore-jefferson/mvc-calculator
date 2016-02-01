/*
 * Copyright © 2016 Salvadore Jefferson
 */
package com.jefferson.salvadore.mvc_calculator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class MVCTest {
  @Test
  public void TestMVCCommunications() {
    final CalcView theView = new CalcView();
    final CalcModel theModel = new CalcModel();
    final CalcController controller = new CalcController(theView, theModel);

    theView.setOperands("10", "5");
    theView.setCommand("+");
    assertThat(controller.performCalculation(), is(15.0));

    theView.setCommand("-");
    assertThat(controller.performCalculation(), is(5.0));

    theView.setCommand("/");
    assertThat(controller.performCalculation(), is(2.0));

    theView.setCommand("*");
    assertThat(controller.performCalculation(), is(50.0));

  }

}
