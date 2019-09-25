import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) {

        System.out.println("The Stablematching program by Michael Merabi is now starting");
        fileReader();

    }


    public static void fileReader() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("./src/input1.txt"));

            
        }
        catch (Exception filereader){
            System.out.println("Error while pulling file");
            filereader.printStackTrace();
        }
    }




}
