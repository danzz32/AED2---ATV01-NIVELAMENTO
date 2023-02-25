package DaniloMonteiro_ATV01;

import util.AED2;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class PilhaDinamica implements AED2 {

    private class NoPilha {

        Object elemento;
        NoPilha proximo;
    }

    NoPilha topo;
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
        NoPilha nodo = new NoPilha();
        nodo.elemento = o;
        nodo.proximo = null;
        topo = nodo;
        tamanho++;
        return true;
    }

    @Override
    public boolean remover(Object o) {
        if (topo == null) {
            return false;
        } else {
            NoPilha nodo = new NoPilha();
            nodo = topo;
            topo = topo.proximo;
            nodo.elemento = o;
            nodo = null;
            tamanho--;
            return true;
        }
    }

    @Override
    public Object buscar(Object o) {
        if (topo != null) {
            return topo.elemento;
        } else {
            return null;
        }
    }

    @Override
    public void imprimir() {
        if (topo != null) {
            System.out.println(topo.elemento);
        }
    }
}
