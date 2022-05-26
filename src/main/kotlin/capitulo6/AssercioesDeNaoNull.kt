package capitulo6

/*
o operador !! é um tipo de assertion para valor nao null, usado para trabalhar com valores nullable(operador ?)
caso o valor seja null ele retorna uma exceçao(NPE)


 */

fun ignoreNull(s: String?) {
    val sNotNull: String = s!!
    println(sNotNull.length)
}

fun exec3() {
    ignoreNull(null)// ocorre um nullPointer
}