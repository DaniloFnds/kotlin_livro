package capitulo2

import java.util.*

fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "FizzBuzz "
    i % 3 == 0 -> "Fizz "
    i % 5 == 0 -> "Buzz "
    else -> "$i "
}

fun main() {

    //utilizando o range q é os ..(dois pontos) entre um intervalo
    for (i in 1..100) {
        print(fizzBuzz(i))
    }

    //de traz para frente o intervalo, pulando dois elementos
    for (i in 100 downTo 1 step 2) {
        print(fizzBuzz(i))
    }

    var binaryReps = TreeMap<Char, String>()

    for(c in 'A'..'F') {
        val binary = Integer.toBinaryString(c.code)
        binaryReps[c] = binary // isso é equivalente a binaryReps.put(c, binary)
    }


    //forma de iterar sobre um map
    for((letter, binary) in binaryReps) {
        println("$letter = $binary")
    }

    //iterar sobre uma lista e pegar o elemento dnetro do for
    val list = arrayListOf("10", "11", "1001")
    for((index, element) in list.withIndex()) {
        println("$index: $element")
    }

    println(exist("dan3", arrayListOf("dan", "fernandes")))

}

//funcao expression, para verificar dentro de uma collection/intervalo
//com o "in" ele verificar se existe dentro de collection/intervalo
fun exist(c: String, list: List<String>) = c in list
//podemos negar tbm
fun notExist(c: String, list: List<String>) = c !in list

//usando a verificao "in" com o ramos em when
fun recognize(c: Char) = when(c) {
    in '0'..'9' -> "Its a digit"
    in 'a'..'z' -> "Its a letter"
    else -> "i dont know"
}
