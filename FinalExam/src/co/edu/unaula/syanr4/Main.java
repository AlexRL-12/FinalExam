package co.edu.unaula.syanr4;

import co.edu.unaula.syanr4.graphs.Graph;
import co.edu.unaula.syanr4.lists.DoubleLinkedCircularList;
import co.edu.unaula.syanr4.lists.DoubleLinkedList;
import co.edu.unaula.syanr4.lists.LinkedList;
import co.edu.unaula.syanr4.queue.Queue;
import co.edu.unaula.syanr4.recursion.Recursion;
import co.edu.unaula.syanr4.stacks.Stack;
import co.edu.unaula.syanr4.trees.BinaryTrees;

import co.edu.unaula.syanr4.utils.Menu;

import java.util.Scanner;

public class Main {

    LinkedList<Object> linkedList;
    DoubleLinkedList<Object> dLinkedList;
    DoubleLinkedCircularList<Object> circularList;
    Stack<Object> stack;
    Queue<Object> queue;
    Recursion recursion;
    BinaryTrees binaryTree;
    Graph graph;
    Scanner scanner = new Scanner(System.in);

    Menu menu = new Menu();

    int sizeDepa = 0;

    public static void main(String[] args) {
        try{
            Main main = new Main();
            main.createMainMenu();
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw e;
        }

    }

    public void createMainMenu(){
        String userResponse;
        boolean isRunning = true;

        System.out.println("\nWelcome to this program, where you can interact with various data structures");

        while (isRunning){

            userResponse = menu.getUserResponseMainMenu();

            switch (userResponse) {
                case "1":
                    createMenuLinkedList();
                    break;
                case "2":
                    createMenuDoubleLinkedList();
                    break;
                case "3":
                    createMenuCircularList();
                    break;
                case "4":
                    createMenuStack();
                    break;
                case "5":
                    createMenuQueue();
                    break;
                case "6":
                    createMenuRecursion();
                    break;
                case "7":
                    createMenuBinaryTree();
                    break;
                case "8":
                    createMenuGraph();
                    break;
                case "9":
                    isRunning = false;
                    break;
                default:
                    System.out.println("\nSelect a correct option");
                    break;
            }
        }
    }

    public void createMenuLinkedList(){
        String userResponse;
        boolean isRunning = true;

        while (isRunning){

            userResponse =menu.getOptionList("Linked List");

            switch (userResponse) {
                case "1":
                    createLinkedList();
                    do{
                        linkedList.push(menu.getData());
                    }while (menu.addOther());
                    break;
                case "2":
                    if (existLinkedList()){
                        linkedList = linkedList.pop();
                        if (!existLinkedList()) {
                            System.out.println("\nThe list was delete succefully");
                        }
                    }
                    else {
                        System.out.println("\nThere aren't any list");
                    }
                    break;
                case "3":
                    if (existLinkedList()){
                        linkedList.printList();
                    }
                    else {
                        System.out.println("\nThere aren't any list");
                    }
                    break;
                case "4":
                    isRunning = false;
                    break;
                default:
                    System.out.println("\nSelect a correct option");
                    break;
            }
        }
    }

    public boolean existLinkedList() {
        return !(linkedList == null);
    }

    public void createLinkedList() {
        if (linkedList == null){
            linkedList = new LinkedList<>();
        }
    }

    public void createMenuDoubleLinkedList(){
        String userResponse;
        boolean isRunning = true;

        while (isRunning){

            userResponse = menu.getOptionList("Double Linked List");

            switch (userResponse) {
                case "1":
                    createDoubleLinkedList();
                    do {
                        dLinkedList.push(menu.getData());
                    }while (menu.addOther());
                    break;
                case "2":
                    if (existDoubleLinkedList()){
                        dLinkedList = dLinkedList.pop();
                        if (!existDoubleLinkedList()) {
                            System.out.println("\nThe list was delete succefully");
                        }
                    }
                    else {
                        System.out.println("\nThere aren't any list");
                    }
                    break;
                case "3":
                    if (existDoubleLinkedList()){
                        dLinkedList.printList();
                    }
                    else {
                        System.out.println("\nThere aren't any list");
                    }
                    break;
                case "4":
                    isRunning = false;
                    break;
                default:
                    System.out.println("\nSelect a correct option");
                    break;
            }
        }
    }

