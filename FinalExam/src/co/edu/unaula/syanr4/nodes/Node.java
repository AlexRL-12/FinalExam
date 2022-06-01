package co.edu.unaula.syanr4.nodes;

public class Node<T> {

    private final T data;
    private Node<T> pointer;

    public Node(T data){
        this.data = data;
        this.pointer = null;
    }

    public T getData() {
        return data;
    }

    public Node<T> getPointer() {
        return pointer;
    }

    public void setPointer(Node<T> pointer) {
        this.pointer = pointer;
    }
}
