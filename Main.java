//Michael Merabi CS482 Project#1

import java.io.*;
import java.util.*;

public class Main {
    public static int n = 0;
    public static int solution = 0;

    public static void main(String[] args) {

        System.out.println("The Stablematching program by Michael Merabi is now starting");
        List<List<Integer>> people_arr = fileReader("./src/input1.txt"); //preference List

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

        //sanity check
        System.out.println(Arrays.toString(results.toArray()));

        ArrayList<List<List<Integer>>> stable_results=new ArrayList<List<List<Integer>>>();
        for (List<List<Integer>> result : results)
        {
            boolean stable=true;

            //For each pair in the Integer list
            for(List<Integer> pair : result){

                //First number in the pair?
                boolean first=true;

                //For both numbers in the pair
                for(Integer num:pair){

                    if(first){
                        int bleh=pair.get(1);
                        if(people_arr[pair.get(0)].isLast(bleh)){
                            stable=false;
                        }
                        first=false;
                    }
                    else{
                        int bleh=pair.get(0);
                        if(people_array[pair.get(1)].isLast(bleh)){
                            stable=false;
                        }
                        else{
                            ;
                        }
                    }

                }
            }

            //If the result is stable, add to the count
            if(stable){

                solution+=1;

                //UNCOMMENT FOR DEBUGGING
                stable_results.add(new ArrayList<List<Integer>>(result));
            }

        }



        if (solution == 0) {
            System.out.println("NO possible matching");
        } else {
            System.out.println("YES, there are " + solution + "possible solutions");
        }
    }


    //Method to take in double array and fill with preferences then return back to Main
    public static List<List<Integer>> fileReader(String file) {

        List<List<Integer>> matching_array = new ArrayList<>();

        try { //pulling in data from the file
            Scanner scanner = new Scanner(new File(file));
            n = scanner.nextInt();


            //Checking to make sure correct parsing
            System.out.println("The number of people is " + n);

            //iterator to go through and fill the lists
            while (scanner.hasNextLine()) {
                List<Integer> preferences = new ArrayList<>();
                for (int i = 0; i < n - 1; i++) {
                    preferences.add(scanner.nextInt());
                }
                matching_array.add(preferences);
            }
            System.out.println(Arrays.toString(matching_array.toArray()));
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


    private static void compute(Set<Integer> set, List<List<Integer>> currentResults, List<List<List<Integer>>> results)
    {
        if (set.size() < 2)
        {
            results.add(new ArrayList<List<Integer>>(currentResults));
            return;
        }
        List<Integer> list = new ArrayList<Integer>(set);
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