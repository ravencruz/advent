package twenty.zero

//fun readFileAsLinesUsingUseLines(fileName: String): List<String>
//        = File(fileName).useLines { it.toList() }

fun readFileAsLinesUsingUseLines(fileName: String): String =
    object {}.javaClass.getResource("/report_input.txt").readText()

fun main() {
    println("hello")
    val input = readFileAsLinesUsingUseLines("./report_input.txt")
//    println(input)

    val numbers = input.trim()
        .split("\\s+".toRegex())
        .map { it.toInt() }

//    val sample = listOf(1,2,3, 5)
//    for (i in sample.indices) {
//        val next = i+1
//        for (j in next..sample.lastIndex) {
//            println("${sample[i]} - ${sample[j]}")
//        }
//    }

    var res = -1
    for (i in numbers.indices) {
        val next = i + 1
        for (j in next..numbers.lastIndex) {
            if (numbers[i] + numbers[j] == 2020) {
                res = numbers[i] * numbers[j]
                break
            }
        }
    }
    println(res)

    for (i in numbers.indices) {
        val iNext = i + 1
        for (j in iNext..numbers.lastIndex) {
            val jNext = j + 1
            for (k in jNext..numbers.lastIndex) {
                if (numbers[i] + numbers[j] + numbers[k] == 2020) {
                    res = numbers[i] * numbers[j] * numbers[k]
                    break
                }
            }
        }
    }
    println(res)

}