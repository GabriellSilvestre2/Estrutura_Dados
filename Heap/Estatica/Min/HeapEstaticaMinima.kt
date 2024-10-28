package src.Heap.Estatica.Min

class HeapEstaticaMinima(private val tamanho: Int): AmontoavelEstaticaMinima {
    private var dados = LongArray(tamanho)
    private var ponteiroFim = -1

    override fun inserir(dado: Long) {
        if (!estaCheia()) {
            ponteiroFim++
            dados[ponteiroFim] = dado
            ajustarAcima(ponteiroFim)
        } else {
            println("Heap Cheia!")
        }
    }

    override fun obter(): Long? {
        var retorno: Long? = null

        if (!estaVazia()) {
            retorno = dados[0]
        } else {
            println("Heap Vazia!")
        }

        return retorno
    }

    override fun atualizar(dado: Long) {
        if (!estaVazia()) {
            dados[0] = dado
            ajustarAbaixo(0)
        } else {
            println("Heap Vazia!")
        }
    }

    override fun extrair(): Long? {
        var retornoRemovido: Long? = null

        if (!estaVazia()) {
            retornoRemovido = dados[0]
            dados[0] = dados[ponteiroFim]
            ponteiroFim--
            ajustarAbaixo(0)
        } else {
            println("Heap Vazia!")
        }

        return retornoRemovido
    }

    override fun estaCheia(): Boolean {
        return (ponteiroFim == (dados.size - 1))
    }

    override fun estaVazia(): Boolean {
        return (ponteiroFim == -1)
    }

    override fun imprimir(): String {
        var retorno = "["

        for (i in 0..ponteiroFim) {
            retorno += "${dados[i]}"
            if (i != ponteiroFim)
                retorno += ","
        }
        return "$retorno]"
    }

    private fun indicePai(indiceFilho: Int): Int {
        return (indiceFilho - 1) / 2
    }

    private fun indiceFilhoEsquerda(indicePai: Int): Int {
        return indicePai * 2 + 1
    }

    private fun indiceFilhoDireita(indicePai: Int): Int {
        return indicePai * 2 + 2
    }

    private fun menor(pai: Int, esquerda: Int, direita: Int): Int {
        var menor = pai

        if (esquerda <= ponteiroFim && dados[esquerda] < dados[menor]) {
            menor = esquerda
        }
        if (direita <= ponteiroFim && dados[direita] < dados[menor]) {
            menor = direita
        }

        return menor
    }

    private fun ajustarAbaixo(indice: Int) {
        var pai = indice

        while (true) {
            val esquerda = indiceFilhoEsquerda(pai)
            val direita = indiceFilhoDireita(pai)
            var menor = menor(pai, esquerda, direita)

            if (menor == pai) break

            trocar(pai, menor)
            pai = menor
        }
    }

    private fun ajustarAcima(ponteiroFim: Int) {
        var indiceFilho = ponteiroFim
        var indicePai = indicePai(indiceFilho)

        while (indiceFilho > 0 && dados[indicePai] > dados[indiceFilho]) {
            trocar(indiceFilho, indicePai)
            indiceFilho = indicePai
            indicePai = indicePai(indiceFilho)
        }
    }

    private fun trocar(i: Int, j: Int) {
        val aux = dados[i]
        dados[i] = dados[j]
        dados[j] = aux
    }
}