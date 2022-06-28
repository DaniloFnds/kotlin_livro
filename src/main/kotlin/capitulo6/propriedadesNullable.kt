package capitulo6

import capitulo7.test222e

/*
Propriedades nullable sao referencias q podem receber null como valor,
entao, colocamos ? no final para dizer como: String is null? como uma pergunta

 */
class Employee(val name: String, val manager: Employee?)

fun managerName(employee: Employee): String?  = employee.manager?.name //como é nullable a referencia manager,
// precisamos checar antes de chamar uma variavel dela, caso seja null a referencia é
// retornado null

val ceo = Employee("Da Boss", null)
val develper = Employee("Bob Smith", ceo)

fun exec() {
    println(managerName(develper)) //-> Da Boss
    println(managerName(ceo)) //null
}



fun main() {
test222e()
}
