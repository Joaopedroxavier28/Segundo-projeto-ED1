class Pilha<T> {
    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node topo;

    public void push(T data) {
        Node novo = new Node(data);
        novo.next = topo;
        topo = novo;
    }

    public T pop() {
        if (isEmpty()) throw new RuntimeException("Pilha vazia!");
        T data = topo.data;
        topo = topo.next;
        return data;
    }

    public T peek() {
        if (isEmpty()) throw new RuntimeException("Pilha vazia!");
        return topo.data;
    }

    public boolean isEmpty() {
        return topo == null;
    }
}

