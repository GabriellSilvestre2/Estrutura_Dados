fun main(){
    var lista = ListaEncadeadaDinamica<String>(50)
    lista.anexar("a")
    lista.anexar("b")
    lista.anexar("c")
    lista.anexar("d")
    lista.anexar("e")

    println(lista.imprimir())

    lista.inserir(2, "f")

    println(lista.imprimir())

    lista.inserir(0, "h")

    println(lista.imprimir())

    lista.apagar(3)
    lista.apagar(0)

    println(lista.imprimir())

    lista.limpar()

    println(lista.imprimir())

}