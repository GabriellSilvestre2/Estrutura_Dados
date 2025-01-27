package src.Heap.Estatica.Max

interface AmontoavelEstaticaMaxima {

    fun inserir(dado: Long)
    fun obter(): Long?
    fun atualizar(dado: Long)
    fun extrair(): Long?

    fun estaCheia(): Boolean
    fun estaVazia(): Boolean
    fun imprimir(): String

}