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

    //sobrescrever o toString
    override fun toString() = "User3( nickname: $nickname"
}

//podemos criar a variavel direto no construtor primario, assim ela sera inicializada direto no cosntrutor
class User4(val nickName: String) {

}

//podemos no construtor definir valores padroes
open class User5(val nickName: String, val isSubscribed: Boolean = false)


class UserImpl : User5 {
    constructor(idade: Int) : this()

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

interface IUser {
    val nickname: String
}

//podemos fazer o override de propriedade qesta na interface, direto no construtor da class q esta implmenetando
class PrivateUser(override val nickname: String) : IUser

//fazer o override da propriedade da interface, pelo get()
class SubscribingUser(val email: String) : IUser {
    override val nickname: String
        get() = email.substringBefore('@')
}


//podemos passar o override da propriedade da interface, chamando uma funcao
class FacebookUser(val accountId: Int) : IUser {
    override val nickname = getFacebookName(accountId)

    private fun getFacebookName(accountId: Int): String {
        return "algo"
    }
}


//podemos sobrescrever a propriedade passando o get() e utilizar alguma outra propriedade da interface
//assim qd chamarem a popriedade q tem o get() personalizado, sera retornado o valor personalizado

interface UserBackfield {
    val email: String
    val nickname: String
        get() = email + "teste"
}

//podemos modificar o setter tbm para q sempre q alterar o valor da propriedade, possamos fazer algo com o valor anterior
class UserBackfieldImpl(override val email: String) : UserBackfield {

    //podemos alterar o setter da propriedade e olhar o backing field dele
    var lastName: String = "nao_especificado"
    set(value) {
        println("""
            o sobrenome do email: $email foi alterado de $field para $value
        """.trimIndent())
        field = value
    }

}

fun main() {
    val user: UserBackfield = UserBackfieldImpl("danilo")
    println(user.nickname)

    val userImpl = UserBackfieldImpl("danilo@danilo.com")
    userImpl.lastName = "fernandes"
    println(userImpl.lastName)


}

//data class com object dentro
//dessa forma, nossa class Person1 tem uma instancia de um comparator
data class Person1(val name: String) {
    object NameComparator: Comparator<Person1> {
        override fun compare(o1: Person1, o2: Person1): Int {
            return o1.name.compareTo(o2.name)
        }

    }
}

fun testeDataClassComObject() {
    val persons = listOf(Person1("Danio"), Person1("Fernandes"))
    println(persons.sortedWith(Person1.NameComparator))
}