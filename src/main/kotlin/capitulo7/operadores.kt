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