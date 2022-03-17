package capitulo2

/*

todas as classes em kotlin tem o seu metodo marcado como final, nao sendo possivel sobrescrever eles

 */

//e para possibilitar sobrescrever o metodo precisamos colocar a palavra "open" antes do metodo
open class Person { //para que uma outra class possa herdar de Person, precisa colocar o open na class
   open fun chama() {
        println("chamou")
    }
}

class SecondPerson: Person() { //precisa colocar o construtor da class herdada

    override fun chama() { //com a funcao open tbm, é possivel sobrescrever ela... se quiser q se alguem tentar sobrescrever essa fncao tbm, precisa colocar como final essa sobrescrita
        super.chama()
    }
}


//class abstract sao igual do java e elas sao open como padrao
abstract class Animated {
    abstract fun animte()
    open fun stopAnimating() = Unit
    fun animeTwitce() = Unit
}