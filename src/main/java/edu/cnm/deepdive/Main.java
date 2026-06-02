package edu.cnm.deepdive;

import java.util.Scanner;

public class Main {

  void main(String[] args) {
    // DONE: 6/2/26 Set initial conversion mode to Celsius-to-Fahrenheit.
    Mode mode = Mode.CELSIUS_TO_FAHRENHEIT;
    Converter converter = new Converter();
    // DONE: 6/2/26 Start reading from standard input.
    Scanner scanner = new Scanner(System.in);
    // TODO: 6/2/26 While there is any input remaining to process:
    while (scanner.hasNext()) {
      if (scanner.hasNextDouble()) {
        double input = scanner.nextDouble();
        double output;
        if (mode == Mode.CELSIUS_TO_FAHRENHEIT) {
          output = converter.convertC2F(input);
        } else {
          output = converter.convertF2C(input);
        }
        // TODO: 6/2/26 Print conversion mode, input, output.
        System.out.println("input = " + input + "; output = " + output);
      } else {
        String input = scanner.next();
        char modeFlag = Character.toUpperCase(input.strip().charAt(0));
        if (modeFlag == 'C') {
          mode = Mode.CELSIUS_TO_FAHRENHEIT;
        } else if (modeFlag == 'F') {
          mode = Mode.FAHRENHEIT_TO_CELSIUS;
        } else {
          // TODO: 6/2/26 Print error message to standard error device.
        }
      }
    }
  }

  private enum Mode {
    CELSIUS_TO_FAHRENHEIT, FAHRENHEIT_TO_CELSIUS
  }

}
