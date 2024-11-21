class Fila<T> {
    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node inicio, fim;

    public void enqueue(T data) {
        Node novo = new Node(data);
        if (fim != null) fim.next = novo;
        fim = novo;
        if (inicio == null) inicio = novo;
    }

    public T dequeue() {
        if (isEmpty()) throw new RuntimeException("Fila vazia!");
        T data = inicio.data;
        inicio = inicio.next;
        if (inicio == null) fim = null;
        return data;
    }

    public T peek() {
        if (isEmpty()) throw new RuntimeException("Fila vazia!");
        return inicio.data;
    }

    public boolean isEmpty() {
        return inicio == null;
    }
}
