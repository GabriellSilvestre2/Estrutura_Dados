interface Listavel<T> {
    fun inserir(posicao: Int, dado: T?)
    fun anexar(dado: T?)
    fun atualizar(posicao: Int, dado: T?)
    fun apagar(posicao: Int): T?
    fun limpar()
    //get
    fun selecionar(posicao: Int): T?
    //getAll
    fun selecionarTodos(): Array<Any?>
    //auxiliares
    fun estaCheia(): Boolean
    fun estaVazia(): Boolean
    fun imprimir(): String
}