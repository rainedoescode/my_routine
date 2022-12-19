/**
 * Driver for My Routine program, contains basic
 * interactivity with options to add vertices,
 * print all vertices, print all edges, and an
 * option to quit the program
 */

package MyRoutine;

import java.io.*;

public class MyRoutineDriver {
    public static void main(String[] args) throws IOException {
        String place;
        boolean done = false;

        RoutineGraph myRoutine = new RoutineGraph();
        System.out.println("Welcome to the My Routine App.\n"
                + "This program tracks the places you go and\n"
                + "how mant times they are visited.\n");

        // while loop runs program until the user chooses to quit
        while (!done) {
            System.out.println("Enter a letter to choose an option:");
            System.out.println("'A'dd a place you have been - 'S'how where you have visited"
                    + "\n'T'rips between places (printed) - 'Q'uit the program.");
            // add option to sort by most visits later
            int choice = (getChar());

            switch (choice) {
                case 'a':
                    System.out.println("Enter the name of the place visited: ");
                    place = getString();
                    myRoutine.addVertex(new Vertex(place));
                    break;
                case 's':
                    System.out.println("Here are the places you've been:");
                    myRoutine.printRoutine();
                    System.out.println("----------------------------");
                    break;
                case 't':
                    System.out.println("These are the trips you have made:");
                    myRoutine.printTrips();
                    System.out.println("----------------------------");
                    break;
                case 'q':
                    done = true;
                    System.out.println("Thanks for using My Routine.");
                    break;
                default:
                    System.out.println("Invalid entry, please enter first capital letter"
                            + " of option you want to use.");
            }
        }
    }

    /**
     *  Method to read string input from user
     */
    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s.toLowerCase();
    }

    /**
     *  Method to read char, calls get string method for input
     */
    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }

}
