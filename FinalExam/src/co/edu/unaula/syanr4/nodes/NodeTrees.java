package co.edu.unaula.syanr4.nodes;

public class NodeTrees {

    private NodeTrees father;
    private NodeTrees leftLeaf;
    private NodeTrees rightLeaf;

    private int value;

    public NodeTrees(int vaule){
        this.value = vaule;
        father = null;
        rightLeaf = null;
        leftLeaf = null;
    }

    public NodeTrees getFather() {
        return father;
    }

    public void setFather(NodeTrees father) {
        this.father = father;
    }

    public NodeTrees getLeftLeaf() {
        return leftLeaf;
    }

    public void setLeftLeaf(NodeTrees leftLeaf) {
        this.leftLeaf = leftLeaf;
    }

    public NodeTrees getRightLeaf() {
        return rightLeaf;
    }

    public void setRightLeaf(NodeTrees rightLeaf) {
        this.rightLeaf = rightLeaf;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
