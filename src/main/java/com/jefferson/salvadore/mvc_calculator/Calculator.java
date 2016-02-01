/*
 * Copyright © 2016 Salvadore Jefferson
 */
package com.jefferson.salvadore.mvc_calculator;

import java.awt.EventQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The main entry point of the Calculator application
 * 
 * @author Salvadore Jefferson
 * @version 1.0.0 1-31-2016
 */
public class Calculator {

  public static void main(String[] args) {

    final Logger rootLogger = LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
    ((ch.qos.logback.classic.Logger) rootLogger).setLevel(ch.qos.logback.classic.Level.DEBUG);

    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        CalcView theView = new CalcView();
        CalcModel theModel = new CalcModel();
        CalcController controller = new CalcController(theView, theModel);
        theView.setVisible(true);
      }
    });
  }
}
