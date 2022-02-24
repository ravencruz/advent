package twenty.zero

import java.io.File

data class PasswordWithPolicy (
    val password: String,
    val range: IntRange,
    val letter:Char,
) {

    fun validate() = password.count {
        it == letter
    } in range

    companion object {

        private val regex = Regex("""(\d+)-(\d+) ([a-z]): ([a-z]+)""")

        fun parseRegex(line: String): PasswordWithPolicy? =
            regex.matchEntire(line)
                ?.destructured
                ?.let { (start, end, letter, password) ->
                    PasswordWithPolicy(password, start.toInt()..end.toInt(), letter.single())
                }

        fun parse(line:String) = PasswordWithPolicy(
            password = line.substringAfter(": "),
            letter = line.substringAfter(" ").substringBefore(":").single(),
            range = line.substringBefore(" ").let {
                val (start, end) = it.split("-")
                start.toInt()..end.toInt()
            }
        )
    }
}

fun main() {
    println("Day 2")
    var lines = File("src/main/resources/day_2_simple_input.txt").readLines()
//    var lines = File("src/main/resources/day_2_password_input.txt").readLines()
//    var lines = File("src/main/day_2_password_philo.ktresources/day_2_password_input_part_2.txt").readLines()
//    println(lines)

    val passwords = lines.map { PasswordWithPolicy.parseRegex(it) }
    passwords.forEach(::println)

    println(passwords.count { it?.validate() ?: false })
}
