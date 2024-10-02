package src.Fila_Estática.Circular

class FilaEstaticaCircular(private val capacidade: Int): Enfileiravel {
    private var dados: Array<Any?> = arrayOfNulls(capacidade)
    private var ponteiroFim = -1
    private var ponteiroInicio = 0
    private var quantidade = 0

    override fun enfileirar(dado: Any?) {
        if (estaCheia()) throw Exception("Fila Cheia")
        ponteiroFim = (ponteiroFim+1) % capacidade
        dados[ponteiroFim] = dado
        quantidade++
    }

    override fun desenfileirar(): Any? {
        if (estaVazia()) throw Exception("Fila Vazia")
        var aux = dados[ponteiroInicio]
        ponteiroInicio = (ponteiroInicio+1) % capacidade
        quantidade--
        return aux

    }

    override fun espiarInicio(): Any? {
        if (estaVazia()) throw Exception("Fila Vazia")
        return dados[ponteiroInicio]
    }

    override fun atualizarInicio(dado: Any?) {
        if (estaVazia()) throw Exception("Fila Vazia")
        dados[ponteiroInicio] = dado
    }

    override fun estaCheia(): Boolean {
        return (quantidade == capacidade)
    }

    override fun estaVazia(): Boolean {
        return (quantidade == 0)
    }

    override fun imprimir(): String {
        if (estaVazia()) throw Exception("Fila Vazia")
        var retorno = "["
        var ponteiroAux = ponteiroInicio
        for (i in 0 until quantidade){
            if (i == quantidade-1){
                retorno += "${dados[ponteiroAux%capacidade]}"
            } else {
                retorno += "${dados[ponteiroAux%capacidade]},"
            }
            ponteiroAux++
        }
        return "$retorno]"
    }
}