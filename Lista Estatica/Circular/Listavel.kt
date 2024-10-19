package src.Lista_Estática.Circular

interface Listavel {
    // Inserir
    fun inserirInicio(dado: Any?)
    fun inserirFim(dado: Any?)
    fun inserirPosicao(posicao: Int, dado: Any?)
    // Remover
    fun removerInicio(): Any?
    fun removerFim(): Any?
    fun removerPosicao(posicao: Int): Any?
    fun limpar()
    // Espiar
    fun espiarInicio(): Any?
    fun espiarFim(): Any?
    fun espiarPosicao(posicao: Int): Any?
    // Atualizar
    fun atualizarInicio(dado: Any?)
    fun atualizarFim(dado: Any?)
    fun atualizarPosicao(posicao: Int, dado: Any?)
    // EstaCheia/Vazia
    fun estaCheia(): Boolean
    fun estaVazia(): Boolean
    // Impressão
    fun imprimir(): String
}