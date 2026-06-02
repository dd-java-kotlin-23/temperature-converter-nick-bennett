package edu.cnm.deepdive

import java.util.*

fun main() {
    var mode = Mode.CELSIUS_TO_FAHRENHEIT
    val converter = Converter()
    val scanner = Scanner(System.`in`)
    while (scanner.hasNext()) {
        if (scanner.hasNextDouble()) {
            handleConversion(scanner, mode, converter)
        } else {
            mode = handleModeChange(scanner, mode)
        }
    }
}

private fun handleConversion(scanner: Scanner, mode: Mode, converter: Converter) {
    val input = scanner.nextDouble()
    val output = if (mode == Mode.CELSIUS_TO_FAHRENHEIT) {
        converter.convertC2F(input)
    } else {
        converter.convertF2C(input)
    }
    println(buildConversionOutput(mode, input, output))
}

private fun handleModeChange(scanner: Scanner, mode: Mode): Mode {
    val input = scanner.next()
    val modeFlag = input.trim()[0].uppercaseChar()
    return when (modeFlag) {
        'C' -> Mode.CELSIUS_TO_FAHRENHEIT
        'F' -> Mode.FAHRENHEIT_TO_CELSIUS
        else -> {
            System.err.println("Invalid input: $input")
            mode
        }
    }
}

private fun buildConversionOutput(mode: Mode, input: Double, output: Double): String {
    val format = if (mode == Mode.CELSIUS_TO_FAHRENHEIT)
        "Celsius = %.2f; Fahrenheit = %.2f"
    else
        "Fahrenheit = %.2f; Celsius = %.2f"
    return format.format(input, output)
}
