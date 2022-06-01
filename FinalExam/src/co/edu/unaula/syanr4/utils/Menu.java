package co.edu.unaula.syanr4.utils;

import co.edu.unaula.syanr4.lists.LinkedList;

import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);

    public boolean createMenuDeleteNode(){
        boolean confirm = false;
        boolean controlWhile;
        do {
            controlWhile = false;
            System.out.println("Do you want delete this node:" +
                    "\n1- Yes" +
                    "\n2- No");
            String decision = scanner.nextLine();
            switch (decision) {
                case "1":
                    confirm = true;
                    break;
                case "2":
                    confirm = false;
                    break;
                default:
                    System.out.println("Select a correct option");
                    controlWhile = true;
                    break;
            }
        } while (controlWhile);
        return confirm;
    }

    public boolean isfirstOrLast(String name) {
        boolean confirm = false;
        boolean controlWhile;
        do {
            controlWhile = false;
            System.out.println("How you want to " + name +
                    "\n1- " + name + " First" +
                    "\n2- " + name + " Last");
            String decision = scanner.nextLine();
            switch (decision) {
                case "1":
                    confirm = true;
                    break;
                case "2":
                    confirm = false;
                    break;
                default:
                    System.out.println("Select a correct option");
                    controlWhile = true;
                    break;
            }
        } while (controlWhile);
        return confirm;
    }

    public String getUserResponseMainMenu() {
        System.out.println("\nSelect a one option" +
                "\n1- Linked Lists" +
                "\n2- Double Linked Lists" +
                "\n3- Circular Lists" +
                "\n4- Staks" +
                "\n5- Queue" +
                "\n6- Recursion" +
                "\n7- Binary trees" +
                "\n8- Graphs" +
                "\n9- Exit");
        String decision = scanner.nextLine();
        return decision;
    }

    public boolean addOther() {
        boolean confirm = false;
        boolean controlWhile;
        do {
            controlWhile = false;
            System.out.println("Do you want add other Node "+
                    "\n1- Yes" +
                    "\n2- No");
            String decision = scanner.nextLine();
            switch (decision) {
                case "1":
                    confirm = true;
                    break;
                case "2":
                    confirm = false;
                    break;
                default:
                    System.out.println("Select a correct option");
                    controlWhile = true;
                    break;
            }
        } while (controlWhile);
        return confirm;
    }

    public String getData(){
        System.out.println("\nWrite the data");
        String data = scanner.nextLine();
        return  data;
    }

    public String getOptionList(String name){
        System.out.println("\nMenu " + name +
                "\n1- Create/Add Node" +
                "\n2- Delete Node" +
                "\n3- Print List" +
                "\n4- Back to main menu");
        String decision = scanner.nextLine();
        return decision;
    }

    public String getOptionStack(){
        System.out.println("\nMenu Stack" +
                "\n1- Stack" +
                "\n2- Unstack" +
                "\n3- Print Stack" +
                "\n4- Back to main menu");
        String decision = scanner.nextLine();
        return decision;
    }

    public String getOptionQueue(){
        System.out.println("\nMenu Queue" +
                "\n1- Enqueue" +
                "\n2- Dequeue" +
                "\n3- Print Queue" +
                "\n4- Back to main menu");
        String decision = scanner.nextLine();
        return decision;
    }

    public String getOptionRecurion(){
        System.out.println("\nMenu Recursion" +
                "\n1- Calculate Factorial" +
                "\n2- Calculate Potency" +
                "\n3- Back to main menu");
        String decision = scanner.nextLine();
        return decision;
    }

    public int getNumber(){
        System.out.println("\nPlease write a number for calculate:");
        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }

    public int getPotency(){
        System.out.println("Please write the potency:");
        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }

    public boolean calculateOther(String name){
        boolean confirm = false;
        boolean controlWhile;
        do {
            controlWhile = false;
            System.out.println("\nDo you want calculate other "+ name + ":" +
                    "\n1- Yes" +
                    "\n2- No");
            String decision = scanner.nextLine();
            switch (decision) {
                case "1":
                    confirm = true;
                    break;
                case "2":
                    confirm = false;
                    break;
                default:
                    System.out.println("Select a correct option");
                    controlWhile = true;
                    break;
            }
        } while (controlWhile);
        return confirm;
    }

    public String getOptionBinaryTree(){
        System.out.println("\nMenu Binary Tree" +
                "\n1- Create" +
                "\n2- Delete" +
                "\n3- Print" +
                "\n4- Back to main menu");
        String decision = scanner.nextLine();
        return decision;
    }

    public int getValue(String name){
        System.out.println("\nPlease write a number " + name);
        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }

    public String getOptionGraph() {
        System.out.println("\nMenu Graphs" +
                "\n1- Create" +
                "\n2- Print" +
                "\n3- Back to main menu");
        String decision = scanner.nextLine();
        return decision;
    }

    public String getOptionGraphCreate() {
        System.out.println("Select a option: " +
                "\n 1. Add a Department" +
                "\n 2. Add a Edge" +
                "\n 3. Back to Menu Graphs");
        String decision = scanner.nextLine();
        return decision;
    }
}
