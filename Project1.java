//Michael Merabi CS482 Project#1
//Stable Matching print out

import java.io.*;
import java.util.*;

public class Project1 {
    public static int n = 0;
    public static int solution = 0;

    public static void main(String[] args) {

        System.out.println("The Stablematching program by Michael Merabi is now starting");
        List<List<Integer>> people_arr = fileReader("./input1.txt"); //preference List

        //creating array for permutations calculations
        int[] perm = new int[n];
        for(int start=0; start<n ;start++){
            perm[start]=start+1;
        }

        //Creating new set
        Set<Integer> set = new LinkedHashSet<Integer>();
        for(int k=1;k<=perm.length;k++){
            set.add(k);
        }

        ArrayList<List<List<Integer>>> results = new ArrayList<List<List<Integer>>>();
        compute(set, new ArrayList<List<Integer>>(), results);

        // sanity check
        // System.out.println(Arrays.toString(results.toArray()));

        for (List<List<Integer>> result : results)
        {
            boolean stable=true;

            for(List<Integer> pair : result){
                boolean first=true;

                //For both numbers in the pair
                for(Integer num:pair){

                    if(first){
                        int lastpick = pair.get(1);
                        //check last pick against other pair in preference
                        int[] people_array = toIntArray(people_arr.get(num-1));
                        if(isLast(lastpick, people_array)){
                            stable=false;
                        }
                    }
                    if(first){
                        int lastpick = pair.get(0);

                        int[] people_array = toIntArray(people_arr.get(num - 1));

                        if(isLast(lastpick, people_array)){
                            stable=false;
                        }
                    }
                }
            }

            //If the result is stable, increment the count
            if(stable){
                solution+=1;
            }
        }


        //Print out of solution
        if (solution == 0) {
            System.out.println("NO possible matching");
        } else {
            System.out.println("YES, there are " + solution + " possible solutions");
        }
    }


    //Method to take in double array and fill with preferences then return back to Main
    public static List<List<Integer>> fileReader(String file) {

        List<List<Integer>> matching_array = new ArrayList<>();

        try { //pulling in data from the file
            Scanner scanner = new Scanner(new File(file));
            n = scanner.nextInt();


            //Checking to make sure correct parsing (Sanity check)
            // System.out.println("The number of people is " + n);

            //iterator to go through and fill the lists
            while (scanner.hasNextLine()) {
                List<Integer> preferences = new ArrayList<>();
                for (int i = 0; i < n - 1; i++) {
                    preferences.add(scanner.nextInt());
                }
                matching_array.add(preferences);
            }
            // Sanity check
            // System.out.println(Arrays.toString(matching_array.toArray()));
            scanner.close();

            //Return the List of lists
            return matching_array;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return matching_array;
    }

    //turn the first list index array into
    public static int[] toIntArray(List<Integer> list){
        int[] ret = new int[list.size()];
        for(int i = 0;i < ret.length;i++)
            ret[i] = list.get(i);
        return ret;
    }


    //Helper Method to check to see if preference matches for partner pair
    public static boolean isLast(int num, int[] preferences){

        if(preferences[preferences.length-1]==num){
            return true;
        }
        else{
            return false;
        }
    }

    //Create all permutations with no duplicates
    private static void compute(Set<Integer> total, List<List<Integer>> currentResults, List<List<List<Integer>>> results)
    {
        if (total.size() < 2)
        {
            results.add(new ArrayList<List<Integer>>(currentResults));
            return;
        }

        List<Integer> list = new ArrayList<Integer>(total);
        Integer first = list.remove(0);
        for (int i=0; i<list.size(); i++)
        {
            Integer second = list.get(i);
            Set<Integer> nextSet = new LinkedHashSet<Integer>(list);
            nextSet.remove(second);

            List<Integer> pair = Arrays.asList(first, second);
            currentResults.add(pair);
            compute(nextSet, currentResults, results);
            currentResults.remove(pair);
        }
    }
}