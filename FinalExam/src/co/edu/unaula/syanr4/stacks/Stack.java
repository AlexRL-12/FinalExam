package co.edu.unaula.syanr4.stacks;

import co.edu.unaula.syanr4.lists.LinkedList;
import co.edu.unaula.syanr4.nodes.Node;
import co.edu.unaula.syanr4.utils.Menu;

import java.util.Scanner;

public class Stack<T> {

    Scanner scanner = new Scanner(System.in);
    Menu menu = new Menu();

    private Node<T> topElement;
    private int size;

    public Stack(){
        size = -1;
    }

    private boolean isVoid(){ return size <= 0;}

    public void push (T data){
        Node<T> newNode = new Node<>(data);
        if (!isVoid()){
            newNode.setPointer(topElement);
        }
        topElement = newNode;
        size = size <= 0 ? 1 : size + 1;
    }

    public Stack pop(){
        if (isVoid()){
            System.out.println("\nThere aren't any node for delete");
            return deleteStack();
        }
        Node<T> aux = topElement;
        if (size == 1){
            if (deleteNodeFinal(aux)){
                topElement = null;
                size--;
                return deleteStack();
            }
        }
        if (!menu.createMenuDeleteNode()){
            return this;
        }
        topElement = topElement.getPointer();
        size--;
        return this;
    }

    private boolean deleteNodeFinal(Node<T> aux){
        boolean confirm = true;

        System.out.println("\nOnly there are this node");
        System.out.println(aux.getData());
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

    private Stack deleteStack() {
        Stack confirm = this;
        boolean controlWhile;
        do {
            controlWhile = false;
            System.out.println("Do you want delete this Stack:" +
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

    public void printList() {
        try {
            if (!isVoid()) {
                Node<T> aux = topElement;

                System.out.println("\nStack\n");

                for (int i = 0; i < size; i++) {
                    if (aux.getPointer() == null) {
                        System.out.println((i + 1) + ".) " + aux.getData() + " -> " + "null");
                    } else {
                        System.out.println((i + 1) + ".) " + aux.getData() + " -> " + aux.getPointer().getData());
                    }

                    aux = aux.getPointer();
                }
            }else{
                System.out.println("\n The list is void");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