    private boolean existDoubleLinkedList() {
        return !(dLinkedList == null);
    }

    private void createDoubleLinkedList() {
        if (dLinkedList == null){
            dLinkedList = new DoubleLinkedList<>();
        }
    }

    public void createMenuCircularList(){
        String userResponse;
        boolean isRunning = true;

        while (isRunning){

            userResponse = menu.getOptionList("Circular List");

            switch (userResponse) {
                case "1":
                    createCircularList();
                    do{
                        circularList.push(menu.getData());
                    }while (menu.addOther());
                    break;
                case "2":
                    if (existCircularList()){
                        circularList = circularList.pop();
                        if (!existCircularList()) {
                            System.out.println("\nThe list was delete succefully");
                        }
                    }
                    else {
                        System.out.println("\nThere aren't any list");
                    }
                    break;
                case "3":
                    if (existCircularList()){
                        circularList.printList();
                    }
                    else {
                        System.out.println("\nThere aren't any list");
                    }
                    break;
                case "4":
                    isRunning = false;
                    break;
                default:
                    System.out.println("\nSelect a correct option");
                    break;
            }
        }
    }

    private boolean existCircularList() {
        return !(circularList == null);
    }

    private void createCircularList() {
        if (circularList == null){
            circularList = new DoubleLinkedCircularList<>();
        }
    }

    public void createMenuStack(){
        String userResponse;
        boolean isRunning = true;

        while (isRunning){

            userResponse = menu.getOptionStack();

            switch (userResponse) {
                case "1":
                    createStack();
                    do{
                        stack.push(menu.getData());
                    }while (menu.addOther());
                    break;
                case "2":
                    if (existStack()){
                        stack = stack.pop();
                        if (!existStack()) {
                            System.out.println("\nThe list was delete succefully");
                        }
                    }
                    else {
                        System.out.println("\nThere aren't any list");
                    }
                    break;
                case "3":
                    if (existStack()){
                        stack.printList();
                    }
                    else {
                        System.out.println("\nThere aren't any list");
                    }
                    break;
                case "4":
                    isRunning = false;
                    break;
                default:
                    System.out.println("\nSelect a correct option");
                    break;
            }
        }
    }

    private boolean existStack() { return !(stack == null); }

    private void createStack() {
        if (stack == null){
            stack = new Stack<>();
        }
    }

    public void createMenuQueue(){
        String userResponse;
        boolean isRunning = true;

        while (isRunning){

            userResponse = menu.getOptionQueue();

            switch (userResponse) {
                case "1":
                    createQueue();
                    do{
                        queue.enqueue(menu.getData());
                    }while (menu.addOther());
                    break;
                case "2":
                    if (existQueue()){
                        queue = queue.dequeue();
                        if (!existQueue()) {
                            System.out.println("\nThe list was delete succefully");
                        }
                    }
                    else {
                        System.out.println("\nThere aren't any list");
                    }
                    break;
                case "3":
                    if (existQueue()){
                        queue.printQueue();
                    }
                    else {
                        System.out.println("\nThere aren't any list");
                    }
                    break;
                case "4":
                    isRunning = false;
                    break;
                default:
                    System.out.println("\nSelect a correct option");
                    break;
            }
        }
    }

    private boolean existQueue() { return !(queue == null); }

    private void createQueue() {
        if (queue == null){
            queue = new Queue<>();
        }
    }

