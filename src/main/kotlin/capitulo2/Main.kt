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
