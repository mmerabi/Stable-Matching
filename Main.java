import java.io.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        System.out.println("The Stablematching program by Michael Merabi is now starting");

        //Create new double array and read in all the information using people/person classes
        people people_arr = new people();
        people_arr = fileReader("./src/input1.txt");


    }


    //Method to take in double array and fill with preferences then return back to Main
    private static people fileReader(String file) {

        //number of people = n
        int n;
        int rows;
        int columns;
        int row_index = 0;
        int column_index = 0;

        try {
            Scanner scanner = new Scanner(new File(file));
            n = scanner.nextInt();
            rows = n;
            columns = n - 1;
            int[][] matching_array = new int[rows][columns];

            //Checking to make sure correct parsing
            System.out.println("The number of people is " + n);
            System.out.println("The number of rows is " + rows);
            System.out.println("The number of columns is " + columns);

            //iterator to go through and fill the arrays
            while (scanner.hasNextLine()) {
                matching_array[row_index][column_index] = scanner.nextInt();

                column_index += 1;

                if (column_index == columns) {
                    row_index += 1;
                    column_index = 0;
                    if (row_index == rows) {
                        break;
                    }
                }
            }
            scanner.close();
            System.out.println(Arrays.deepToString(matching_array));

            people preferences = new people();
            preferences.setRows(rows);
            preferences.setColumns(columns);
            preferences.setN(n);
            preferences.setArray(matching_array);

            //Return the double array
            return preferences;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return (new people());
    }


    //Method to solve the preferences array and return the amount of solutions
    private static int Solve(people preferences) {
        int solution = 0;

        return solution;
    }
    
}








//individual person class
class person{
    private int[] preferences;
    private int currentProposal;
    private boolean taken;


    public boolean getTaken(){
        return this.taken;
    }

    public int getFirstPreference(){
        return this.preferences[0];
    }


    public void setPreferences(int[] arr){
        this.preferences=new int[arr.length];
        this.preferences=arr;
    }

    public void setTaken(boolean status){ this.taken=status; }

    public void proposeTo(){
        return;
    }
}

//array of people class, used for sum total program
class people{
    private int rows;
    private int columns;
    private int n;
    private int[][] roommates;

    public int getN(){
        return this.n;
    }

    public void setN(int n){
        this.n=n;
    }

    public int getRows() {
        return this.rows;
    }

    public void setRows(int row) {
        this.rows=row;
    }

    public int getColumns() {
        return this.columns;
    }

    public void setColumns(int column) {
        this.columns=column;
    }


    public int[][] getArray() {
        return this.roommates;
    }

    public void setArray(int[][] arr) {
        this.roommates=arr;
    }

    public int[] getPerson(int index){
        System.out.println(this.roommates[index]);
        return this.roommates[index];
    }

}