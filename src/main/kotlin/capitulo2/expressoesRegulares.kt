package capitulo2

fun main() {

    println("12.346-5.A".split(".", "-")) // fazer o split por delimitadores
    println("12.346-6.A".split("\\.|-".toRegex())) //e fazer o split por uma regex


}
fun parsePathDelimitadores(path: String) {
    val directory = path.substringBeforeLast("/")
    val fullname = path.substringAfterLast("/")
    val filename = fullname.substringBeforeLast(".")
    val extension = fullname.substringAfterLast(".")

}

fun parsePathRegex(path: String) {
    val regex = """(.+)/(.+)\.(.+)""".toRegex() // com a aspas tripla nao é necessario fazer o escape das barras invertidas
    val matchResult = regex.matchEntire(path)
    if( matchResult != null ) {
        val (directory, filename, extension) = matchResult.destructured
        println("$directory $filename $extension")
    }
}