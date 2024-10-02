package src.Fila_Estática.Circular

interface Enfileiravel {
    fun enfileirar(dado: Any?)
    fun desenfileirar(): Any?
    fun espiarInicio(): Any?
    fun atualizarInicio(dado: Any?)
    fun estaCheia(): Boolean
    fun estaVazia(): Boolean
    fun imprimir(): String
}