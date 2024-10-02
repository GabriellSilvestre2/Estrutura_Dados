package src.Fila_Estática.Circular

fun main(){
    var dados = FilaEstaticaCircular(10)
    dados.enfileirar(1)
    dados.enfileirar(2)
    dados.enfileirar(3)
    dados.enfileirar(4)
    dados.enfileirar(5)
    dados.enfileirar(6)
    dados.enfileirar(7)
    dados.enfileirar(8)
    dados.enfileirar(9)
    dados.enfileirar(10)
    dados.desenfileirar()
    dados.desenfileirar()
    dados.desenfileirar()
    dados.enfileirar(1)
    dados.enfileirar(2)
    dados.enfileirar(3)

    println(dados.imprimir())

}