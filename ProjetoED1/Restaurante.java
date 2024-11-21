class Restaurante {
    Pilha<String> historicoPedidos = new Pilha<>();
    Fila<String> filaPedidos = new Fila<>();
    Arvore<String> menu = new Arvore<>();

    public void adicionarPedido(String pedido) {
        filaPedidos.enqueue(pedido);
    }

    public void modificarPedido(String acao) {
        historicoPedidos.push(acao);
    }

    public void adicionarAoMenu(String item) {
        menu.inserir(item);
    }
}
