class FilaDinamica(var tamanho: Int): Enfileiravel {

    private var ponteiroInicio: NoDuplo? = null
    private var ponteiroFim: NoDuplo? = null
    private var quantidade = 0

    override fun enfileirar(dado: Any?) {
		if (!estaCheia()) {
			var novoNo = NoDuplo(dado)
            if (!estaVazia())
				ponteiroFim?.proximo = novoNo
			else
				ponteiroInicio = novoNo 
			novoNo.anterior = ponteiroFim
			ponteiroFim = novoNo
			quantidade++
		} else {
			println("Fila Cheia!")
		}
	}
	
	override fun desenfileirar(): Any? {
		var retorno: Any? = null

		if (!estaVazia()) {
			retorno = ponteiroInicio?.dado
			ponteiroInicio = ponteiroInicio?.proximo
			if (!estaVazia()) {
                ponteiroInicio?.anterior = null
            } else {
                ponteiroFim = null
            }	
            quantidade--
		} else {
			println("Fila Vazia!")
		}

		return retorno
	}
	
	override fun frente(): Any? {
		var retorno: Any? = null

		if (!estaVazia())
			retorno = ponteiroInicio?.dado
		else
			println("Fila Vazia!")
		
		return retorno
	}

    override fun atualizar(dado: Any?) {
		if (!estaVazia()) {
            ponteiroInicio?.dado = dado 
        } else {
            println("Fila Vazia!")
        }
	}	

    override fun estaCheia(): Boolean {
        return quantidade == tamanho
    }

    override fun estaVazia():Boolean {
        return quantidade == 0
    }

    override fun imprimir(): String {
		var resultado = "["
        var aux = ponteiroInicio

		for (i in 0 until quantidade) {
			resultado += "${aux?.dado}"

			if (i != quantidade-1) {
                resultado += ","
            }

			aux = aux?.proximo
		}
		return "$resultado]"
	}
}