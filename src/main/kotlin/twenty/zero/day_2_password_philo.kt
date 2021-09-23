package twenty.zero

import java.io.File

fun main() {
    println("Day 2")
//    var lines = File("src/main/resources/day_2_simple_input.txt").readLines()
    var lines = File("src/main/resources/day_2_password_input.txt").readLines()
//    var lines = File("src/main/resources/day_2_password_input_part_2.txt").readLines()
    println(lines)

    val res = lines.count { line ->
        val policyPassword = line.split(":")
        val policy = policyPassword[0]

        val limitLetter = policy.split(" ")
        val limit = limitLetter[0].split("-")

        val limitLower = limit[0].toInt()
        val limitUpper = limit[1].toInt()

        val letter = limitLetter[1]
        val password = policyPassword[1].trim()

        println("low: $limitLower, upper: $limitUpper, letter: $letter, password: $password")

//        val counter = password.count {
//            it.toString() == letter
//        }.also { println(it) }
//
//        counter in limitLower..limitUpper

        exclusiveOr(
            password[limitLower-1].toString() == letter,
            password[limitUpper-1].toString() == letter
        )
    }
    println("res: $res")
}

fun exclusiveOr(first: Boolean, second: Boolean) = first != second
