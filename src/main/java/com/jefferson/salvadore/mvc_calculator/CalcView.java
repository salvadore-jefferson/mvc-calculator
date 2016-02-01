/*
 * Copyright © 2016 Salvadore Jefferson
 */
package com.jefferson.salvadore.mvc_calculator;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The <code>CalcView</code> class is the user interface of the {@link MVCCalculator} application.
 * The <code>CalcView</code> sends the commands the user enters to the {@link CalcController} class,
 * to be passed along to the {@link CalcModel} class.
 * 
 * @author Salvadore Jefferson
 * @version 1.0.0 1-31-2016
 *
 */
public class CalcView extends JFrame {

  static final Logger logger = LoggerFactory.getLogger(CalcView.class);

  private static final long serialVersionUID = 1L;

  public boolean start = true;

  private String firstOperand;
  private String secondOperand;
  private String command;

  private JPanel guiDisplay;
  private JButton display;
  private JButton calculate;

  /**
   * Creates an instance of {@link CalcView} and calls the {@link CalcView#buildGUI()} to setup the
   * user interface.
   */
  public CalcView() {
    buildGUI();
  }

  /**
   * Builds the graphical user interface of the {@link Calculator} application.
   */
  private void buildGUI() {

    guiDisplay = new JPanel();
    display = new JButton();
    calculate = new JButton("=");

    guiDisplay.setLayout(new GridLayout(4, 3));
    addButton("7", new Operand());
    addButton("8", new Operand());
    addButton("9", new Operand());
    addButton("*", new Command());

    addButton("4", new Operand());
    addButton("5", new Operand());
    addButton("6", new Operand());
    addButton("/", new Command());

    addButton("3", new Operand());
    addButton("2", new Operand());
    addButton("1", new Operand());
    addButton("-", new Command());

    addButton("0", new Operand());
    addButton(".", new Operand());
    addButton("AC", new Command());
    addButton("+", new Command());

    this.setTitle("MVC-Calculator");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.add(display, BorderLayout.NORTH);
    this.add(guiDisplay, BorderLayout.CENTER);
    this.add(calculate, BorderLayout.SOUTH);

    this.setSize(200, 250);
    this.setLocationRelativeTo(null);
    this.setResizable(false);

  }

  /**
   * Get the value held in the {@link #firstOperand} variable.
   * 
   * @return String The value of the first operand entered
   */
  public String getFirstOperand() {
    return firstOperand;
  }

  /**
   * Get the value held in the {@link #secondOperand} variable.
   * 
   * @return String The value of the second operand entered
   */
  public String getSecondOperand() {
    return secondOperand;
  }

  /**
   * Get the command for this calculation.
   * 
   * @return String The operation to perform on this calculation
   */
  public String getCommand() {
    return command;
  }

  /**
   * When the {@link #calculate} button is clicked, the{@link CalcController} will execute the
   * calculation.
   * 
   * @param listenForCalc
   */
  public void addCalculateListener(ActionListener listenForCalc) {
    calculate.addActionListener(listenForCalc);
    logger.debug("calculate() called");
  }

  /**
   * Adds a new button to the interface.
   * 
   * @param buttonValue The value the button holds
   * @param listener The ActionListener for the button
   */
  private void addButton(final String buttonValue, final ActionListener listener) {
    final JButton button = new JButton(buttonValue);
    button.addActionListener(listener);
    guiDisplay.add(button);
  }

  /**
   * Retrieves the solution of the calculation from the{@link CalcController}class and adds it to
   * the display of the UI.
   * 
   * @param solution The calculated solution
   */
  public void setSolution(final String solution) {
    display.setText("" + solution);
  }

  /**
   * A utility method for setting the operands for calculations in unit tests
   * 
   * @param firstOperand
   * @param secondOperand
   */
  public void setOperands(final String firstOperand, final String secondOperand) {
    this.firstOperand = firstOperand;
    this.secondOperand = secondOperand;
  }

  /**
   * A utility method for setting the command operator, (used for unit tests)
   * 
   * @param command The string value of the operator
   */
  public void setCommand(final String command) {
    this.command = command;
  }

  /**
   * Records the data entered to the UI and stores the values in one of the {@link #firstOperand} or
   * {@link #secondOperand} variables.
   * 
   * @author Salvadore Jefferson
   * @version 1.0.0 1-31-1016
   *
   */
  private class Operand implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

      if (start) {

        firstOperand = e.getActionCommand();
        display.setText(display.getText() + e.getActionCommand());
        firstOperand = display.getText();

        logger.debug("firstOperand {} ", firstOperand);

      } else {

        secondOperand = e.getActionCommand();
        display.setText(display.getText() + e.getActionCommand());
        secondOperand = display.getText();

        logger.debug("secondOperand {} ", secondOperand);
      }
    }
  }

  /**
   * Records the operation entered to the UI and stores the value in the {@link #command} variable.
   * 
   * @author Salvadore Jefferson
   * @version 1.0.0 1-31-1016
   *
   */
  private class Command implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      display.setText("");
      command = e.getActionCommand();

      if (command.equals("AC")) {
        display.setText("");
        start = true;
      } else {
        start = false;
        logger.debug("calculation type {}", command);
      }
    }

  }

}
