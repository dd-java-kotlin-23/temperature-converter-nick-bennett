package edu.cnm.deepdive;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class ConverterTest {

  private static final double TOLERANCE = 0.000001;

  @Test
  void convertC2F() {
    Converter converter = new Converter();
    double celsiusFreezingPoint = 0;
    double fahrenheitFreezingPoint = 32;
    double actual = converter.convertC2F(celsiusFreezingPoint);
    assertEquals(fahrenheitFreezingPoint, actual, TOLERANCE);
    // TODO Figure out how to test multiple inputs & actual outputs vs. expected outputs, without writing a lot of code.
  }

  @Disabled
  @Test
  void convertF2C() {
    fail("Test not implemented."); // FIXME Implement this test.
  }

}