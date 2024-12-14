interface Arborizavel {
    fun inserir(dado: Any?)
    fun apagar(dado: Any?): Boolean
    fun limpar()
    fun existe(dado: Any): Boolean
    fun buscar(dado: Any): NoTriplo?
    // IMPRESSÃO
    fun preOrdem(): String
    fun emOrdem(): String
    fun posOrdem(): String
}