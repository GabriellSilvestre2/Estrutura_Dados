package src.Heap.Dinamica.Max

interface AmontavelDinamicaMaxima {

    fun inserir(dado: Long)
    fun obter(): Long?
    fun atualizar(novoDado: Long)
    fun extrair(): Long?

    fun estaCheia(): Boolean
    fun estaVazia(): Boolean
    fun imprimir(): String

}