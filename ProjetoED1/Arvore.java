class Arvore<T extends Comparable<T>> {
    private class Node {
        T data;
        Node left, right;

        Node(T data) {
            this.data = data;
        }
    }

    private Node raiz;

    public void inserir(T data) {
        raiz = inserirRecursivo(raiz, data);
    }

    private Node inserirRecursivo(Node atual, T data) {

        if (atual == null) return new Node(data);
        if (data.compareTo(atual.data) < 0) atual.left = inserirRecursivo(atual.left, data);
        else if (data.compareTo(atual.data) > 0) atual.right = inserirRecursivo(atual.right, data);
        return atual;
    }

    public boolean buscar(T data) {
        return buscarRecursivo(raiz, data);
    }

    private boolean buscarRecursivo(Node atual, T data) {
        if (atual == null) return false;
        if (data.equals(atual.data)) return true;
        return data.compareTo(atual.data) < 0 ? buscarRecursivo(atual.left, data) : buscarRecursivo(atual.right, data);
    }
    public boolean remover(T data) {
        if (raiz == null) return false;
        raiz = removerRecursivo(raiz, data);
        return true;
    }
    
    private Node removerRecursivo(Node atual, T data) {
        if (atual == null) return null;
        if (data.compareTo(atual.data) < 0) {
            atual.left = removerRecursivo(atual.left, data);
        } else if (data.compareTo(atual.data) > 0) {
            atual.right = removerRecursivo(atual.right, data);
        } else {
            if (atual.left == null) return atual.right;
            if (atual.right == null) return atual.left;
            atual.data = menorValor(atual.right);
            atual.right = removerRecursivo(atual.right, atual.data);
        }
        return atual;
    }
    
    private T menorValor(Node atual) {
        T menor = atual.data;
        while (atual.left != null) {
            atual = atual.left;
            menor = atual.data;
        }
        return menor;
    }
    private T encontrarMenor(Node atual) {
        return atual.left == null ? atual.data : encontrarMenor(atual.left);
    }
    
    
}
