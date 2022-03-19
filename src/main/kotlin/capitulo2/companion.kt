package capitulo2


/*
o companion é uma forma de acessar metodos de uma class, sem a instancia dela
 eh tipo o static...
pq em kotlin nao tem o static
eh uma boa pra qd queremos crir factorys, e precisamos de metodos statics

 */

class A {

    companion object {
        fun bar() {
            println("companion object called")
        }
    }
}

class UserC {
    val nickname: String
    constructor(email: String) {
        nickname = email.substringBefore("@")
    }
}

///criar class com metodos de fabrica utilizando o compain object
//forma de criar um metodo static na class, para instanciar a class, e colocar um nome q faz sentido
//pq como no kotlin noa tem a palavra static, se utiliza o companion object
//ele cria uma class companion singleton, e assim so tem uma class para gerar as novas classes
class User6 private constructor(val nickname: String) {
    companion object {
        fun newSubscribingUser(email: String) =
            User6(email.substringBefore('@'))
        fun newFacebookUser(accountId: Int) =
            User6(getFacebookName(accountId))

        private fun getFacebookName(accountId: Int): String {
            return "algo"
        }
    }
}

fun testeFabrica() {
    val subscribingUser = User6.newSubscribingUser("email@3email")
    val facebookUser = User6.newFacebookUser(1200)
}

//criar companion como objectos comuns, com nomes

class Person6(val name: String) {
    companion object Loader {
        fun fromJSON(jsonText: String): Person6 =
            Person6(jsonText.substring(0))
    }
}

fun testeCompanionObjectComum() {
    val jsonPerson = Person6.Loader.fromJSON("{name: danilo}")

    //ou assim
    val jsonPerdon5 = Person6.fromJSON("{name: danilo2}")
}


/*
criando um companion object q implementa uma interface
forma qd temos uma factory interface, podemos passar ela para o companion,
e assim criar os method factory
 */

interface JsonFactory<T> {
    fun fromJson(jsonText: String): T
}

class Person7(val name: String) {
    companion object : JsonFactory<Person7> {
        override fun fromJson(jsonText: String): Person7 {
            return Person7(jsonText.substring(0))
        }

    }
}

