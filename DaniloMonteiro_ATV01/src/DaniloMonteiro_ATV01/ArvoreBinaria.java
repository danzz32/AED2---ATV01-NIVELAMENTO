package DaniloMonteiro_ATV01;

import util.AED2;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ArvoreBinaria implements AED2 {

    private No raiz;

    private class No {

        String elemento;
        No esq;
        No dir;

        public No(String elemento) {
            this.elemento = elemento;
            this.esq = null;
            this.dir = null;
        }
    }

    public ArvoreBinaria() {
        raiz = null;
    }

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
        raiz = inserir(raiz, (String) o);
        if (raiz == null) {
            return false;
        }
        return true;
    }

    private No inserir(No nodo, String elemento) {
        if (nodo == null) {
            nodo = new No(elemento);
        } else if (elemento.length() <= nodo.elemento.length()) {
            nodo.esq = inserir(nodo.esq, elemento);
        } else if (elemento.length() > nodo.elemento.length()) {
            nodo.dir = inserir(nodo.dir, elemento);
        } else {
            return null;
        }
        return nodo;
    }

    @Override
    public boolean remover(Object o) {
        raiz = removerObjeto(raiz, (String) o);
        return raiz != null;

    }

    private No removerObjeto(No nodo, String elemento) {
        if (nodo == null) {
            return null;
        } else if (elemento.length() <= nodo.elemento.length()) {
            nodo.esq = removerObjeto(nodo.esq, elemento);
        } else if (elemento.length() > nodo.elemento.length()) {
            nodo.dir = removerObjeto(nodo.dir, elemento);
        } else {
            if (nodo.esq == null) {
                return nodo.dir;
            } else if (nodo.dir == null) {
                return nodo.esq;
            } else {
                nodo.elemento = (String) buscarMenor(nodo.dir);
                nodo.dir = removerObjeto(nodo.dir, nodo.elemento);
            }
        }
        return nodo;
    }

    private Object buscarMenor(No nodo) {
        while (nodo.esq != null) {
            nodo = nodo.esq;
        }
        return nodo.elemento;
    }

    @Override
    public Object buscar(Object o) {
        Object teste = buscaElemento(raiz, (String) o);
        if (teste != null) {
            return teste;
        } else {
            return null;
        }
    }

    private Object buscaElemento(No nodo, String elemento) {
        if (nodo == null) {
            return null;
        } else if (elemento.length() <= nodo.elemento.length()) {
            return buscaElemento(nodo.esq, elemento);
        } else if (elemento.length() > nodo.elemento.length()) {
            return buscaElemento(nodo.dir, elemento);
        } else {
            return elemento;
        }
    }

    @Override
    public void imprimir() {
        imprimeArvore(raiz);
    }

    private void imprimeArvore(No nodo) {
        if (nodo != null) {
            imprimeArvore(nodo.esq);
            System.out.print(nodo.elemento + " ");
            imprimeArvore(nodo.dir);
        }
    }
}
