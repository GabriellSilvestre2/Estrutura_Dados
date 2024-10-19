package src.Pilha_Estática.Invertida

class PilhaEstaticaInvertida(private val capacidade: Int): EmpilhavelInvertida {
    private var dados: Array<Any?> = arrayOfNulls(capacidade)
    private var ponteiroTopo = capacidade

    override fun empilhar(dado: Any?) {
        if (estaCheia()) throw Exception("Pilha Cheia")
        ponteiroTopo--
        dados[ponteiroTopo] = dado
    }

    override fun desempilhar(): Any? {
        if (estaVazia()) throw Exception("Pilha Vazia")
        val aux = dados[ponteiroTopo]
        ponteiroTopo++
        return aux
    }

    override fun espiarTopo(): Any? {
        if (estaVazia()) throw Exception("Pilha Vazia")
        return dados[ponteiroTopo]
    }

    override fun atualizar(dado: Any?) {
        if (estaVazia()) throw Exception("Pilha Vazia")
        dados[ponteiroTopo] = dado
    }

    override fun estaCheia(): Boolean {
        return (ponteiroTopo == 0)
    }

    override fun estaVazia(): Boolean {
        return (ponteiroTopo == capacidade)
    }

    override fun imprimir(): String {
        var retorno = "["
        for (i in ponteiroTopo .. capacidade-1){
            if (i == capacidade-1){
                retorno += "${dados[i]}"
            } else {
                retorno += "${dados[i]},"
            }
        }
        return "$retorno]"
    }
}