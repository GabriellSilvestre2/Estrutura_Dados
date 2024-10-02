package src.Pilha_Estática.Dupla

class PilhaEstaticaDupla(private val capacidade: Int): EmpilhavelDupla {
    private var dados: Array<Any?> = arrayOfNulls(capacidade)
    private var ponteiroTopo1 = -1
    private var ponteiroTopo2 = capacidade

    override fun empilhar1(dado: Any?) {
        if (estaCheia1()) throw Exception("Pilha Cheia")
        ponteiroTopo1++
        dados[ponteiroTopo1] = dado
    }

    override fun desempilhar1(): Any? {
        if (estaVazia1()) throw Exception("Pilha Vazia")
        val aux = dados[ponteiroTopo1]
        ponteiroTopo1--
        return aux
    }

    override fun espiarTopo1(): Any? {
        if (estaVazia1()) throw Exception("Pilha Vazia")
        return dados[ponteiroTopo1]
    }

    override fun atualizar1(dado: Any?) {
        if (estaVazia1()) throw Exception("Pilha Vazia")
        dados[ponteiroTopo1] = dado
    }

    override fun estaCheia1(): Boolean {
        return (ponteiroTopo1+1 == ponteiroTopo2)
    }

    override fun estaVazia1(): Boolean {
        return (ponteiroTopo1 == -1)
    }

    override fun imprimir1(): String {
        if (estaVazia1()) throw Exception("Pilha Vazia")
        var retorno = "["
        for (i in ponteiroTopo1 downTo 0){
            if (i == 0){
                retorno += "${dados[i]}"
            } else {
                retorno += "${dados[i]},"
            }
        }
        return "$retorno]"
    }

    override fun empilhar2(dado: Any?) {
        if (estaCheia2()) throw Exception("Pilha Cheia")
        ponteiroTopo2--
        dados[ponteiroTopo2] = dado
    }

    override fun desempilhar2(): Any? {
        if (estaVazia2()) throw Exception("Pilha Vazia")
        val aux = dados[ponteiroTopo2]
        ponteiroTopo2++
        return aux
    }

    override fun espiarTopo2(): Any? {
        if (estaVazia2()) throw Exception("Pilha Vazia")
        return dados[ponteiroTopo2]
    }

    override fun atualizar2(dado: Any?) {
        if (estaVazia2()) throw Exception("Pilha Vazia")
        dados[ponteiroTopo2] = dado
    }

    override fun estaCheia2(): Boolean {
        return estaCheia1()
    }

    override fun estaVazia2(): Boolean {
        return (ponteiroTopo2 == capacidade)
    }

    override fun imprimir2(): String {
        if (estaVazia1()) throw Exception("Pilha Vazia")
        var retorno = "["
        for (i in ponteiroTopo2 .. capacidade-1){
            if (i == capacidade-1){
                retorno += "${dados[i]}"
            } else {
                retorno += "${dados[i]},"
            }
        }
        return "$retorno]"
    }
}