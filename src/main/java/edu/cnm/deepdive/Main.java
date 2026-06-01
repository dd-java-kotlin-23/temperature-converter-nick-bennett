package edu.cnm.deepdive;

public class Main {

  void main(String[] args) {
    double[] celsiusInputs = {0, 100, -40, 50};
    Converter converter = new Converter();
    for (double c : celsiusInputs) {
      double f = converter.convertC2F(c);
      System.out.printf("Celsius = %.2f; Fahrenheit = %.2f%n", c, f);
    }
  }

}
