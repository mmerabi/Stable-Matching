import java.io.*;
import java.util.*;

public class Main {
    public static int n = 0;
    public static int solution = 0;

    public static void main(String[] args) {

        System.out.println("The Stablematching program by Michael Merabi is now starting");
        List<List<Integer>> people_arr = fileReader("./src/input1.txt"); //preference List

        //creating permutations array
        int[] temp = new int[n];
        for(int i = 0; i < n; i++ ){
            temp[i] = i+1;
        }

        //takes the permutations array and creates a possible lists of lists
        List<List<Integer>> permutations = permute(temp);
        System.out.println(Arrays.toString(permutations.toArray()));



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


    //create all possible permutations of N
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(0, nums, result);
        return result;
    }

    private static void helper(int start, int[] nums, List<List<Integer>> result) {
        if (start == nums.length - 1) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            result.add(list);
            return;
        }

        for (int i = start; i < nums.length; i++) {
            swap(nums, i, start);
            helper(start + 1, nums, result);
            swap(nums, i, start);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    //Method to solve the preferences array and return the amount of solutions
    private static void checkSolution(List<List<Integer>> people_arr) {

    }
}
