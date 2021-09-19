package twenty.zero

import java.io.File


fun main() {
    println("hello")

    val numbers = File("src/main/resources/simple_input.txt")
        .readLines()
        .map(String::toInt)

    val sum = 2020
    val pair = findPairOfSum(numbers, sum)

    println(pair)
    println(pair.first * pair.second)
//
//    val sum3 = 2020
//    val pair31 = findPairOfSum(numbers, sum)
}

fun findPairOfSum(numbers: List<Int>, sum: Int): Pair<Int, Int> {
    val complements = numbers.associateBy { sum - it }

    val pair = numbers.firstNotNullOf { number ->
        val complement = complements[number]
        if (complement != null)
            Pair(number, complement)
        else null
    }

    return pair
}

//    println(numbers.associate { "key_$it" to "value_$it" })
//    println(numbers.associateBy { "key_$it" })
//    println(numbers.associateWith { "value_$it" })

//val complements = numbers.associateBy { 2020 - it }
//println(numbers)        //become values
//println(complements)    // become key
//
//val res = complements.mapNotNull { (key, value) ->
//    if (numbers.contains(key)) {
//        key * value
//    } else null
//}.first()
//println(res)