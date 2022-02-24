package twenty.zero

import java.io.File


fun main() {
    println("hello")

    val numbers = File("src/main/resources/day_1_simple_input.txt")
        .readLines()
        .map { it.toInt() }

    val pair = numbers.findPairOfSum2(2020)
//    println("response is: ${pair.first} * ${pair.second} = ${pair.first * pair.second} ")

    val complementPairs: Map< Int, Pair<Int, Int>?> =
        numbers.associateWith { x ->
            numbers.findPairOfSum2(2020 - x)
        }
    println(complementPairs)

    numbers.firstNotNullOfOrNull { x ->
        val pair = numbers.findPairOfSum2(2020 - x)
    }
}

fun List<Int>.findPairOfSum2(sum: Int): Pair<Int, Int>? {
    val complements = associateBy { sum - it }
    return firstNotNullOfOrNull { number ->
        val complement = complements[number]
        if (complement != null) {
            number to complement
        } else null
    }
}


//    my way
//    val response = complements.filter { (key, _) ->
//        numbers.contains(key)
//    }.map { (key, value) ->
//        key to value
//    }.first()
//    println("response is: ${response.first} * ${response.second} = ${response.first * response.second} ")



//    abc@
//    for (first in numbers) {
//        for (second in numbers) {
//            if (first + second == 2020) {
//                println(first * second)
//                break@abc
//            }
//        }
//    }
//
//    abcd@
//    for (first in numbers) {
//        for (second in numbers) {
//            for (third in numbers) {
//                if (first + second + third == 2020) {
//                    println(first * second * third)
//                    break@abcd
//                }
//            }
//        }
//    }