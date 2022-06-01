package co.edu.unaula.syanr4.edges;

import co.edu.unaula.syanr4.nodes.NodeGraph;

public class Edge {
    private NodeGraph origin;
    private NodeGraph destination;
    private double distance;

    public Edge(NodeGraph origin, NodeGraph destination, double distance) {
        this.origin = origin;
        this.destination = destination;
        this.distance = distance;
    }

    public NodeGraph getOrigin() {
        return origin;
    }

    public NodeGraph getDestination() {
        return destination;
    }

    public double getDistance() {
        return distance;
    }

    @Override
    public String toString(){
        return "\n\t\t\t Edge: Origin = " + origin.getDepartment() + "-> Distance = " + distance +
        "-> Destination = " + destination.getDepartment();
    }
}
