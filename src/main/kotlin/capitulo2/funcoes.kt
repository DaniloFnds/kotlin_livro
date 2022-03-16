package capitulo2

fun main() {


}

//funcoes locais, sao funcoes que podemos criar dentro de funcoes
class User(val id: Int, val name: String, val address: String)

fun saveUser(user: User) {
    fun validate(user: User, value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("cant save user $user empty $fieldName")
        }
    }

    //podemos executar o metodo dentro do metodo
    validate(user, user.name, "Name")
    validate(user, user.address, "address")
}

//podemos chamar o objeto user direto na funcao validate
fun saveUser2(user: User) {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("cant save $user empty $fieldName")
        }
    }
    validate(user.name, "name")
    validate(user.address, "address")
}

//podemos levar a funcao de validacao para uma funcao de extensao
fun saveUser3(user: User) {
    user.validaBeforeSave()
}

fun User.validaBeforeSave() {
    fun valida(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("cant save user $this empty $fieldName")
        }
    }
}