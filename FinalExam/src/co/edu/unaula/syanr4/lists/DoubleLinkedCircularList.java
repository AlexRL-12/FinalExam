package co.edu.unaula.syanr4.lists;


import co.edu.unaula.syanr4.nodes.DoubleLinkedNode;
import co.edu.unaula.syanr4.utils.Menu;

import java.util.Scanner;

public class DoubleLinkedCircularList<T> {

    Menu menu = new Menu();
    Scanner scanner = new Scanner(System.in);

    private DoubleLinkedNode<T> tail;
    private DoubleLinkedNode<T> head;
    private int size;

    public DoubleLinkedCircularList(){
        // Not initialised firstNode and lastNode because default Object value is null
        this.size = -1;
    }

    public boolean isVoid(){
        if (size <= 0){
            return true;
        }
        return false;
    }

    public DoubleLinkedCircularList push(T data){

        try {
            DoubleLinkedNode<T> newNode = new DoubleLinkedNode<>(data);

            if (isVoid()) {
                tail = newNode;
                head = newNode;
            } else {
                if (menu.isfirstOrLast("add")) {
                    newNode.setNextElement(tail);
                    tail.setPreviousElement(newNode);
                    tail = newNode;
                } else {
                    newNode.setPreviousElement(head);
                    head.setNextElement(newNode);
                    head = newNode;
                }
            }
            tail.setPreviousElement(head);
            head.setNextElement(tail);
            size = size <= 0 ? 1 : (size+1);
            return this;
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public DoubleLinkedCircularList pop(){
        if (size == 0){
            System.out.println("\nThere aren't any node for delete");
            return deleteList();
        }
        if (size == 1){
            if (deleteNodeFinal()){
                tail = null;
                head = null;
                size--;
                return deleteList();
            }
            else {
                return this;
            }
        }
        boolean popFirst = menu.isfirstOrLast("delete");
        if (!menu.createMenuDeleteNode()){
            return this;
        }
        if (popFirst){
            tail = tail.getNextElement();
        }
        else {
            head = head.getPreviousElement();
        }
        tail.setPreviousElement(head);
        head.setNextElement(tail);
        size--;
        return this;
    }

    private boolean deleteNodeFinal(){
        boolean confirm = true;

        System.out.println("\nOnly there are this node");
        System.out.println(head.getData());
        System.out.println("\nDo you want to delete this?" +
                "\n1- Yes" +
                "\n2- No");
        String decision = scanner.nextLine();
        switch (decision){
            case "1":
                confirm = true;
                break;
            case "2":
                confirm = false;
                break;
            default:
                System.out.println("Select a correct option");
                break;
        }
        return confirm;
    }

    private DoubleLinkedCircularList deleteList() {
        DoubleLinkedCircularList confirm = this;
        boolean controlWhile;
        do {
            controlWhile = false;
            System.out.println("Do you want delete this List:" +
                    "\n1- Yes" +
                    "\n2- No");
            int decision = scanner.nextInt();
            switch (decision) {
                case 1:
                    confirm = null;
                    break;
                case 2:
                    confirm = this;
                    break;
                default:
                    System.out.println("Select a correct option");
                    controlWhile = true;
                    break;
            }
        } while (controlWhile);
        return confirm;
    }

    public void printList(){
        try {
            if (!isVoid()) {
                boolean printRight = menu.isfirstOrLast("print");
                DoubleLinkedNode<T> aux;
                if (printRight) {
                    System.out.println("\nDouble Linked List of left to right\n");
                    aux = tail;
                    for (int i = 0; i < size; i++) {
                        System.out.println(aux.getPreviousElement().getData() + " <- " + aux.getData() + " -> " + aux.getNextElement().getData());
                        aux = aux.getNextElement();
                    }
                } else {
                    System.out.println("\nDouble Linked List of right to left\n");
                    aux = head;
                    for (int i = 0; i < size; i++) {
                        System.out.println(aux.getNextElement().getData() + " <- " + aux.getData() + " -> " + aux.getPreviousElement().getData());
                        aux = aux.getPreviousElement();
                    }
                }
            }else{
                System.out.println("\nThe list is void");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
