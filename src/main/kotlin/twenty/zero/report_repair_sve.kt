package twenty.zero

import java.io.File


fun main() {
    println("hello")

    val numbers = File("src/main/resources/simple_input.txt")
        .readLines()
        .map(String::toInt)

    val pair = numbers.findPairOfSum(2020)

    println(pair)
    println(pair.first * pair.second)

//    val complement = numbers.map { 2020-it }
//    val pair31 = complement.findPairOfSum(2020)
//
//    println(pair31)
//    println(pair31.first * pair31.second)
}

fun List<Int>.findPairOfSum(sum: Int): Pair<Int, Int> {
    val complements = associateBy { sum - it }

    return firstNotNullOf { number ->
        val complement = complements[number]
        if (complement != null) Pair(number, complement) else null
    }
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