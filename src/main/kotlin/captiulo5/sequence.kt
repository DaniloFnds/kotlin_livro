package captiulo5

import java.io.File


fun testeSequence() {
    val people2 = listOf(Person("Danilo", 34), Person("Fernandes", 30), Person("Goncalves", 20))

    //com o sequencia é o mesmo que criar o Streams do java 8,os elementos serao procesados( map, filter) por vez
    people2.asSequence()
        .map { it.age }
        .filter { it > 21 }


    //criar uma sequencia, eh o mesmo que utilizar list.asSequencie
    val naturalNumbers = generateSequence(0) { it + 1}
    //aqui vai filtrando os valores até chegar no 100
    val numbersTo100 = naturalNumbers.takeWhile { it <= 100 }

    //soma todos os numeros q estao na sequencia até 100
    println(numbersTo100.sum())
}

//montar uma expresao de extensao para o File que verifica os arquivos parents
//utilizando o generateSequence
fun File.isInsideHiddenDirectory() =
    generateSequence(this) { it.parentFile }.any() { it.isHidden }
//dessa forma q ele monta uma sequencia de arquivos, e pega os arquivos q sao parentFile
//e para qualquer(any) arquivo ele pega os q estao escondido( it.isHidden )