package co.edu.unaula.syanr4.lists;

import co.edu.unaula.syanr4.nodes.Node;
import co.edu.unaula.syanr4.utils.Menu;

import java.util.Scanner;

public class LinkedList<T> {

    Menu menu = new Menu();
    Scanner scanner = new Scanner(System.in);

    private Node<T> firstNode;
    private Node<T> lastNode;
    private int size;

    public LinkedList(){
        // Not initialised firstNode and lastNode because default Object value is null
        size = -1;
    }

    public boolean isVoid(){
        if (size <= 0){
            return true;
        }
        return false;
    }

    public LinkedList push(T data){
        Node<T> newNode = new Node<>(data);

        if (isVoid()){
            firstNode = newNode;
        }
        else{
            lastNode.setPointer(newNode);
        }
        lastNode = newNode;
        size = size <= 0 ? 1 : (size+1);
        return  this;
    }

    public LinkedList pop(){
        if (isVoid()){
            System.out.println("\nThere aren't any node for delete");
            return deleteList();
        }
        Node<T> aux = firstNode;
        if (size == 1){
            if (deleteNodeFinal(aux)){
                lastNode = null;
                firstNode = null;
                size--;
                return deleteList();
            }
        }
        if (!menu.createMenuDeleteNode()){
            return this;
        }
        for (int i = 0; i < size; i++) {
            if (aux.getPointer() == lastNode){
                lastNode = aux;
                lastNode.setPointer(null);
                size--;
            }
            aux = aux.getPointer();
        }
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

    private LinkedList deleteList() {
        LinkedList confirm = this;
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

    public void printList() {
        try {
            if (!isVoid()) {
                Node<T> aux = firstNode;

                System.out.println("\nLinked List\n");

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
