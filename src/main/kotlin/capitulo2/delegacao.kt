package capitulo2

/*

a delegacao seria o decorator, q é colocar uma class como composicao, e modificar as funcoes dela
e para isso, precisamos sobrescrever todos os metodos da class decorada
 */

//no kotlin podemos utilizar a palavra "by" para decorador uma class, e assim ele cria todos os metodos
//mas precisamos receber a class decorada por construtor, dizer q nossa class extende da class decorada
// e colocar o by para o kotlin montar a delegacao dos metodos
class CountingSet<T> (val innerSet: MutableCollection<T> = HashSet<T>()): MutableCollection<T> by innerSet {


    //posso fazer o override de um metodo da collection
    override fun add(element: T): Boolean {
        println("mudei o add do colletion")
        return innerSet.add(element)
    }
}

