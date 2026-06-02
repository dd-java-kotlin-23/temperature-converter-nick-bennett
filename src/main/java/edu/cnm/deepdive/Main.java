package edu.cnm.deepdive;

import java.util.Scanner;

public class Main {

  void main(String[] args) {
    // DONE: 6/2/26 Set initial conversion mode to Celsius-to-Fahrenheit.
    var mode = Mode.CELSIUS_TO_FAHRENHEIT;
    final var converter = new Converter();
    // DONE: 6/2/26 Start reading from standard input.
    final var scanner = new Scanner(System.in);
    while (scanner.hasNext()) {
      if (scanner.hasNextDouble()) {
        handleConversion(scanner, mode, converter);
      } else {
        mode = handleModeChange(scanner, mode);
      }
    }
  }

  private static Mode handleModeChange(Scanner scanner, Mode mode) {
    final var input = scanner.next();
    final var modeFlag = Character.toUpperCase(input.strip().charAt(0));
    return switch (modeFlag) {
      case 'C' -> Mode.CELSIUS_TO_FAHRENHEIT;
      case 'F' -> Mode.FAHRENHEIT_TO_CELSIUS;
      default -> {
        System.err.println("Invalid input: " + input);
        // TODO: 6/2/26 Print error message to standard error.
        yield mode;
      }
    };
  }

  private static void handleConversion(Scanner scanner, Mode mode, Converter converter) {
    final var input = scanner.nextDouble();
    final var output = (mode == Mode.CELSIUS_TO_FAHRENHEIT)
        ? converter.convertC2F(input)
        : converter.convertF2C(input);
    // DONE: 6/2/26 Print conversion mode, input, output.
    System.out.println(buildConversionOutput(mode, input, output));
  }

  private static String buildConversionOutput(Mode mode, double input, double output) {
    String format = (mode == Mode.CELSIUS_TO_FAHRENHEIT)
        ? "Celsius = %.2f; Fahrenheit = %.2f"
        : "Fahrenheit = %.2f; Celsius = %.2f";
    return format.formatted(input, output);
  }

}
