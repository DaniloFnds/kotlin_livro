package capitulo2


interface Expr

class Num(val value: Int) : Expr

class Sum(val left: Expr, val right: Expr) : Expr

//montar um eval dessa expressao na forma do java
fun evalJava(e: Expr): Int {
    if (e is Num) {
        val n = e as Num // esse  explicito e é redudant pq o "is" ja faz esse cast inteligente
        return n.value
    }
    if (e is Sum) {
        return evalJava(e.right) + evalJava(e.left) // a variavel E é feito um cast inteligente
    }
    throw java.lang.IllegalArgumentException("Unknow expression")
}

fun evalKotlin(e: Expr): Int =
    if (e is Num) {
        e.value
    } else if (e is Sum) {
        evalKotlin(e.right) + evalKotlin(e.left)
    } else {
        throw java.lang.IllegalArgumentException("Unknow Expression")
    }

fun evalKotlinWhen(e: Expr): Int =
    when (e) {
        is Num ->
            e.value
        is Sum ->
            evalKotlinWhen(e.right) + evalKotlinWhen(e.left)
        else ->
            throw java.lang.IllegalArgumentException("Unknow Expression")
    }

//utilizando uma branch do when, com um bloco de codigo maior
fun evalWithLogging(e: Expr): Int =
    when (e) {
        is Num -> {
            println("num: ${e.value}")
            e.value
        }
        is Sum -> {
            val left = evalWithLogging(e.left)
            val right = evalWithLogging(e.right)
            println("sum: $left + $right")
            left + right
        }
        else -> throw java.lang.IllegalArgumentException("unknow Exception")
    }

fun main() {

    //realizar a conta : (1 + 2) + 4  em um java style code
    println(evalJava(Sum(Sum(Num(1), Num(2)), Num(4))))
    //realizar a conta : (1 + 2) + 4  em um kotlin style code
    println(evalKotlin(Sum(Sum(Num(1), Num(2)), Num(4))))
    //realizar a conta : (1 + 2) + 4  em um kotlin when style code
    println(evalKotlinWhen(Sum(Sum(Num(1), Num(2)), Num(4))))

}