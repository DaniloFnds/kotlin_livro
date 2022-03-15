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


}
