package capitulo6

import java.io.BufferedReader


/*
trabalhando com tipos nullable em array
 */
fun readNumbers(reader: BufferedReader): List<Int?> {
    val result = ArrayList<Int?>()
    for (line in reader.lineSequence()) {
        try {
            val number = line.toInt()
            result.add(number)
        } catch (e: NumberFormatException) {
            result.add(null)
        }
    }
    return result
}

fun addValidNumbers(numbers: List<Int?>) {
    var sumOfValidNumbers = 0
    var invalidNumbers = 0
    for(number in numbers) {
        if(number != null) {
            sumOfValidNumbers += number
        }else {
            invalidNumbers++
        }
    }

}

fun addValidNumbers2(numbers: List<Int?>) {
    val validNumbers = numbers.filterNotNull()
    println("valid: ${validNumbers.sum()} invalid: ${numbers.size - validNumbers.size}")
}