package edu.cnm.deepdive;

import java.util.Scanner;

public class Main {

  void main(String[] args) {
    // DONE: 6/2/26 Set initial conversion mode to Celsius-to-Fahrenheit.
    Mode mode = Mode.CELSIUS_TO_FAHRENHEIT;
    Converter converter = new Converter();
    // DONE: 6/2/26 Start reading from standard input.
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNext()) {
      if (scanner.hasNextDouble()) {
        handleConversion(scanner, mode, converter);
      } else {
        mode = handleModeChange(scanner, mode);
      }
    }
  }

  private static Mode handleModeChange(Scanner scanner, Mode mode) {
    String input = scanner.next();
    char modeFlag = Character.toUpperCase(input.strip().charAt(0));
    mode = switch (modeFlag) {
      case 'C' -> Mode.CELSIUS_TO_FAHRENHEIT;
      case 'F' -> Mode.FAHRENHEIT_TO_CELSIUS;
      default -> {
        System.err.println("Invalid input: " + input);
        // TODO: 6/2/26 Print error message to standard error.
        yield mode;
      }
    };
    return mode;
  }

  private static void handleConversion(Scanner scanner, Mode mode, Converter converter) {
    double input = scanner.nextDouble();
    double output = (mode == Mode.CELSIUS_TO_FAHRENHEIT)
        ? converter.convertC2F(input)
        : converter.convertF2C(input);
    // TODO: 6/2/26 Print conversion mode, input, output.
    System.out.println("input = " + input + "; output = " + output);
  }

}
