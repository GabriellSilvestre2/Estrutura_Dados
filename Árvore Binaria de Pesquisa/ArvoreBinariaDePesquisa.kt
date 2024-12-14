class ArvoreBinariaDePesquisa : Arborizavel {

    private var raiz: NoTriplo? = NoTriplo()

    override fun inserir(dado: Any?) {
        if(raiz?.dado == null) {
            raiz?.dado = dado
        } else {
            val novoNo = NoTriplo(dado)
            var aux = raiz
            while (aux != null){
                if ((aux.dado as Int) < (dado as Int)) {
                    if (aux.direita != null){
                        aux = aux.direita
                    } else {
                        aux.direita = novoNo
                        novoNo.genitor = aux
                    }
                } else {
                    if (aux.esquerda != null){
                        aux = aux.esquerda
                    } else {
                        aux.esquerda = novoNo
                        novoNo.genitor = aux
                    }
                }
            }
        }
    }

    override fun apagar(dado: Any?): Boolean {
        var aux = raiz
        // Buscar o nó que contém o dado
        while (aux != null && aux.dado != dado) {
            if ((aux.dado as Int) < (dado as Int)) {
                aux = aux.direita
            } else {
                aux = aux.esquerda
            }
        }

        if (aux == null) return false // Dado não encontrado

        // Caso 1: Nó sem filhos (folha)
        if (aux.esquerda == null && aux.direita == null) {
            if (aux == raiz) {
                raiz = null
            } else {
                if (aux == aux.genitor?.esquerda) {
                    aux.genitor?.esquerda = null
                } else {
                    aux.genitor?.direita = null
                }
            }
        }
        // Caso 2: Nó com um único filho
        else if (aux.esquerda == null || aux.direita == null) {
            val filho = aux.esquerda ?: aux.direita
            if (aux == raiz) {
                raiz = filho
            } else {
                if (aux == aux.genitor?.esquerda) {
                    aux.genitor?.esquerda = filho
                } else {
                    aux.genitor?.direita = filho
                }
            }
            filho?.genitor = aux.genitor
        }
        // Caso 3: Nó com dois filhos
        else {
            // Encontrar o sucessor (menor nó à direita)
            var sucessor = aux.direita
            while (sucessor?.esquerda != null) {
                sucessor = sucessor.esquerda
            }

            // Substituir os dados do nó a ser apagado pelo sucessor
            aux.dado = sucessor?.dado
            // Apagar o sucessor, que agora tem no máximo um filho
            apagar(sucessor?.dado)
        }

        return true
    }

    override fun limpar() {
        raiz = NoTriplo()
    }

    override fun existe(dado: Any): Boolean {
        var aux = raiz
        while (aux != null){
            if (aux.dado == dado){
                return true
            } else if ((aux.dado as Int) > (dado as Int)) {
                aux = aux.direita
            } else {
                aux = aux.esquerda
            }
        }
        return false
    }

    override fun buscar(dado: Any): NoTriplo? {
        var aux = raiz
        while (aux != null){
            if (aux.dado == dado){
                return aux
            } else if ((aux.dado as Int) > (dado as Int)) {
                aux = aux.direita
            } else {
                aux = aux.esquerda
            }
        }
        return null
    }

    override fun preOrdem(): String {

    }

    override fun emOrdem(): String {

    }

    override fun posOrdem(): String {

    }
}