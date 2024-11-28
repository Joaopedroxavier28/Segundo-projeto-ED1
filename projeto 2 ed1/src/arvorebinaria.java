class arvorebinaria<T extends Comparable<T>> {
    Node<T> raiz;

    arvorebinaria() {
        raiz = null;
    }

    void inserir(T key) {
        raiz = insertRec(raiz, key);
    }

    Node<T> insertRec(Node<T> raiz, T key) {
        if (raiz == null) {
            raiz = new Node<>(key);
            return raiz;
        }
        if (key.compareTo(raiz.key) < 0)
            raiz.left = insertRec(raiz.left, key);
        else if (key.compareTo(raiz.key) > 0)
            raiz.right = insertRec(raiz.right, key);
        return raiz;
    }

    boolean search(T key) {
        return searchRec(raiz, key);
    }

    boolean searchRec(Node<T> raiz, T key) {
        if (raiz == null)
            return false;
        if (key.compareTo(raiz.key) == 0)
            return true;
        if (key.compareTo(raiz.key) < 0)
            return searchRec(raiz.left, key);
        return searchRec(raiz.right, key);
    }
}