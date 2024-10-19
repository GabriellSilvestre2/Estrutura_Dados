package src.Pilha_Estática.Simples

interface EmpilhavelSimples {
    fun empilhar(dado: Any?)
    fun desempilhar(): Any?
    fun espiarTopo(): Any?
    fun atualizar(dado: Any?)
    fun estaCheia(): Boolean
    fun estaVazia(): Boolean
    fun imprimir(): String
}