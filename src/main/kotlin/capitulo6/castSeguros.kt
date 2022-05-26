package capitulo6

/*

cast seguro é utilizando o operador "as" com o operador nullable "?" ficando "as?"
ele verifica se o objeto é do tipo, caso nao retorna null
 */


class Person(val firstName: String, val lastName: String) {
    override fun equals(other: Any?): Boolean {
        val otherPerson = other as? Person ?: return false
        return otherPerson.firstName == firstName &&
                otherPerson.lastName == lastName
    }

}

val p1 = Person("Dimitry", "Jemerov")
val p2 = Person("Dimitry", "Jemerov")
fun exec2() {
    println(p1 == p2) //true o operador == chama o equals
}