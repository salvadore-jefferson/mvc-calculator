/*
 * Copyright © 2016 Salvadore Jefferson
 */
package com.jefferson.salvadore.mvc_calculator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class CalcModelTest {

  @Test
  public void testSetOperandsAndCalculationMethods() {

    CalcModel model = new CalcModel();
    model.setOperands(10.0, 5.0);

    assertThat(model.calculationAdd(), is(15.0));

  }

  @Test
  public void testGetResultMethod() {

    CalcModel model = new CalcModel();
    model.setOperands(10.0, 5.0);

    model.calculationAdd();
    assertThat(model.getResult(), is(15.0));

    model.calculationDivide();
    assertThat(model.getResult(), is(2.0));

    model.calculationSubtract();
    assertThat(model.getResult(), is(5.0));

    model.calculationMultiply();
    assertThat(model.getResult(), is(50.0));

  }
}
