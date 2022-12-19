/**
 * Vertex class customized for My Routine program.
 * Creates places as vertices and allows for tracking
 * of adjacent places traveled to in the neighborhood list
 */

package MyRoutine;

import java.util.ArrayList;

public class Vertex {
    private ArrayList<Edge> neighborhood;
    private String place;
    private int visits;

    public Vertex(String place) {
        this.place = place;
        this.neighborhood = new ArrayList<Edge>();
        visits = 1;
    }

    // add edge to neighborhood
    public void addNeighbor(Edge edge) {
        if (this.neighborhood.contains(edge)) {
            return;//future spot to increment paths ?
        }
        this.neighborhood.add(edge);
    }

    // check if vertex contains an edge
    public boolean containsNeighbor(Edge other) {
        return this.neighborhood.contains(other);
    }

    public Edge getNeighbor(int index) {
        return this.neighborhood.get(index);
    }

    public int getNeighborCount() {
        return this.neighborhood.size();
    }

    //get string label for current vertex
    public String getLabel() {
        return this.place;
    }


    //custom to string method for vertex
    public String toString() {
        return "Place: " + place + " Visits: " + visits;
    }

    public int hashCode() {
        return this.place.hashCode();
    }

    //compare vertices, return true if equal
    public boolean equals(Object other) {
        if (!(other instanceof Vertex)) {
            return false;
        }
        Vertex v = (Vertex) other;

        return this.place.equals(v.place);
    }

    //get neighbors of current vertex
    public ArrayList<Edge> getNeighbors() {
        return new ArrayList<Edge>(this.neighborhood);
    }

    //method to increment visits to current place
    public void visit() {
        visits++;
    }
}
