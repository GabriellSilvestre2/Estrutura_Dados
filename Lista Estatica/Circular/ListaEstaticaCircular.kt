package src.Lista_Estática.Circular

class ListaEstaticaCircular(private val capacidade: Int): Listavel {
    var dados: Array<Any?> = arrayOfNulls(capacidade)
    private var ponteiroInicio = 0
    private var ponteiroFim = -1
    private var quantidade = 0

    override fun inserirInicio(dado: Any?) {
        if (estaCheia()) return println("Lista Cheia")
        for (i in quantidade downTo 1){
            dados[(ponteiroInicio+i) % capacidade] = dados[(ponteiroInicio+i-1) % capacidade]
        }
        dados[ponteiroInicio] = dado
        ponteiroFim = (ponteiroFim + 1) % capacidade
        quantidade++
    }

    override fun inserirFim(dado: Any?) {
        if (estaCheia()) return println("Lista Cheia")
        ponteiroFim = (ponteiroFim + 1) % capacidade
        dados[ponteiroFim] = dado
        quantidade++
    }

    override fun inserirPosicao(posicao: Int, dado: Any?) {
        if (estaCheia()) return println("Lista Cheia")
        if (posicao < 0 || posicao > quantidade) return println("Posição Invalida")

        val posicaoFisica = (ponteiroInicio + posicao) % capacidade
        for (i in (quantidade-posicao) downTo 1){
            dados[(posicaoFisica+i) % capacidade] = dados[(posicaoFisica+i-1) % capacidade]
        }
        dados[posicaoFisica] = dado
        ponteiroFim = (ponteiroFim + 1) % capacidade
        quantidade++
    }

    override fun removerInicio(): Any? {
        if (estaVazia()) return println("Lista Vazia")
        var aux = dados[ponteiroInicio]
        ponteiroInicio = (ponteiroInicio + 1) % capacidade
        quantidade--
        return aux
    }

    override fun removerFim(): Any? {
        if (estaVazia()) return println("Lista Vazia")
        var aux = dados[ponteiroFim]
        ponteiroFim--
        if (ponteiroFim == -1)
            ponteiroFim = capacidade-1
        quantidade--
        return aux
    }

    override fun removerPosicao(posicao: Int): Any? {
        if (estaVazia()) return println("Lista Vazia")
        if (posicao < 0 || posicao >= quantidade) return println("Posição Invalida")
        val posicaoFisica = (ponteiroInicio + posicao) % capacidade
        var aux = dados[posicaoFisica]
        for (i in 0 until quantidade-posicao){
            dados[(posicaoFisica+i) % capacidade] = dados[(posicaoFisica+i+1) % capacidade]
        }
        ponteiroFim--
        if (ponteiroFim == -1)
            ponteiroFim = capacidade-1
        quantidade--
        return aux
    }

    override fun limpar() {
        ponteiroInicio = 0
        ponteiroFim = -1
        quantidade = 0
    }

    override fun espiarInicio(): Any? {
        if (estaVazia()) return println("Lista Vazia")
        return dados[ponteiroInicio]
    }

    override fun espiarFim(): Any? {
        if (estaVazia()) return println("Lista Vazia")
        return dados[ponteiroFim]
    }

    override fun espiarPosicao(posicao: Int): Any? {
        if (estaVazia()) return println("Lista Vazia")
        if (posicao < 0 || posicao >= quantidade) return println("Posição Invalida")
        val posicaoFisica = (ponteiroInicio + posicao) % capacidade
        return dados[posicaoFisica]
    }

    override fun atualizarInicio(dado: Any?) {
        if (estaVazia()) return println("Lista Vazia")
        dados[ponteiroInicio] = dado
    }

    override fun atualizarFim(dado: Any?) {
        if (estaVazia()) return println("Lista Vazia")
        dados[ponteiroFim] = dado
    }

    override fun atualizarPosicao(posicao: Int, dado: Any?) {
        if (estaVazia()) return println("Lista Vazia")
        if (posicao < 0 || posicao >= quantidade) return println("Posição Invalida")
        val posicaoFisica = (ponteiroInicio + posicao) % capacidade
        dados[posicaoFisica] = dado
    }

    override fun estaCheia(): Boolean {
        return (quantidade == capacidade)
    }

    override fun estaVazia(): Boolean {
        return (quantidade == 0)
    }

    override fun imprimir(): String {
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
}