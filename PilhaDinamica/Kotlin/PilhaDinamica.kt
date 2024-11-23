class PilhaDinamica(var tamanho: Int) : Empilhavel {

    var ponteiroTopo: NoDuplo? = null
    var quantidade = 0

    override fun empilhar(dado: Any?) {
        if (!estaCheia()) {
            val novoNo = NoDuplo(dado)
            if (!estaVazia()) {
                ponteiroTopo?.proximo = novoNo
                novoNo.anterior = ponteiroTopo
            }
            ponteiroTopo = novoNo
            quantidade++
        } else {
            println("Pilha Cheia")
        }
    }

    override fun desempilhar(): Any? {
        var aux: Any? = null

        if (!estaVazia()) {
            aux = ponteiroTopo?.dado
            ponteiroTopo = ponteiroTopo?.anterior
            if (ponteiroTopo != null)
                ponteiroTopo?.proximo = null
            quantidade--
        } else {
            println("Pilha Vazia")
        }

        return aux
    }

    override fun espiar(): Any? {
        return if (!estaVazia()) {
            ponteiroTopo?.dado
        } else {
            println("Pilha Vazia")
            null
        }
    }

    override fun atualizar(dado: Any?) {
        if (!estaVazia()) {
            ponteiroTopo?.dado = dado
        } else {
            println("Pilha Vazia")
        }
    }

    override fun estaCheia(): Boolean {
        return quantidade == tamanho
    }

    override fun estaVazia(): Boolean {
        return quantidade == 0
    }

    override fun imprimir(): String {
        var aux = ponteiroTopo
        var retorno = "["

        while (aux != null) {
            retorno += aux.dado
            if (aux.anterior != null) retorno += ", "
            aux = aux.anterior
        }

        return "$retorno]"
    }
}