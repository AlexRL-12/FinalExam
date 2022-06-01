package co.edu.unaula.syanr4.nodes;

public class DoubleLinkedNode<T> {

    private DoubleLinkedNode<T> previousElement;
    private T data;
    private DoubleLinkedNode<T> nextElement;

    public DoubleLinkedNode(T data){
        this.data = data;
        this.previousElement = null;
        this.nextElement = null;
    }

    public DoubleLinkedNode<T> getPreviousElement() {
        return previousElement;
    }

    public void setPreviousElement(DoubleLinkedNode<T> previousElement) {
        this.previousElement = previousElement;
    }

    public T getData() {
        return data;
    }

    public DoubleLinkedNode<T> getNextElement() {
        return nextElement;
    }

    public void setNextElement(DoubleLinkedNode<T> nextElement) {
        this.nextElement = nextElement;
    }

}
