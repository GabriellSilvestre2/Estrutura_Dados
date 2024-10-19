package src.Pilha_Estática.Simples

class PilhaEstaticaSimples(private val capacidade: Int): EmpilhavelSimples {
    private var dados: Array<Any?> = arrayOfNulls(capacidade)
    private var ponteiroTopo = -1

    override fun empilhar(dado: Any?) {
        if (estaCheia()) throw Exception("Pilha Cheia")
        ponteiroTopo++
        dados[ponteiroTopo] = dado
    }

    override fun desempilhar(): Any? {
        if (estaVazia()) throw Exception("Pilha Vazia")
        val aux = dados[ponteiroTopo]
        ponteiroTopo--
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
        return (ponteiroTopo == capacidade-1)
    }

    override fun estaVazia(): Boolean {
        return (ponteiroTopo == -1)
    }

    override fun imprimir(): String {
        var retorno = "["
        for (i in ponteiroTopo downTo 0){
            if (i == 0){
                retorno += "${dados[i]}"
            } else {
                retorno += "${dados[i]},"
            }
        }
        return "$retorno]"
    }
}