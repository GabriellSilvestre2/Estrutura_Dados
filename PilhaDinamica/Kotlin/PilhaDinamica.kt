package src.PilhaDinamica.Kotlin

class PilhaDinamica<T> {
    private var dados: Array<Any?> = arrayOfNulls(10)
    private var ponteiroFim = -1

    fun estaCheia(): Boolean{
        return ponteiroFim == dados.size-1
    }

    fun estaVazia(): Boolean{
        return ponteiroFim == -1
    }

    fun redimencionar(){
        var novosDados: Array<Any?> = arrayOfNulls(dados.size*2)

        for (i in 0 .. ponteiroFim) {
            novosDados[i] = dados[i]
        }

        dados = novosDados
    }

    fun tamanhoPilha(): Int{
        return ponteiroFim+1
    }

    fun inserir(dado: T){
        if (estaCheia()) redimencionar()
        ponteiroFim++
        dados[ponteiroFim] = dado
    }

    fun remover(): T?{
        var retorno: T? = null

        if (!estaVazia()){
            retorno = dados[ponteiroFim] as T?
            dados[ponteiroFim] = null
            ponteiroFim--
        } else
            println("Pilha Vazia!")

        return retorno
    }

    fun obterTopo(): T?{
        var retorno: T? = null

        if (!estaVazia()){
            retorno = dados[ponteiroFim] as T?
        } else
            println("Pilha Vazia!")

        return retorno
    }

    fun imprimirPilha(){
        for (i in ponteiroFim downTo 0){
            println(dados[i])
        }
    }
}