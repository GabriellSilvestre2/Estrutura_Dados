class HeapMinimo(private val tamanho: Int = 10): Amontoavel {

    private var dados: LongArray(tamanho){0}
    private var ponteiroFim = -1

    override fun inserir(dado: Long){
        if (!estaCheia()){
            ponteiroFim++
            dados[ponteiroFim] = dado
            ajustarAcima(ponteiroFim)
        } else {
            print("Heap cheia!")
        }
    }

    override fun obter(): Long? {
        var aux: Long? = null

        if (!estaVazia()){
            aux = dados[0]
        } else {
            print("Heap vazia!")
        }
        return aux
    }

    override fun atualizar(novoDado: Long) {
        if (!estaVazia()){
            dados[0] = novoDado
            ajustarAbaixo(0)
        } else {
            print("Heap Vazia!")
        }
    }

    override fun extrair(): Long? {
        var extraido: Long? = null
        if (!estaVazia()){
            extraido = dados[0]
            dados[0] = dados[ponteiroFim]
            ponteiroFim--
            ajustarAbaixo(0)
        }
        return extraido
    }

    fun estaCheia(): Boolean {
        return (ponteiroFim == (dados.size-1))
    }

    fun estaVazia(): Boolean {
        (ponteiroFim == -1)
    }

    fun imprimir(): String {
        var retorno = "["
        for (i in 0 until dados.size){
            retorno += "${dados[i]}"
            if (i != (dados.size-1))
                resultado += ","
        }
        return "$retorno]"
    }

    private fun filhoEsquerda(indicePai: Int): Int {
        return (indicePai * 2 + 1)
    }

    private fun filhoDireita(indicePai: Int): Int {
        return (indicePai * 2 + 2)
    }

    private fun pai(indiceFilho: Int): Int {
        return (indiceFilho-1) / 2
    }

    private fun troca (i: Int, j: Int) {
        val temp = dados[i]
        dados[i] = dados[j]
        dados[j] = temp
    }
    
    private fun menor(a: Int, b: Int, c: Int): Int{
        if (dados[a] < dados[b]) && (dados[a] < dados[c]) {
            return a
        }
        if (dados[b] < dados[a]) && (dados[b] < dados[c]) {
            return b
        }
        if (dados[c] < dados[a]) && (dados[c] < dados[b]) {
            return c
        }
    }

    private fun menor(a: Int, b: Int): Int{
        if (dados[a] < dados[b])) {
            return a
        }
        if (dados[b] < dados[a])) {
            return b
        }
    }

    private fun ajustarAbaixo(indice: Int) {
        var indicePai = indice
        var indiceFilhoEsquerda = filhoEsquerda(indicePai)
        var indiceFilhoDireita = filhoDireita(indicePai)
        val menor = menor(indicePai, indiceFilhoDireita, indiceFilhoEsquerda)
        
        if (indicePai != menor) {
            val menorFilho = menor(indiceFilhoEsquerda , indiceFilhoDireita)
            troca(indicePai, menorFilho)
            ajustarAbaixo(menorFilho)
        } 
    }

    private fun ajustarAcima(indice: Int){
        var indiceFilho = indice
        var indicePai = pai(indiceFilho)

        while (indiceFilho > 0) {
            if (dados[indiceFilho] < dados[indicePai]){
                troca(indiceFilho, indicePai)
            } else {
                break
            }
            indiceFilho = indicePai
            indicePai = pai(indiceFilho)
        }
        /*
        RECURSIVAMENTE

        if (indice > 0) {
            val indiceFilho = indice
            val indicePai = pai(indiceFilho)

            if (dados[indiceFilho] < dados[indicePai]){
                troca(indiceFilho, indicePai)
            }
            ajustarAcima(indicePai)
        }

        GASTA MUITO RECURSO DO COMPUTADOR
        */
    }
}