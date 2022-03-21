package capitulo2

/*
a palavra object cria uma class e instancia a class

forma de criar class singleton


 */

//declaracao de objetos em singleton
//essa class é gerado no padrao singleton
//ela pode conter blocos de inicializacao, metodos
//mas nao pode conter primario ou secundarioa construtor
//podem implementar interfaces
object Payroll : Comparator<Person> {
    val empregados = arrayListOf<Person>()
    fun calculateSalary() {
        for (person in empregados) {

        }
    }

    override fun compare(o1: Person?, o2: Person?): Int {
        return 1
    }

}

fun executarCalculoSalario() {
    //para chamar o objeto, chamaos pelo nome da class
    Payroll.calculateSalary()
}


/*

criar class anonimas de uma interface
 igual fazemos com as interface no java
 new Interface {}

 diferente de criar uma classa anonima, um objecto anonima nao é singleton
 sempre sera criado um novo
 */

interface IAnonima {
    fun teste()
}

class ChamarAnonima {

    fun createAnonime(ano : IAnonima) {
        ano.teste()
    }
}

fun testeObjectAnonimo() {
    val chamarANonimaTeste = ChamarAnonima()
    chamarANonimaTeste.createAnonime(
        object  : IAnonima {
            override fun teste() {
                println("class anonima chmada e criada")
            }

        }
    )

    //ou dessa forma
    val anonimaObject = object : IAnonima {
        override fun teste() {
            println("anonima criada e chamada")
        }
    }
    println(anonimaObject.teste())
}


fun objetcReutilizados() {
    //quando criamos um object de uma interface, e utilizamos em outro lugar( tipo uma interface funcional )
    /*
    mas se nao utilizar nenhuma variavel externa do scopo do objeto, sempre será chamado o mesmo objeto
    caso utilize algo externo, o compilador ira criar uma class para o objeto, e assim será criaod sempre uma instancia
     */
    handlerComputatation(100)
}
fun handlerComputatation(id: Int) {
    postPoneComputation(id, object : Runnable {
        override fun run() {
            println(id)//usando uma variavel de outro externo, sera criado uma instancia pra cada
        }

    })
}

fun postPoneComputation(id:Int, runnable: Runnable) {
    runnable.run() {
        //nao utilizando nenhuma variavel externa, sera o mesmo runnable para todos
        println(40)
    }
}