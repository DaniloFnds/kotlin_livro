package capitulo7

import java.time.LocalDate

/*

operador "in" serve para verificar se existe um elemento em uma colecao, igual o contains em java
 */


fun exec10() {
    val listString = listOf("danilo", "fernandes")

    println("danilo" in listString)
}

/*
operador .. é usando para criar um rangeTo

entao aqui ele ta criando um range entre a primeira instancia até a instancia + 10 dias
e depois verificando se a semana 1 esta dentro desse rangeTo
 */
fun exec11() {
    val now = LocalDate.now()
    val vacation = now..now.plusDays(10)
    println(now.plusWeeks(1) in vacation)
}

suspend fun teste() {
    
}


open class Usuario(private val nome: String) {


}
object SimpleSingleton  {
    var nome = "Danilo"

}

fun main() {
//    val name = "Danilo"
//
//    val sobreNome = "Fernandes"
//
//    print(name === sobreNome)

//    var usuario = Usuario()

    val user = Usuario("adas").



}

internal fun test222e() {

}