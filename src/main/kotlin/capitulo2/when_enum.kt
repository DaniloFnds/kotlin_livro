package capitulo2


data class Rectangle(val height: Int, val width: Int) {
    //criar uma variavel, e modificar o seu getter
    val isSquare: Boolean
        get() {
            return height == width
        }

    //outra forma de modificar o getter
    val isHeightNotNegative: Boolean
        get() = height > 0
}

fun main() {

    val quadrado = Rectangle(100, 50)

    print(" eh quadrado? ${quadrado.isSquare}")

    println(Color.BLUE.rgb())

    //utilizando a funcao q retorna de um when
    println(getMnemoic(Color.RED))

    //utilizando uma funcao q retorna um expression when, com combinacoes de branch
    println(getWarmth(Color.VIOLET))

    //utilizando a funcao com o when recebendo uma colecao
    println(mix(Color.INDIGO, Color.BLUE))

    //utilizando a funco com o when sem parametro
    println(mixOptmized(Color.RED, Color.YELLOW))

}
//utilizando o when, q esta no lugar do switch do java, ou é apenas outra forma
fun getMnemoic(color: Color) =
    when (color)  {
        Color.RED -> "Richard"
        Color.ORANGE -> "Of"
        Color.YELLOW -> "Work"
        Color.GREEN -> "Gave"
        Color.BLUE -> "Battle"
        Color.INDIGO -> "In"
        Color.VIOLET -> "Vain"
    }

//combinando varios valores na branch do when
fun getWarmth(color: Color) = when(color) {
    Color.RED, Color.ORANGE, Color.YELLOW -> "warm"
    Color.GREEN -> "neutral"
    Color.BLUE, Color.INDIGO, Color.VIOLET -> "cold"
}

//utilizar o when para receber uma colecao de objetos, e fazer os case, com uma lista de objetos tbm
fun mix(c1: Color, c2: Color) = when(setOf(c1, c2)) {
    setOf(Color.RED, Color.YELLOW) -> Color.ORANGE
    setOf(Color.YELLOW, Color.BLUE) -> Color.GREEN
    setOf(Color.BLUE, Color.VIOLET) -> Color.INDIGO
    else -> throw Exception("Dirt Color")
}

//criando um when sem parametros, apens validando com os valores q tiver no escopo
fun mixOptmized(c1: Color, c2: Color) =
    when  {
        (c1 == Color.RED && c2== Color.YELLOW) ||
                (c1 == Color.YELLOW && c2 == Color.RED) -> Color.ORANGE

        else -> throw Exception("Dirt Color")
    }


//OS ENUMS CLASS NAO SAO LISTA DE VALORES, VC PODE DECLARAR PROPRIEDADES E METODOS EM CLASSES ENUM
//a paralavra enum, é palavra reservada leve
enum class Color(val r: Int, val g: Int, val b: Int) {
    RED(255, 0, 0),
    ORANGE(255, 0, 0),
    YELLOW(255, 0, 0),
    GREEN(255, 0, 0),
    BLUE(255, 0, 0),
    INDIGO(255, 0, 0),
    VIOLET(255, 0, 0);

    fun rgb() = (r * 256 + g) * 256 + b

}
