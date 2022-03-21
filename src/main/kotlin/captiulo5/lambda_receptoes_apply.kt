package captiulo5


//podemos utilizar a funcao apply, para fazer a mesma coisa q a funcao with, mas a funcao apply sempre devolver a instancia do objeto receptor

fun alphabetApply() = StringBuilder().apply {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("Now i know the alphabet")
}.toString() // e assim chamar oq quiser referente ao StringBuilder


//podemos chamar o apply a partir de um argumento da funcao

fun alphabetApply(sb: StringBuilder) = sb.apply {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("Now i know the alphabet")
}.toString()

//existe uma funcao chamada buildString q é uma lambda pra criar o StringBUilder e devoler a String dela
fun alphabetBuildString() = buildString {
    for(letter in 'A'..'Z') {
        append(letter)
    }
    append("Now i know string buioder")
}