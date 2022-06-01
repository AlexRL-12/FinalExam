package co.edu.unaula.syanr4.lists;

import co.edu.unaula.syanr4.nodes.Node;
import co.edu.unaula.syanr4.utils.Menu;

import java.util.Scanner;

public class CircularList<T> {

    Scanner scanner = new Scanner(System.in);
    Menu menu = new Menu();

    private Node<T> firstNode;
    private Node<T> lastNode;
    private int size;

    public CircularList(){
        // Not initialised firstNode and lastNode because default Object value is null
        size = -1;
    }

    public CircularList push(T data){
        Node<T> newNode = new Node<>(data);
        if (isVoid()){
            firstNode = newNode;
            lastNode = newNode;
        }
        lastNode.setPointer(newNode);
        newNode.setPointer(firstNode);
        lastNode = newNode;
        size = size <= 0 ? 1 : (size+1);
        return this;
    }

    public CircularList pop(){
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
                lastNode.setPointer(firstNode);
            }
            aux = aux.getPointer();
        }
        size--;
        return this;
    }

    public void printList(){
        Node<T> aux = firstNode;

        System.out.println("\nCircular List\n");

        for (int i = 0; i < size; i++) {
            if (aux.getPointer() == null){
                System.out.println((i+1) + ".) " + aux.getData() + " -> " + "null");
            }
            else{
                System.out.println((i+1) + ".) " + aux.getData() + " -> " + aux.getPointer().getData());
            }

            aux = aux.getPointer();
        }
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

    private CircularList deleteList() {
        CircularList confirm = this;
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

    private boolean isVoid() {
        if (size<=0){
            return true;
        }
        return false;
    }

}
