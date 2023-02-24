package DaniloMonteiro_ATV01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class FilaDinamica implements AED2 {

    private class No {

        Object elemento;
        No proximo;
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
        nodo.elemento = o;
        nodo.proximo = null;
        if (fim != null) {
            fim.proximo = nodo;
        }
        fim = nodo;
        if (inicio == null) {
            inicio = nodo;
        }
        tamanho++;
        return true;
    }

    @Override
    public boolean remover(Object o) {
        No nodo = new No();
        nodo = inicio;
        inicio = inicio.proximo;
        o = nodo.elemento;
        nodo = null;
        if (inicio == null) {
            fim = null;
        }
        tamanho--;
        return true;

    }

    @Override
    public Object buscar(Object o) {
        if (inicio != null) {
            return inicio.elemento;
        }
        return null;
    }

    @Override
    public void imprimir() {
        if (inicio != null) {
            System.out.println(inicio.elemento);
        }

    }

}
