package DaniloMonteiro_ATV01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ListaEncadeadaDupla implements AED2 {

    private class No {

        public Object elemento;
        public No proximo;
        public No anterior;
    }

    No inicio;
    No fim;
    int tamanho;

    @Override
    public boolean inserirArquivo() {
        try {
            FileInputStream arquivo = new FileInputStream(".//src//entrada//exec.txt");
            InputStreamReader input = new InputStreamReader(arquivo);
            BufferedReader ler = new BufferedReader(input);

            String linha = ler.readLine();
            while (linha != null) {
                linha = ler.readLine();
            }
        } catch (Exception e) {
            System.out.println("Erro! " + e);
            return false;
        }
        return true;
    }

    @Override
    public boolean inserirObjeto(Object o) {
        No nodo = new No();
        if (tamanho == 0) { // inserindo no início
            nodo.elemento = o;
            nodo.anterior = null;
            nodo.proximo = inicio;
            inicio = nodo;
            if (inicio != null) {
                inicio.anterior = nodo;
            }
            if (tamanho == 0) {
                fim = inicio;
            }
        } else { // inserindo no final
            nodo.elemento = o;
            nodo.proximo = null;
            nodo.anterior = fim;
            if (fim != null) {
                fim.proximo = nodo;
            }
            fim = nodo;
        }
        tamanho++;
        return true;
    }

    @Override
    public boolean remover(Object o) {
        No nodo = inicio, local = inicio;
        Object n;
        int posicao = 1;
        for (int i = 0; i < tamanho; i++) { // encontra a posição do elemento para remoção
            n = nodo.elemento;
            if (n == o) {
                break;
            }
            nodo = nodo.proximo;
            posicao++;
        }
        if (posicao == 1) { // removendo no início
            inicio = inicio.proximo;
            if (inicio != null) {
                inicio.anterior = null;
            } else {
                fim = null;
            }
        }
        if (posicao == (tamanho - 1)) { // removendo no fim
            fim = fim.anterior;
            if (fim != null) {
                fim.proximo = null;
            }
        }
        tamanho--;
        return true;
    }

    @Override
    public Object buscar(Object o) { // buscando um elemento
        No nodo = inicio;
        Object n;
        for (int i = 0; i < tamanho; i++) {
            n = nodo.elemento;
            if (n == o) {
                return n;
            }
            nodo = nodo.proximo;
        }
        return null;
    }

    @Override
    public void imprimir() { // imprimindo os elementos
        No nodo = inicio;
        for (int i = 0; i < tamanho; i++) {
            System.out.println(nodo.elemento + " ");
            nodo = nodo.proximo;
        }
    }
}
