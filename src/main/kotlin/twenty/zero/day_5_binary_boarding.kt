package twenty.zero

/**
 * https://www.youtube.com/watch?v=XEFna3xyxeY&t=15s
 * The first 7 characters will either be F or B; == 128 row of plane (0 - 127)
 * fist letter front (0 - 63) or back (64-127)
 * next another half
 * until 1 row
 * For example, consider just the first seven characters of FBFBBFFRLR:

        Start by considering the whole range, rows 0 through 127.
        F means to take the lower half, keeping rows 0 through 63.
        B means to take the upper half, keeping rows 32 through 63.
        F means to take the lower half, keeping rows 32 through 47.
        B means to take the upper half, keeping rows 40 through 47.
        B keeps rows 44 through 47.
        F keeps rows 44 through 45.
        The final F keeps the lower of the two, row 44.

    The last three characters will be either L or R; these specify exactly one of the 8 columns of
    seats on the plane (numbered 0 through 7).
    For example, consider just the last 3 characters of FBFBBFFRLR:

    Start by considering the whole range, columns 0 through 7.
    R means to take the upper half, keeping columns 4 through 7.
    L means to take the lower half, keeping columns 4 through 5.
    The final R keeps the upper of the two, column 5.

    So, decoding FBFBBFFRLR reveals that it is the seat at row 44, column 5.

    Every seat also has a unique seat ID: multiply the row by 8, then add the column. In this example, the seat has ID 44 * 8 + 5 = 357.
slvetabna solution

 */

fun String.toSeatID(): Int = this
    .replace('B', '1').replace('F', '0')
    .replace('R', '1').replace('L', '0')
    .toInt(radix = 2)

fun main() {
    println("Boarding Pass")
    println("FBFBBFFRLR".toSeatID())
    println("0101100101".toInt(radix = 2))


}