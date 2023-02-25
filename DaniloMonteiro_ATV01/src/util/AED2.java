package util;

public interface AED2 {

    public boolean inserirArquivo();
//responsavel por lê os dados de um arquivo e adicionar na estrutura

    public boolean inserirObjeto(Object o);
//responsável por inserir o objeto passado por parâmetro na estrutura

    public boolean remover(Object o);
//responsável por excluir o objeto passado por parâmetro da estrutura

    public Object buscar(Object o);
//responsável por pesquisar e retornar o objeto passado por parâmetro

    public void imprimir();
//responsável por imprimir os objetos presentes na estrutura
}
