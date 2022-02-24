package twenty.zero

import java.io.File

fun main() {
    println("Day 2")
//    var lines = File("src/main/resources/day_2_simple_input.txt").readLines()
    var lines = File("src/main/resources/day_2_password_input_part_2.txt").readLines()
//    var lines = File("src/main/day_2_password_philo.ktresources/day_2_password_input_part_2.txt").readLines()
    println(lines)

    val res = lines.count { line ->
        val (passwordPolicy, password) = line.split(": ")

        val limitSplit = passwordPolicy.split(" ")
        val (limitLower, limitUpper) = limitSplit[0].split("-")

        val letter = limitSplit[1].single()
        println("low: $limitLower, upper: $limitUpper, letter: $letter, password: $password")

        // validation
//        val counter = password.count {
//            it == letter
//        }.also { println(it) }
//
//        counter in limitLower.toInt()..limitUpper.toInt()
        val cond1 = password[limitLower.toInt() -1] == letter
        val cond2 = password[limitUpper.toInt() -1] == letter
//        exclusiveOr(cond1, cond2)
        cond1 xor cond2
    }
    println("res: $res")
}

//fun exclusiveOr(first: Boolean, second: Boolean) = first != second
