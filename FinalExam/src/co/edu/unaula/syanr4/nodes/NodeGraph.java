package co.edu.unaula.syanr4.nodes;

import co.edu.unaula.syanr4.edges.Edge;

import java.util.ArrayList;
import java.util.List;

public class NodeGraph {

    private String department;
    private List<Edge> edges;
    private String error;

    public NodeGraph(String department){
        this.department = department;
        this.error = "";
    }

    public String getDepartment() {
        return department;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public String getError() {
        return error;
    }

    public boolean validate(Edge edge){
        if (edge == null){
            error = "The edges can't void";
            return false;
        }
        return true;
    }

    public boolean addEdges(Edge edge){
        if (!validate(edge)){
            return false;
        }
        if (edges == null){
            edges = new ArrayList<>();
        }
        edges.add(edge);
        return true;
    }

    @Override
    public String toString(){
        return "\n \t Node [ deparment = " + department + "\n \t\t edges = " + edges + " \n";
    }
}
