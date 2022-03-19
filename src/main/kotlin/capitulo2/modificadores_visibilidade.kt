package capitulo2

/*
todos os modificadores em kotlin eh public

para o kotlin o modificadores funcional da seguinte forma

private -> torna o metodo so visivel dentro da class
protected -> torna visivel para subclass e membro da class
sem nada -> sempre sera public final
open -> significa que retira o final, assim eh possivel chamar de uma subclass ou sobrescrever
internal -> faz com nao seja possivel chamar uma referencia da class diretamente
 */

 open class TalkativeButton: Focusable {
    internal fun yell() = println("Hey")
    protected fun whisper() = println("lets talk")

}


class teste {

    fun teste() {
    }

    //dessa forma, eu tenho acesso aos metodos a partir do this, do talkativeBUtton
    //mas se colocar o internal na class da erro de compilacao do kotlin
    fun TalkativeButton.giveSpeech() {
        yell()
    }
}


interface Focusable {

}


class LengthCounter {
    //modificar o acesso a propriedades mutavel colocado o set como private
    var counter: Int = 0
   private set

    fun addWord(word: String) {
        counter += word.length
    }
}