    public void createMenuRecursion(){
        initRecursion();
        String userResponse;
        boolean isRunning = true;

        while (isRunning){

            userResponse = menu.getOptionRecurion();

            switch (userResponse) {
                case "1":
                    do {
                        double number = menu.getNumber();
                        double result = recursion.calculateFactorial(number);
                        System.out.println("The factorial of " + number + " is " + result);
                    }while (menu.calculateOther("factorial"));
                    break;
                case "2":
                    do {
                        double number = menu.getNumber();
                        int potency = menu.getPotency();
                        double result = recursion.calculatePotency(number, potency);
                        System.out.println("\nThe factorial of " + number + " is " + result);
                    }while (menu.calculateOther("potency"));
                    break;
                case "3":
                    isRunning = false;
                    break;
                default:
                    System.out.println("\nSelect a correct option");
                    break;
            }
        }
    }

    private void initRecursion() {
        if (recursion == null){
            recursion = new Recursion();
        }
    }

    public void createMenuBinaryTree(){
        String userResponse;
        boolean isRunning = true;

        while (isRunning){

            userResponse = menu.getOptionBinaryTree();

            switch (userResponse) {
                case "1":
                    do{
                        if (!existBinaryTree()){
                            createBinaryTree(menu.getValue(""));
                        }else {
                            binaryTree.addNode(menu.getValue(""));
                        }
                    }while (menu.addOther());
                    break;
                case "2":
                    if (existBinaryTree()){
                        binaryTree.removeNodes(menu.getValue("for delete"));
                    }
                    else {
                        System.out.println("\nThere aren't any Binary Tree");
                    }
                    break;
                case "3":
                    if (existBinaryTree()){
                        binaryTree.howPrint();
                    }
                    else {
                        System.out.println("\nThere aren't any Binary Tree");
                    }
                    break;
                case "4":
                    isRunning = false;
                    break;
                default:
                    System.out.println("\nSelect a correct option");
                    break;
            }
        }
    }

    private boolean existBinaryTree() { return !(binaryTree == null); }

    private void createBinaryTree(int value) {
        if (binaryTree == null){
            binaryTree = new BinaryTrees(value);
        }
    }

    public void createMenuGraph(){
        String userResponse;
        boolean isRunning = true;

        while (isRunning){

            userResponse = menu.getOptionGraph();

            switch (userResponse) {
                case "1":
                    createGraph();
                    menu();
                    break;
                case "2":
                    if (existGraph()){
                        System.out.println(graph);
                    }
                    else {
                        System.out.println("\nThere aren't any Graph");
                    }
                    break;
                case "3":
                    if(graph.isVoidEdges()) {
                        System.out.println("All departments need an edge");
                    }
                    else {
                        isRunning = false;
                    }
                    break;
                default:
                    System.out.println("\nSelect a correct option");
                    break;
            }
        }
    }

    public void menu(){
        String userResponse;
        String department;
        boolean isRunning = true;
        while (isRunning){

            userResponse = menu.getOptionGraphCreate();

            switch (userResponse){
                case "1":
                    do {
                        System.out.println("Write the name of the department:");
                        department = scanner.nextLine();
                    } while (!graph.existDepa(department));
                    if (sizeDepa != 0){
                        if (!graph.findDepaRepeat(department)) {
                            graph.addNode(graph.createDepa(department));
                            sizeDepa++;
                        } else {
                            System.out.println("Sorry, this department has already been added");
                        }
                    } else {
                        graph.addNode(graph.createDepa(department));
                        sizeDepa++;
                    }
                    break;
                case "2":
                    if (sizeDepa >= 2) {
                        graph.addRoute();
                    }
                    else {
                        System.out.println("Sorry, there aren't enough departments to create an edge");
                    }
                    break;
                case "3":
                     isRunning = false;
                    break;
                default:
                    System.out.printf("You don't select a correct option. Please try again");
            }
        }
    }

    private boolean existGraph() { return !(graph == null); }

    private void createGraph() {
        if (graph == null){
            graph = new Graph();
        }
    }
}
