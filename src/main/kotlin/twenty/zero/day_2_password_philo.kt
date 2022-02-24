package twenty.zero

import java.io.File

fun main() {
    println("Day 2")
    var lines = File("src/main/resources/day_2_simple_input.txt").readLines()
//    var lines = File("src/main/resources/day_2_password_input.txt").readLines()
//    var lines = File("src/main/day_2_password_philo.ktresources/day_2_password_input_part_2.txt").readLines()
    println(lines)

    val res = lines.count { line ->
        val (passwordPolicy, password) = line.split(": ")

        val limitSplit = passwordPolicy.split(" ")
        val (limitLower, limitUpper) = limitSplit[0].split("-")

        val letter = limitSplit[1]
        println("low: $limitLower, upper: $limitUpper, letter: $letter, password: $password")

        val counter = password.count {
            it.toString() == letter
        }.also { println(it) }

        counter in limitLower.toInt()..limitUpper.toInt()
    }
    println("res: $res")
}

fun exclusiveOr(first: Boolean, second: Boolean) = first != second
