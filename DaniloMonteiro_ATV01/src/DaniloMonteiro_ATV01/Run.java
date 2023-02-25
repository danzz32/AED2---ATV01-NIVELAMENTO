package DaniloMonteiro_ATV01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Run {

    public static void main(String[] args) {
        String info, linha;

        ArvoreBinaria arvore = new ArvoreBinaria();
        ListaEncadeadaDupla lista = new ListaEncadeadaDupla();
        PilhaDinamica pilha = new PilhaDinamica();
        FilaDinamica fila = new FilaDinamica();

        try {
            FileInputStream arquivo = new FileInputStream(".//src//entrada//exec.txt");
            InputStreamReader input = new InputStreamReader(arquivo);
            BufferedReader buffer = new BufferedReader(input);

            linha = buffer.readLine();
            String[] conteudoLinha = linha.split(";");
            //Switch para determinar qual estrutura será instanciada na leitura do arquivo
            switch (conteudoLinha[0]) {
                case "arvore":
                    linha = buffer.readLine();
                    arvore.inserirArquivo();
                    while (linha != null) {
                        conteudoLinha = linha.split(";");
                        switch (conteudoLinha[0]) { // Switch para determinar o método a ser executado
                            case "inserir":
                                info = conteudoLinha[1];
                                if (arvore.inserirObjeto(info) == true) {
                                    System.out.println("Objeto inserido!");
                                }
                                break;
                            case "remover":
                                info = conteudoLinha[0];
                                if (arvore.remover(info) == false) {
                                    System.out.println("Não foi possível remover o objeto!");
                                }
                                break;
                            case "buscar":
                                info = conteudoLinha[0];
                                if (arvore.buscar(info) == null) {
                                    System.out.println("Objeto não encontrado!");
                                }
                                break;
                            case "imprimir":
                                arvore.imprimir();
                                break;
                        }
                        linha = buffer.readLine();
                    }
                    break;
                case "lista":
                    linha = buffer.readLine();
                    lista.inserirArquivo();
                    while (linha != null) {
                        conteudoLinha = linha.split(";");
                        switch (conteudoLinha[0]) {
                            case "inserir":
                                info = conteudoLinha[1];
                                if (lista.inserirObjeto(info) == true) {
                                    System.out.println("Objeto inserido!");
                                }
                                break;
                            case "remover":
                                info = conteudoLinha[0];
                                if (lista.remover(info) == false) {
                                    System.out.println("Objeto não encontrado!");
                                }
                                break;
                            case "buscar":
                                info = conteudoLinha[0];
                                if (lista.buscar(info) == null) {
                                    System.out.println("Objeto não encontrado!");
                                }
                                break;
                            case "imprimir":
                                lista.imprimir();
                                break;
                        }
                        linha = buffer.readLine();
                    }
                    break;
                case "pilha":
                    linha = buffer.readLine();
                    pilha.inserirArquivo();
                    while (linha != null) {
                        conteudoLinha = linha.split(";");
                        switch (conteudoLinha[0]) {
                            case "inserir":
                                info = conteudoLinha[1];
                                if (pilha.inserirObjeto(info) == true) {
                                    System.out.println("Objeto inserido!");
                                }
                                break;
                            case "remover":
                                info = conteudoLinha[0];
                                if (pilha.remover(info) == false) {
                                    System.out.println("Objeto não encontrado!");
                                }
                                break;
                            case "buscar":
                                info = conteudoLinha[0];
                                if (pilha.buscar(info) == null) {
                                    System.out.println("Objeto não encontrado!");
                                }
                                break;
                            case "imprimir":
                                pilha.imprimir();
                                break;
                        }
                        linha = buffer.readLine();
                    }
                    break;
                case "fila":
                    linha = buffer.readLine();
                    fila.inserirArquivo();
                    while (linha != null) {
                        conteudoLinha = linha.split(";");
                        switch (conteudoLinha[0]) {
                            case "inserir":
                                info = conteudoLinha[1];
                                if (fila.inserirObjeto(info) == true) {
                                    System.out.println("Objeto inserido!");
                                }
                                break;
                            case "remover":
                                info = conteudoLinha[0];
                                if (fila.remover(info) == false) {
                                    System.out.println("Objeto não encontrado!");
                                }
                                break;
                            case "buscar":
                                info = conteudoLinha[0];
                                if (fila.buscar(info) == null) {
                                    System.out.println("Objeto não encontrado!");
                                }
                                break;
                            case "imprimir":
                                fila.imprimir();
                                break;
                        }
                        linha = buffer.readLine();
                    }
                    break;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}