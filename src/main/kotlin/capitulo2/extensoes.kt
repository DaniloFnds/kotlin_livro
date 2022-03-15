package capitulo2


//eh uma forma de "incluir" um metodo em uma class, sem alterar a mesma
//para utilizar precisa importar a funcao

//por baixo dos panos, o kotlin cria uma class utils static com o nome da class q ela foi declarada, e recebe o objeto receptor como parametro
//

fun String.lastChar(): Char = this.get(this.length - 1)


///criando uma propriedade de extensao, dessa forma vc cria direto e ela não é entendido como metodo
val String.lastChar2: Char
    get() = get(length - 1)

//declarando uma propriedade de extensao mutavel, dessa forma podemos alterar o valor do objeto, alterando o set dele
var StringBuilder.lastChar: Char
    get() = get(length - 1)
    set(value) {
        this.setCharAt(length - 1, value)
    }

fun main() {
    println("Danilo".lastChar())

    println("Danilo".lastChar2)

    val sb = StringBuilder("Kotlin")
    sb.lastChar = '!'
    println(sb)
}
