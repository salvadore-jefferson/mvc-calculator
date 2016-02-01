/*
 * Copyright © 2016 Salvadore Jefferson
 */
package com.jefferson.salvadore.mvc_calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The <code>CalcController</code> class receives data from the {@link CalcView} class, and passes
 * instructions to the {@link CalcModel} class, to perform the appropriate calculations for the
 * {@link MVCCalculator} application
 * 
 * @author Salvadore Jefferson
 * @version 1.0.0 1-31-2016
 *
 */
public class CalcController {

  static final Logger logger = LoggerFactory.getLogger(CalcController.class);

  private String command;

  private CalcView theView;
  private CalcModel theModel;

  /**
   * Constructs a new instance of CalcControler to be used in performing user calculations.
   * 
   * @param theView
   * @param theModel
   * 
   * @see CalcView
   * @see CalcModel
   */
  public CalcController(final CalcView theView, final CalcModel theModel) {
    this.theView = theView;
    this.theModel = theModel;

    this.theView.addCalculateListener(new CalculateListener());

  }

  /**
   * Performs the current calculation based on the user input through the GUI
   * 
   * @return result This is used for unit testing
   */
  public Double performCalculation() {
    Double result = 0.0;
    Double first = Double.parseDouble(theView.getFirstOperand());
    Double second = Double.parseDouble(theView.getSecondOperand());

    command = theView.getCommand();

    theModel.setOperands(first, second);

    switch (command) {

      case "*":
        result = theModel.calculationMultiply();
        break;

      case "+":
        result = theModel.calculationAdd();
        break;

      case "/":
        result = theModel.calculationDivide();
        break;

      case "-":
        result = theModel.calculationSubtract();
        break;
    }

    theView.setSolution(Double.toString(result));
    theView.start = true;
    logger.debug("Called? {}", theView.start);
    return result;
  }

  private class CalculateListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      performCalculation();
      logger.debug("Called? {}", command);

    }

  }
}
