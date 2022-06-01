package co.edu.unaula.syanr4.trees;

import co.edu.unaula.syanr4.nodes.Node;
import co.edu.unaula.syanr4.nodes.NodeTrees;

import java.util.Scanner;

public class BinaryTrees {

    Scanner scanner = new Scanner(System.in);

    private NodeTrees root;

    public BinaryTrees(int value){ root = new NodeTrees(value); }

    public NodeTrees getRoot() { return root; }

    public void addNode(int value){
        try{
            NodeTrees newNode = new NodeTrees(value);
            addNodes(newNode, root);
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw e;
        }
    }

    private void addNodes(NodeTrees newNode, NodeTrees rootNode){
        newNode.setFather(rootNode);
        if (newNode.getValue() < rootNode.getValue()){
            if (rootNode.getLeftLeaf() == null){
                rootNode.setLeftLeaf(newNode);
            }
            else{
                addNodes(newNode, rootNode.getLeftLeaf());
            }
        }else{
            if (rootNode.getRightLeaf() == null){
                rootNode.setRightLeaf(newNode);
            }
            else {
                addNodes(newNode, rootNode.getRightLeaf());
            }
        }
    }

    private NodeTrees findNode(int value, NodeTrees root){
        if (value == root.getValue()){
            return root;
        }
        else if(value < root.getValue()){
            if (root.getLeftLeaf() != null){
                return findNode(value, root.getLeftLeaf());
            }
            else {
                return null;
            }
        }
        else{
            if (root.getRightLeaf() != null){
                return findNode(value, root.getRightLeaf());
            }
            else {
                System.out.println("This leaf no exist");
                return null;
            }
        }
    }

    public boolean removeNodes(int value){

        if(this.root.getValue() == value){
            System.out.println("The root node can't be removed");
            return false;
        }

        NodeTrees nodeFind = findNode(value, this.root);

        if(nodeFind == null){
            System.out.println("The node with value " + value + " does not exist");
            return false;
        }

        boolean haveChildRight = nodeFind.getRightLeaf() != null;
        boolean haveChildLeft = nodeFind.getLeftLeaf() != null;

        if(!haveChildLeft && !haveChildRight){
            return removeLeaves(nodeFind);
        }
        if(!haveChildLeft || !haveChildRight){
            return removeBranchUniqueChild(nodeFind);
        }
        if(haveChildLeft && haveChildRight){
            return removeRootSubTree(nodeFind);
        }
        return false;

    }

    private boolean removeNodes(NodeTrees nodeFind){
        boolean haveChildRight = nodeFind.getRightLeaf() != null;
        boolean haveChildLeft = nodeFind.getLeftLeaf() != null;

        if (!haveChildLeft && !haveChildRight){
            return removeLeaves(nodeFind);
        }
        if (!haveChildLeft || !haveChildRight){
            return removeBranchUniqueChild(nodeFind);
        }
        if (haveChildLeft && haveChildRight){
            return removeRootSubTree(nodeFind);
        }
        return false;
    }

    private boolean removeRootSubTree(NodeTrees node) {

        NodeTrees righttMostNode = walkRight(node.getRightLeaf());

        if(righttMostNode != null){

            node.setValue(righttMostNode.getValue());

            removeNodes(righttMostNode);
            return true;
        }
        return false;
    }

    private NodeTrees walkRight(NodeTrees node){
        if(node.getLeftLeaf() != null){
            return walkRight(node.getLeftLeaf());
        }
        return node;
    }

    private boolean removeBranchUniqueChild(NodeTrees node) {
        NodeTrees leftChild = node.getFather().getLeftLeaf();
        NodeTrees rightChild = node.getFather().getRightLeaf();
        NodeTrees actualChild;

        if (node.getLeftLeaf() != null){
            actualChild = node.getLeftLeaf();
        }else {
            actualChild = node.getRightLeaf();
        }

        if (leftChild == node){
            node.getFather().setLeftLeaf(actualChild);
            actualChild.setFather(node.getFather());
            node.setLeftLeaf(null);
            node.setRightLeaf(null);
            return true;
        }

        if (rightChild == node){
            node.getFather().setRightLeaf(actualChild);
            actualChild.setFather(node.getFather());
            node.setLeftLeaf(null);
            node.setRightLeaf(null);
            return true;
        }
        return false;
    }

    private boolean removeLeaves(NodeTrees node) {
        NodeTrees leftChild = node.getFather().getLeftLeaf();
        NodeTrees rightChild = node.getFather().getRightLeaf();

        if (leftChild == node){
            node.getFather().setLeftLeaf(null);
            return true;
        }
        if (rightChild == node){
            node.getFather().setRightLeaf(null);
            return true;
        }
        return false;
    }

    public void printPreOrder(NodeTrees node){

        System.out.println(node.getValue());

        if(node.getLeftLeaf() != null){
            printPreOrder(node.getLeftLeaf());
        }
        if(node.getRightLeaf() != null){
            printPreOrder(node.getRightLeaf());
        }
    }

    private void printInOrder(NodeTrees node){

        if(node.getLeftLeaf() != null){
            printInOrder(node.getLeftLeaf());
        }

        System.out.println(node.getValue());

        if(node.getRightLeaf() != null){
            printInOrder(node.getRightLeaf());
        }

    }

    private void printPostOrder(NodeTrees node){
        if(node.getLeftLeaf() != null){
            printPostOrder(node.getLeftLeaf());
        }
        if(node.getRightLeaf() != null){
            printPostOrder(node.getRightLeaf());
        }

        System.out.println(node.getValue());

    }

    public void howPrint(){
        boolean controlWhile = false;
        do {
            System.out.println("\nHow do you want print the binary Tree" +
                    "\n1- Pre Order" +
                    "\n2- In Order" +
                    "\n3- Post Order");
            String decision = scanner.nextLine();
            switch (decision) {
                case "1":
                    printPreOrder(this.root);
                    break;
                case "2":
                    printInOrder(this.root);
                    break;
                case "3":
                    printPostOrder(this.root);
                    break;
                default:
                    System.out.println("Select a correct option");
                    controlWhile = true;
                    break;
            }
        } while (controlWhile);
    }
}
