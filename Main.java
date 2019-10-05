import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("The Stablematching program by Michael Merabi is now starting");

        List<List<Integer>> people_arr = fileReader("./src/input1.txt");



        //run the solution to see if there is a possible matching
        int solution = Solve(people_arr);
        if (solution == 0) {
            System.out.println("NO possible matching");
        } else {
            System.out.println("YES, there are " + solution + "possible solutions");
        }
    }


    //Method to take in double array and fill with preferences then return back to Main
    public static List<List<Integer>> fileReader(String file) {

        //number of people = n
        int n = 0;
        List<List<Integer>> matching_array = null;

        try { //pulling in data from the file
            Scanner scanner = new Scanner(new File(file));
            n = scanner.nextInt();
            System.out.print(n);

            //first add n
            List<Integer> placeholder = null;
            placeholder.add(n);
            matching_array.add(placeholder);

            //Checking to make sure correct parsing
            System.out.println("The number of people is " + n);

            //iterator to go through and fill the lists
            while (scanner.hasNextLine()) {
                List<Integer> preferences = null;
                for (int i = 0; i < n-1; i++) {
                    preferences.add(scanner.nextInt());
                }
                matching_array.add(preferences);
            }
            scanner.close();
            matching_array.listIterator(); //sanity check


            //Return the List of lists
            return matching_array;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return matching_array;
    }


    //create all possible permutations of N
    public List<List<Integer>> permutations(int n){
        List<List<Integer>> permutations = null;



        return permutations;
    }


    //Method to solve the preferences array and return the amount of solutions
    private static int Solve( List<List<Integer>> people_arr) {
        int solution = 0;


        return solution;
    }
}

