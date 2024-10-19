package src.Fila_Estática.Dupla_Terminação

class FilaEstaticaDuplaTerminacao(private val capacidade: Int): EnfileiravelDuplaTerminacao {
    private var dados: Array<Any?> = arrayOfNulls(capacidade)
    private var quantidade = 0
    private var ponteiroInicio = 0
    private var ponteiroFim = -1

    override fun enfileirarFim(dado: Any?) {
        if (estaCheia()) {
            println("Fila Cheia")
            return
        }
        ponteiroFim = (ponteiroFim+1) % capacidade
        dados[ponteiroFim] = dado
        quantidade++
    }

    override fun enfileirarInicio(dado: Any?) {
        if (estaCheia()) {
            println("Fila Cheia")
            return
        }
        ponteiroInicio--
        if (ponteiroInicio == -1){
            ponteiroInicio = capacidade-1
            if (quantidade == 0){
                ponteiroFim = capacidade-1
            }
        }
        dados[ponteiroInicio] = dado
        quantidade++
    }

    override fun desenfileirarFim(): Any? {
        if (estaVazia()) {
            println("Fila Vazia")
            return null
        }
        var aux = dados[ponteiroFim]
        ponteiroFim--
        if (ponteiroFim == -1)
            ponteiroFim = capacidade-1
        quantidade--
        return aux
    }

    override fun desenfileirarInicio(): Any? {
        if (estaVazia()) {
            println("Fila Vazia")
            return null
        }
        var aux = dados[ponteiroInicio]
        ponteiroInicio = (ponteiroInicio+1) % capacidade
        quantidade--
        return aux
    }

    override fun espiarFim(): Any? {
        if (estaVazia()) {
            println("Fila Vazia")
            return null
        }
        var aux = dados[ponteiroFim]
        return aux
    }

    override fun espiarInicio(): Any? {
        if (estaVazia()) {
            println("Fila Vazia")
            return null
        }
        var aux = dados[ponteiroInicio]
        return aux
    }

    override fun atualizarFim(dado: Any?) {
        if (estaVazia()) {
            println("Fila Vazia")
            return
        }
        dados[ponteiroFim] = dado
    }

    override fun atualizarInicio(dado: Any?) {
        if (estaVazia()) {
            println("Fila Vazia")
            return
        }
        dados[ponteiroInicio] = dado
    }

    override fun imprimirFrentePraTras(): String {
        var retorno = "["
        var ponteiroAux = ponteiroInicio
        for (i in 0 until quantidade){
            if (i == quantidade-1){
                retorno += "${dados[(ponteiroAux+i) % capacidade]}"
            } else {
                retorno += "${dados[(ponteiroAux+i) % capacidade]},"
            }
        }
        return "$retorno]"
    }

    override fun imprimirTrasPraFrente(): String {
        var retorno = "["
        var ponteiroAux = ponteiroFim
        for (i in 0 until quantidade){
            if (i == quantidade-1){
                retorno += "${dados[ponteiroAux]}"
            } else {
                retorno += "${dados[ponteiroAux]},"
            }
            ponteiroAux--
            if (ponteiroAux == -1)
                ponteiroAux = capacidade-1
        }
        return "$retorno]"
    }

    override fun estaCheia(): Boolean {
        return (quantidade == capacidade)
    }

    override fun estaVazia(): Boolean {
        return (quantidade == 0)
    }
}