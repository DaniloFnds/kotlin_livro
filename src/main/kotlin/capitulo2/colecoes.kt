package capitulo2

fun main() {

    //hashset
    val set = hashSetOf(1,7, 53)
    //arralist
    val list = arrayListOf(1, 7, 53)
    //hashmap
    val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-tree")

    //obter o ultimo elemento
    val strings = listOf("first", "second", "fourteenth")
    println(strings.last())
    //max set
    println(strings.maxOrNull())


    //operador de espelhamento(spread opoerator) ele pega o array e desempacota ele, tornando cada elemento como um argumento para um metodo
    val args: Array<String> = arrayOf("10", "100")

    val listSpread = listOf("args", *args) //colocando o * asterisco, ele vai pegar o array, e desempacotar, colocando o varargs

    println(listSpread)

//    utilizando a funcao "to"
    //modo usual
    val map1 = mapOf(1.to("one"))
    //usando a notacao "infix"
    val map2 = mapOf(1 to "one")

    //declaracao destruturante utilizando a funcao "to"
    val(number, name) = 1 to "one"
    println("number: $number  name: $name")

}
