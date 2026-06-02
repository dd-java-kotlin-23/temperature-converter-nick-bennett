package edu.cnm.deepdive;

public class Converter {

  private static final double CELSIUS_TO_FAHRENHEIT_SCALE = 1.8;
  private static final int FAHRENHEIT_OFFSET_FROM_CELSIUS = 32;

  public double convertC2F(double celsius) {
    return CELSIUS_TO_FAHRENHEIT_SCALE * celsius + FAHRENHEIT_OFFSET_FROM_CELSIUS;
  }

  public double convertF2C(double fahrenheit) {
    return (fahrenheit - FAHRENHEIT_OFFSET_FROM_CELSIUS) / CELSIUS_TO_FAHRENHEIT_SCALE;
  }

}
