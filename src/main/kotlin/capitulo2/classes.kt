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

class SecondPerson : Person() { //precisa colocar o construtor da class herdada

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


//class com construtor explicito, esse é o construtor primario
//construtor primario nao pode ter blocos de inicializacoa dentro, para isso usamos o bloco init {}
//e podemos ter varios blocos de inicializacao
class User2 constructor(_nickname: String) {
    val nickname: String

    //bloco de inicializacao
    init {
        nickname = _nickname
    }
}

//montar o construtor primario implicito, sem precisar criar o bloco de inicialiacao init {} é q feito no val nome = nome
class User3(_nickname: String) {
    val nickname = _nickname
}

//podemos criar a variavel direto no construtor primario, assim ela sera inicializada direto no cosntrutor
class User4(val nickName: String) {

}

//podemos no construtor definir valores padroes
open class User5(val nickName: String, val isSubscribed: Boolean = false)


class UserImpl : User5 {
    constructor(idade: Int): this()

    //isso é o construtor secundario
    constructor(nickName: String) : super(nickName) // para chamar o construtor da superclass, colocamos o super(e o construtor)

    constructor(nickName: String, isSubscribed: Boolean) : super(
        nickName,
        isSubscribed
    ) // declarando o outro constyrutor da superclass

    //criar um construtor e chamar um outro da propria class
    constructor() : this("sadsa", true) {

    }

}

