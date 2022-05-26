package capitulo6

/*

a funcao let facilita lidar com expressoes nullable, referencias nullable.
utilizando uma DSl, ele verifica se o valor é null, e aplica algo e retorna oq tiver na ultima linha

 */

fun sendEmailTo(email: String) {
    println(email)
}

fun exec4(email: String?) {

    email?.let {
        sendEmailTo(it)
    }
}

//usando o let para chamar ma funcao com parametro nao null

fun sendEmailTo2(email: String) {
    print(email)
}

var email: String? = "alo@uo.com"

fun exec5() {
    email?.let { sendEmailTo2(it) }
}

data class PersonLet(val nome: String)

fun getPersonFromRepository(idade: Int): PersonLet? {
    if(idade == 5) {
        return null
    }
    return PersonLet("Danilo")
}

fun exec6() {
    getPersonFromRepository(0)?.let {
        sendEmailTo2(it.nome)
    }
}


//propriedaes inicadas tardiament
//usando assercoes de nao null para acessar uma propriedade nullable

class MyService {
    fun performAction(): String = "foo"
}

class MyTest {
    private lateinit var myService: MyService
    fun setUp() {
        myService = MyService()
    }

    fun testAction() {
        myService.performAction()

    }
}

