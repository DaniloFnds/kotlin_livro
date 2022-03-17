package capitulo2

/*
sealed class -> vai fazer com q so seja possivel pasasr uma class q implementa diretamente
a class sealed, isso ajuda no when, q nao obriga a criar o default
 */

sealed class Expr2 {
    class Num(val value: Int): Expr2()
    class Sum(val left: Expr2, val right: Expr2): Expr2()
}

//dessa forma nao precisamos declarar o default, pq ele entende q atendemos todas as subclass q implementa a Expr2
fun eval(e: Expr2): Int =
    when (e) {
        is Expr2.Num -> e.value
        is Expr2.Sum -> eval(e.left) + eval(e.right)
    }
