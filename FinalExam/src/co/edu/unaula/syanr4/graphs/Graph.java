package co.edu.unaula.syanr4.graphs;

import co.edu.unaula.syanr4.edges.Edge;
import co.edu.unaula.syanr4.nodes.NodeGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Graph {

    private Scanner scanner = new Scanner(System.in);

    private List<NodeGraph> nodes;
    private String error;

    private String[] departments = {"Amazonas","Antioquia", "Arauca", "Atlantico", "Bogota", "Bolivar", "Boyaca", "Caldas",
            "Caqueta","Casanare", "Cauca", "Cesar", "Choco", "Cordoba", "Cundinamarca", "Guainia", "Guaviare", "Huila",
            "La Guajira", "Magdalena", "Meta", "Nariño", "Norte de Santander", "Putumayo", "Quindio", "Risaralda",
            "San Andres y Providencia", "Santander", "Sucre", "Tolima", "Valle del Cauca", "Vaupes", "Vichada" };

    public Graph(){ this.error = ""; }

    private  boolean validate(NodeGraph node){
        if (node == null){
            error = "You need send a node";
            return false;
        }
        return true;
    }

    public NodeGraph createDepa(String name){
        NodeGraph department = new NodeGraph(name);
        return department;
    }

    private Edge createEgde(String origin, String destination, double distance){
        Edge edge = new Edge(findDepa(origin), findDepa(destination), distance);
        return edge;
    }

    public void addRoute(){
        boolean isRunning = true;
        String origin;
        String destination;
        double distance;
        do {
            do {
                System.out.println("Write the name of department origin edge");
                origin = scanner.nextLine();
                if (existDepa(origin)) {
                    if (findDepaRepeat(origin)) {
                        isRunning = false;
                    } else {
                        System.out.println("This department has not been added yet");
                    }
                }
            } while (isRunning);
            do {
                isRunning = true;
                System.out.println("Write the name of department destination edge");
                destination = scanner.nextLine();
                if (existDepa(destination)) {
                    if (findDepaRepeat(destination)) {
                        if (destination.toLowerCase().equals(origin.toLowerCase())) {
                            System.out.println("The origin can't equals to destination");
                            isRunning = true;
                            break;
                        }
                        isRunning = false;
                    } else {
                        System.out.println("This department not exits");
                    }
                } else {
                    isRunning = true;
                }
            } while (isRunning);
            System.out.println("Write the distance of "+ origin + "  to " + destination + " edge in Km");
            distance = scanner.nextInt();
            scanner.nextLine();
            if (findRouteRepeat(origin.toLowerCase(), destination.toLowerCase(), distance)){
                isRunning = true;
            }
        } while (isRunning);
        findDepa(origin).addEdges(createEgde(origin, destination, distance));
    }

    private NodeGraph findDepa(String name){
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).getDepartment().toLowerCase().equals(name.toLowerCase())) {
                return  nodes.get(i);
            }
        }
        return null;
    }

    public boolean findDepaRepeat(String name){
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).getDepartment().toLowerCase().equals(name.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public boolean findRouteRepeat(String origin, String destination, double distance){
        NodeGraph aux;
        int sizeEdges;
        aux = findDepa(origin);
        if (aux.getEdges() == null){
            return false;
        }
        sizeEdges = aux.getEdges().size();
        for (int i = 0; i < sizeEdges; i++) {
            if (getOrigin(aux, i).equals(origin) && getDestination(aux, i).equals(destination) && getDistance(aux, i) == distance){
                System.out.println("\nThis route alredy exist\n");
                return true;
            }
        }
        return false;
    }

    private double getDistance(NodeGraph aux, int position){
        return aux.getEdges().get(position).getDistance();
    }

    private String getOrigin(NodeGraph aux, int position){
        return aux.getEdges().get(position).getOrigin().getDepartment().toLowerCase();
    }

    private String getDestination(NodeGraph aux, int position){
        return aux.getEdges().get(position).getDestination().getDepartment().toLowerCase();
    }

    public boolean existDepa(String name){
        for (int i = 0; i < departments.length; i++) {
            if(departments[i].toLowerCase().equals(name.toLowerCase())){
                return true;
            }
        }
        System.out.println("This department not exits");
        return false;
    }

    public boolean addNode(NodeGraph node){
        if(!validate(node)){
            return false;
        }
        if (this.nodes == null){
            this.nodes = new ArrayList<>();
        }
        this.nodes.add(node);
        return true;
    }

    public boolean isVoidEdges(){
        for (int i = 0; i < nodes.size(); i++) {
            if(nodes.get(i).getEdges() == null){
                return true;
            }
        }
        return false;
    }

    public List<NodeGraph> getNodes() {
        return nodes;
    }

    public String getError() {
        return error;
    }

    @Override
    public String toString(){
        return "Graph [Nodes = " + this.nodes + "] \n";
    }
}

