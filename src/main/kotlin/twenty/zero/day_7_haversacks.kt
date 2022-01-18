package twenty.zero

fun main() {
    println("Hi")
    val input = Bag("shiny gold")
    println(input)
}

data class Bag(val color: String)