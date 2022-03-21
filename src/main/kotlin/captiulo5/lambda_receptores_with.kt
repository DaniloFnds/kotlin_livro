package captiulo5


fun alphabet(): String {
    val result = StringBuilder()
    for (letter in 'A'..'Z') {
        result.append(letter)
    }
    result.append("\nNow I Know the alphabet!")
    return result.toString()
}

//podemos colocar a palavra "with" quando queremos montar uma estrutura de codigo que utilizar uma instancia
//e retornar algo no final
//ele meio q cria um wrapper da instancia, e podemos utilizar ele e entao retornar algo com a instancia q passamos para o with
fun alphabetComWith(): String {
    val stringBuilder = StringBuilder()
    return with(stringBuilder) {
        for (letter in 'A'..'Z') {
            this.append(letter)
        }
        this.append("Now iknow the alaphabet com WITH")
        this.toString()
    }
}
fun alphabetComWithSugar() = with(StringBuilder()) {
    for (letter in 'A'..'Z') {
        this.append(letter)
    }
    this.append("Now iknow the alaphabet com WITH")
    this.toString()
}


fun alphabetComWithSugar2(sb: StringBuilder) = with(sb) {
    for (letter in 'A'..'Z') {
        this.append(letter)
    }
    this.append("Now iknow the alaphabet com WITH")
    this.toString()
}


