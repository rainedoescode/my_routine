/**
 * Edge class that builds a "trip" between places
 */

package MyRoutine;

public class Edge implements Comparable<Edge> {

    private Vertex one, two;
    private int trips; // value to track trips along edge in future

    //create an edge with default of one trip
    public Edge(Vertex one, Vertex two) {
        this(one, two, 1);
    }

    //create an edge with a specified number of trips
    public Edge(Vertex one, Vertex two, int trips) {
        this.one = (one.getLabel().compareTo(two.getLabel())
                <= 0) ? one : two;
        this.two = (this.one == one) ? two : one;
        this.trips = trips;
    }

    public Vertex getNeighbor(Vertex current) {
        if (!(current.equals(one) || current.equals(two))) {
            return null;
        }
        return (current.equals(one)) ? two : one;
    }

    //future method to add trip to current edge
    public void addTrip() {
        this.trips++;
    }

    //general getter methods for vertices and trips
    public Vertex getOne() {
        return this.one;
    }

    public Vertex getTwo() {
        return this.two;
    }

    public int getTrips() {
        return this.trips;
    }

    //setter for number of trips
    public void setTrips(int trips) {
        this.trips = trips;
    }

    //compares edge trips
    public int compareTo(Edge other) {
        return this.trips - other.trips;
    }

    //toString method for edge
    public String toString() {
        return "[{ " + one.getLabel() + " <-> " + two.getLabel() + " }]";
        //+ ", "
        //+ trips + " trips ]";//trips not function in current build
    }

    //hashcode of edge
    public int hashCode() {
        return (one.getLabel() + two.getLabel()).hashCode();
    }

    //compare edges, return true if same
    public boolean equals(Object other) {
        if (!(other instanceof Edge)) {
            return false;
        }
        Edge e = (Edge) other;

        return e.one.equals(this.one) &&
                e.two.equals(this.two);
    }

}
