package DaniloMonteiro_ATV01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Run {

    public static void main(String[] args) throws FileNotFoundException, IOException {
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

            switch (conteudoLinha[0]) {
                case "arvore":
                    linha = buffer.readLine();
                    arvore.inserirArquivo();
                    while (linha != null) {
                        linha.split(";");
                        switch (conteudoLinha[0]) {
                            case "inserir":
                                info = conteudoLinha[1];
                                arvore.inserirObjeto(info);
                                break;
                            case "remover":
                                boolean confirm;
                                info = conteudoLinha[1];
                                confirm = arvore.remover(info);
                                if (confirm == false) {
                                    System.out.println("Objeto não encontrado");
                                }
                                break;
                            case "buscar":
                                String teste;
                                info = conteudoLinha[1];
                                teste = (String) arvore.buscar(info);
                                if (teste == null) {
                                    System.out.println("Objeto não encontrado!");
                                }
                                break;
                            case "imprimir":
                                arvore.imprimir();
                                break;
                        }
                    }
                    break;
                case "lista":
                    break;
                case "pilha":
                    break;
                case "fila":
                    break;
            }

        } catch (NumberFormatException e) {
            System.out.println(e);
        }
    }
}
