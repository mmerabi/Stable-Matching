import java.io.*;
import java.util.*;


public class Main {
    int firstN;
    int inputInt;

    public static void main(String[] args) {

        System.out.println("The Stablematching program by Michael Merabi is now starting");
        fileReader("./src/input1.txt");

    }

    public static int[][] fileReader(String file) {
        int[][] array = null;
        String inputString;

        try {

            BufferedReader br = new BufferedReader(new FileReader(file));
            inputString = br.readLine();

            while (( inputString = br.readLine()) != null) {

            }

        }
        catch (Exception filereader){
            System.out.println("Error while pulling file");
            filereader.printStackTrace();
        }
        return array;
    }




}
