/**
 * Graph class built from tutorial, and customized to
 * needs for My Routine program. Automatically adds edges
 * as vertices are added by tracking the last vertex.
 * Hash maps are used to store edges and vertices contained
 * within the graph
 */

package MyRoutine;

import java.util.*;

public class RoutineGraph {

    private HashMap<String, Vertex> vertices;
    private HashMap<Integer, Edge> edges;

    private Vertex last;

    public RoutineGraph() {

        this.vertices = new HashMap<String, Vertex>();
        this.edges = new HashMap<Integer, Edge>();
    }

    // add edge with default weight if it does not exist
    public boolean addEdge(Vertex one, Vertex two) {
        return addEdge(one, two, 1); // returns true if added
    }

    // add edge with provided weight
    public boolean addEdge(Vertex one, Vertex two, int weight) {

        if (one.equals(two)) {
            return false;
        }

        // check that edge is not in graph
        Edge e = new Edge(one, two, weight);
        if (edges.containsKey(e.hashCode())) {

            return false;
        }
        // check that edge is not incident to either vertex
        else if (one.containsNeighbor(e) || two.containsNeighbor(e)) {

            return false;
        }

        edges.put(e.hashCode(), e);
        one.addNeighbor(e);
        two.addNeighbor(e);

        return true;
    }

    // check if an edge is contained within the graph
    public boolean containsEdge(Edge e) {

        if (e.getOne() == null || e.getTwo() == null) {

            return false;
        }

        return this.edges.containsKey(e.hashCode());
    }

    // check graph for specified vertex
    public boolean containsVertex(Vertex vertex) {

        return this.vertices.get(vertex.getLabel()) != null;
    }

    // return vertex with specified name
    public Vertex getVertex(String place) {

        return vertices.get(place);
    }

    /** Method to add vertex to the graph, also
     *  automatically tracks last place and adds edges
     *  between current and last vertex
     *  @param vertex
     *  @return true if vertex was added
     */
    public boolean addVertex(Vertex vertex) {

        Vertex current = this.vertices.get(vertex.getLabel());
        if (current != null) {

            current.visit();
            addEdge(last, current);
            last = current;

            return false; // vertex not added
        }

        vertices.put(vertex.getLabel(), vertex);

        if (last == null) {
            last = vertex;
        } else {
            addEdge(last, vertex);
            last = vertex;
        }

        return true; // vertex was added
    }

    /**@return set of places from graph
     */
    public Set<String> vertexKeys() {

        return this.vertices.keySet();
    }

    /**
     * @return set of Edges in graph
     */
    public Set<Edge> getEdges() {

        return new HashSet<Edge>(this.edges.values());
    }

    // print all vertices in graph
    public void printRoutine() {

        for (String name : vertices.keySet()) {

            String value = vertices.get(name).toString();
            System.out.println(value);
        }
    }

    public void printTrips() {

        Iterator<Edge> itr = this.getEdges().iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next().toString());
        }
    }
}
