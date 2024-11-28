import java.util.*;

// Classe para Árvore Binária de Busca
class Node<T extends Comparable<T>> {
    T key;
    Node<T> left, right;

    public Node(T item) {
        key = item;
        left = right = null;
    }
}

