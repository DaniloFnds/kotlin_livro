package capitulo2


/*

interfaces no kotlin, são igual no java8
diferente que todas as funcoes em uma interface no kotlin, podem receber um corpo igual as interface default do java8
mas não precisa declarar nada

 */


interface Clickable {
    fun click()
    fun showOff() = println("print")
}

