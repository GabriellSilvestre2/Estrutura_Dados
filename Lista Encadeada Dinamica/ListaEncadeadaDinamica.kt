class ListaEncadeadaDinamica<T>(private val tamanho: Int) : Listavel<T>{

    private var ponteiroInicio: NoDuplo<T>? = null
    private var ponteiroFim: NoDuplo<T>? = null
    private var quantidade = 0

    override fun inserir(posicao: Int, dado: T?) {
        if (!estaCheia()){
            if (posicaoValida(posicao)){
                val novoNo = NoDuplo(dado)

                var ant: NoDuplo<T>? = null
                var pro = ponteiroInicio

                for (i in 0 until posicao) {
                    ant = pro
                    pro = pro?.proximo
                }

                if (ant != null) {
                    ant.proximo = novoNo
                } else {
                    ponteiroInicio = novoNo
                }

                if (pro != null) {
                    pro.anterior = novoNo
                } else {
                    ponteiroFim = novoNo
                }

                novoNo.proximo = pro
                novoNo.anterior = ant

                quantidade++
            } else {
                throw Exception("Posição Inválida!")
            }
        } else {
            throw Exception("Lista Cheia!")
        }
    }

    override fun anexar(dado: T?) {
        if (!estaCheia()){
            var noAux = NoDuplo(dado)
            noAux.anterior = ponteiroFim
            if (!estaVazia())
                ponteiroFim?.proximo = noAux
            else
                ponteiroInicio = noAux
            ponteiroFim = noAux
            quantidade++
        } else {
            throw Exception("Lista Cheia!")
        }
    }

    override fun atualizar(posicao: Int, dado: T?) {
        if (!estaVazia()){
            if (posicaoValida(posicao)){
                var aux = ponteiroInicio
                for (i in 0 until posicao){
                    aux = aux?.proximo
                }
                aux?.dado = dado
            } else {
                throw Exception("Posição Inválida!")
            }
        } else {
            throw Exception("Lista Vazia!")
        }
    }

    override fun apagar(posicao: Int): T? {
        var dado: T?

        if (!estaVazia()){
            if (posicaoValida(posicao)){
                var aux = ponteiroInicio
                for (i in 0 until posicao){
                    aux = aux?.proximo
                }
                dado = aux?.dado

                var ant = aux?.anterior
                val pro = aux?.proximo

                if (ant != null){
                    ant?.proximo = pro
                } else {
                    ponteiroInicio = ponteiroInicio?.proximo
                }

                if (pro != null) {
                    pro?.anterior = ant
                } else {
                    ponteiroFim = ponteiroFim?.anterior
                }

                quantidade--
            } else {
                throw Exception("Posição Inválida!")
            }
        } else {
            throw Exception("Lista Vazia!")
        }

        return dado
    }

    override fun limpar() {
        ponteiroInicio = null
        ponteiroFim = null
        quantidade = 0
    }

    override fun selecionar(posicao: Int): T? {
        var dado: T?

        if (!estaVazia()){
            if (posicaoValida(posicao)){
                var aux = ponteiroInicio
                for (i in 0 until posicao){
                    aux = aux?.proximo
                }
                dado = aux?.dado
            } else {
                throw Exception("Posição Inválida!")
            }
        } else {
            throw Exception("Lista Vazia!")
        }

        return dado
    }

    override fun selecionarTodos(): Array<Any?> {
        var dados: Array<Any?> = arrayOfNulls(quantidade)

        if (!estaVazia()) {
            var aux = ponteiroInicio
            for (i in 0 until quantidade) {
                dados[i] = aux?.dado
                aux = aux?.proximo
            }
        } else {
            throw Exception("Lista Vazia!")
        }
        return dados
    }

    override fun estaCheia(): Boolean {
        return quantidade == tamanho
    }

    override fun estaVazia(): Boolean {
        return quantidade == 0
    }

    override fun imprimir(): String {
        var ponteiroAux = ponteiroInicio
        var retorno = "["

        for (i in 0 until quantidade){
            retorno += ponteiroAux?.dado
            if (i != (quantidade-1)){
                retorno += ", "
            }
            ponteiroAux = ponteiroAux?.proximo
        }

        return "$retorno]"
    }

    private fun posicaoValida(posicao: Int): Boolean{
        if (posicao >= 0 && posicao < quantidade){
            return true
        } else {
            return false
        }
    }
}