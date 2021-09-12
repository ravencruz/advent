package twenty.zero

import java.io.File


fun main() {
    println("hello")

    val numbers = File("src/main/resources/simple_input.txt")
        .readLines()
        .map { it.toInt() }

//    println(numbers.associate { "key$it" to "value$it" })
//    println(numbers.associateBy { "key$it" })
//    println(numbers.associateWith { "value$it" })

    val complements = numbers.associateBy { 2020 - it }
    println(numbers)
    println(complements)

    val pair = numbers.mapNotNull { number ->
        val complement = complements[number]
        if (complement != null)
            Pair(number, complement)
        else null
    }.first()

    println(pair)
    println(pair.first * pair.second)
}