/*
 * Copyright © 2016 Salvadore Jefferson
 */
package com.jefferson.salvadore.mvc_calculator;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.annotation.Nonnull;


/**
 * The <code>CalcModel</code> class receives instructions from the {@link CalcController} class, and
 * performs the appropriate calculations for the {@link MVCCalculator} application
 * 
 * @author Salvadore Jefferson
 * @version 1.0.0 1-31-2016
 *
 */
public class CalcModel {

  /**
   * <code>firtsOperand</code> is the first value to be added to the current calculation cycle
   */
  private Double firstOperand;

  /**
   * <code>secondOperand</code> is the second value to be added to the current calculation cycle
   */
  private Double secondOperand;

  /**
   * <code>calcResult</code> is the the result of the last executed calculation cycle
   */
  private Double calcResult;

  /**
   * Sets the values for {@link firstOperand} and {@link secondOperand}
   * 
   * @param firstOperand
   * @param secondOperand
   * @throws NullPointerException if either parameter is <code>null</code>
   */
  public void setOperands(@Nonnull final Double firstOperand, @Nonnull final Double secondOperand)
      throws NullPointerException {
    this.firstOperand = checkNotNull(firstOperand);
    this.secondOperand = checkNotNull(secondOperand);
  }

  /**
   * Perform an addition operation on {@link firstOperand} and {@link secondOperand}
   * 
   * @return Double The result of this calculation
   */
  public @Nonnull Double calculationAdd() {
    return calcResult = (firstOperand + secondOperand);
  }

  /**
   * Perform a subtraction operation on {@link firstOperand} and {@link secondOperand}
   * 
   * @return Double The result of this calculation
   */
  public @Nonnull Double calculationSubtract() {
    return calcResult = (firstOperand - secondOperand);
  }

  /**
   * Perform a multiplication operation on {@link firstOperand} and {@link secondOperand}
   * 
   * @return Double The result of this calculation
   */
  public @Nonnull Double calculationMultiply() {
    return calcResult = (firstOperand * secondOperand);
  }

  /**
   * Perform a division operation on {@link firstOperand} and {@link secondOperand}
   * 
   * @return Double The result of this calculation
   */
  public @Nonnull Double calculationDivide() {
    return calcResult = (firstOperand / secondOperand);
  }

  /**
   * Returns the calculation result
   * 
   * @return calcResult
   */
  public @Nonnull Double getResult() {
    return calcResult;
  }
}
