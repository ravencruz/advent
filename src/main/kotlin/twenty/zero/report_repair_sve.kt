package twenty.zero

import java.io.File


fun main() {
    println("hello")

    val numbers = File("src/main/resources/simple_input.txt")
        .readLines()
        .map(String::toInt)

    val pair = numbers.findPairOfSum(2020)
    println(pair)
    println(pair?.let { (x, y) -> x * y })

    val complementPairs: Map<Int, Pair<Int, Int>?> =
        numbers.associateWith { x ->
            numbers.findPairOfSum(2020 - x)
        }
    println(complementPairs)
    println(complementPairs)

    val triple = numbers.findTripleOfSum()
    println(triple?.let { (x, y, z) ->
        println("$x * $y * $z")
        x*y*z
    })
}

fun List<Int>.findTripleOfSum() = firstNotNullOfOrNull { x ->
    findPairOfSum(2020 - x)?.let { Triple(x, it.first, it.second) }
}

fun List<Int>.findPairOfSum(sum: Int): Pair<Int, Int>? {
    val complements = associateBy { sum - it }

    return firstNotNullOfOrNull { number ->
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

