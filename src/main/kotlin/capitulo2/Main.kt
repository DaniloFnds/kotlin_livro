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
[]

}