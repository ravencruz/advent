package twenty.zero

import java.io.File


fun main() {
    println("hello")

    val numbers = File("src/main/resources/day_1_report_input.txt")
        .readLines()
        .map { it.toInt() }

    abc@
    for (first in numbers) {
        for (second in numbers) {
            if (first + second == 2020) {
                println(first * second)
                break@abc
            }
        }
    }

    abcd@
    for (first in numbers) {
        for (second in numbers) {
            for (third in numbers) {
                if (first + second + third == 2020) {
                    println(first * second * third)
                    break@abcd
                }
            }
        }
    }

}