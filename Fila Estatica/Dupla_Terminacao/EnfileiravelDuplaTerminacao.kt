package src.Fila_Estática.Dupla_Terminação

interface EnfileiravelDuplaTerminacao {
    fun enfileirarFim(dado: Any?)
    fun enfileirarInicio(dado: Any?)

    fun desenfileirarFim(): Any?
    fun desenfileirarInicio(): Any?

    fun espiarFim(): Any?
    fun espiarInicio(): Any?

    fun atualizarFim(dado: Any?)
    fun atualizarInicio(dado: Any?)

    fun imprimirFrentePraTras(): String
    fun imprimirTrasPraFrente(): String

    fun estaCheia(): Boolean
    fun estaVazia(): Boolean
}