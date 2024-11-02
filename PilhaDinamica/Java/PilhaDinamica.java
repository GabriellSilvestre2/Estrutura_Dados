package src.PilhaDinamica.Java;

public class PilhaDinamica<T> {
    private T[] dados;
    private int ponteiroFim;

    public PilhaDinamica(){
        dados = (T[]) new Object[4];
        ponteiroFim = -1;
    }

    public boolean estaCheia(){
        return ponteiroFim == (dados.length-1);
    }

    public boolean estaVazia(){
        return ponteiroFim == -1;
    }

    private void redimencionar(){
        T[] novosDados = (T[]) new Object[dados.length*2];

        for (int i = 0; i <= ponteiroFim; i++) {
            novosDados[i] = dados[i];
        }

        dados = novosDados;
    }

    public void inserir(T dado){
        if (estaCheia()) redimencionar();
        ponteiroFim++;
        dados[ponteiroFim] = dado;
    }

    public T remover(){
        T retorno = null;

        if (!estaVazia()) {
            retorno = dados[ponteiroFim];
            dados[ponteiroFim] = null;
            ponteiroFim--;
        } else
            System.out.println("Pilha Vazia!");

        return retorno;
    }

    public T obterTopo(){
        T retorno = null;

        if (!estaVazia())
            retorno = dados[ponteiroFim];
        else
            System.out.println("Pilha Vazia!");

        return retorno;
    }

    public void imprimirPilha(){
        for (int i = ponteiroFim; i >= 0; i--) {
            System.out.println(dados[i]);
        }
    }

    public int tamanhoPilha(){
        return ponteiroFim+1;
    }
}