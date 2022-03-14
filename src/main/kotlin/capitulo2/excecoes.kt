package capitulo2

import java.io.BufferedReader
import java.io.StringReader


//excecoes kootlin sao todas nao verificadas, e ele trata qd uma class faz um throws de uma excepcao verificada
fun main() {
    val reader = BufferedReader(StringReader("239"))
    println(readNumber(reader))
}

fun readNumber(reader: BufferedReader): Int? {
    try {
        val line = reader.readLine()
        return Integer.parseInt(line)
    }catch (e: NumberFormatException) {
        return null
    }finally {
        reader.close()
    }
}

//usando o try como expressao
fun readNumberExpression(reader: BufferedReader) {
    val number = try {
        Integer.parseInt(reader.readLine())
    }catch (e: NumberFormatException) {
        return
    }
    println(number)
}

//usando tryu expressao e retornar null caso ocorra um excecao
fun readNumberExpressionReturnNull(reader: BufferedReader) {
    val number = try {
        Integer.parseInt(reader.readLine())
    }catch (e: NumberFormatException) {
        null
    }
    println(number)
}