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
    val input: Double = scanner.nextDouble()
    val output: Double = if (mode == Mode.CELSIUS_TO_FAHRENHEIT) {
        converter.convertC2F(input)
    } else {
        converter.convertF2C(input)
    }
    println("input = $input; output = $output")
}

private fun handleModeChange(scanner: Scanner, mode: Mode): Mode {
    val input: String = scanner.next()
    val modeFlag: Char = input.trim()[0].uppercaseChar()
    return when (modeFlag) {
        'C' -> Mode.CELSIUS_TO_FAHRENHEIT
        'F' -> Mode.FAHRENHEIT_TO_CELSIUS
        else -> {
            System.err.println("Invalid input: $input")
            mode
        }
    }
}