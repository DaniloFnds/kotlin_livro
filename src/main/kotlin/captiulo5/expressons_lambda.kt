package captiulo5

data class Person(val name: String, val age: Int)

val people = listOf(Person("Alice", 29), Person("Danilo", 34))


//funcao de maxBy
fun teste() {
    //maxBY
    people.maxByOrNull { it.age }

    people.maxByOrNull { p: Person -> p.age }
//    formas de fazer o lambda
    //quando a lambda tem algum argumento, precisamos passar o parentes
    //caso nao, podemos chamar direto as chave
    people.maxByOrNull() {it.age}

    //por exemplo um lambda com argumento, colocamos fora
    people.joinToString(separator = " ") { it.name }

    //outra forma com os parentes
    people.joinToString(separator = " ", transform = { it.name} )

    //em kotlin as variaveis dentro de um lambda podem ser mutaveis, diferente do ajva q precisa ser final
    var counter: Int = 0
    people.forEach {
           counter++
    }



    //lambdas podemos fazer colocando as chaves
    //colocar uma expre lambda em uma variavel

    val sum = {x: Int, y: Int -> x + y}
    println(sum(10, 6))

    //outra forma de criar e executar uma expressao
    //criar as chaves e colocar um parentes no final


    //podemos utilizar a referencia de membro q é o dois pontos duplo
    //para referencia as funcoes
    val name = Person::name


}

//criar um lambda q executa uma funcao
val action = {person: Person, message: String ->
    sendMail(person, message)
}

fun sendMail(person: Person, email: String){
    val referenciaVinculada = person::age
    println("send $person, email $email")
}

val nextAction = ::sendMail//chamar uma refencia de membro de sem precisar passar a class


fun salute() = println("salute")

fun main() {
    run(::salute)
    //a funcao run executa uma funcao interna
    run({println(45)})
}

fun funcaoSAM() {
    //criar uma funcao lambda, de uma interface funcional
    //podemos instanciar uma interface funcional, q pode ser utilizada por varias chaamadas a msm instancia

    //podemos criar uma funcao q retorna a instancia
    val putAllDone = createAlLDoneRunnable()

    //ou podemos criar a variavel direto com a lambda
    val putAllDoneVariable = Runnable {
        println("teste")
    }

    executaAllDoneRunnable(putAllDone)
    executaAllDoneRunnable(putAllDoneVariable)

}

//mas para criar essa instancia lambda,precisa ser uma interface funcional( q aceita apenas um metodo)
fun createAlLDoneRunnable(): Runnable {
    return Runnable {
        println("all done")
    }
}

fun executaAllDoneRunnable(runnable: Runnable) {
    runnable.run()
}