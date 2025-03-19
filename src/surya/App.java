// The package of our current class
package surya;

// Required packages are imported
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

// Class named with App
public class App{

    // static final StringBuilder datatype to create new String value
    private static final StringBuilder sb = new StringBuilder();

    // Main method and its the starting point of our application
    public static void main(String[] args) {
        
        // Random array 
        int[] nums = {1, 2, 1, 0, 38, 23, 12};

        // Using try with resources for auto closing if connections are in open state
        try( Scanner scanner = new Scanner(System.in) ){

            // Asking the question to take input from user
            System.out.print("Enter the target to search in our array : ");

            // Taking input from user with Scannner class
            int target = scanner.nextInt();

            // Using the algorithm to search
            int result = binarySearch(nums, target);

            // Printing the correct result with if else statements 
            if ( result != -1 ) {

                if ( sb.toString().equals("LINEAR") ) {

                    System.out.println("The index value of our target from LINEAR SEARCH is " + result);

                }else if ( sb.toString().equals("BINARY") ) {

                    System.out.println("The index value of our target from BINARY SEARCH is " + result);

                }

            } else {

                System.out.println("Element not found");

            }

        }

    }

    // Linear Search Function with our traditional For Loop
    public static int linearSearch(int[] nums, int target){

        sb.append("LINEAR");

        // Using Set Data Type to avoid duplicates
        Set<Integer> numsSet = new TreeSet<>();

        // Add the nums array to numsSet with enhanced for loop
        for ( int num : nums ){

            numsSet.add(num);

        }

        // Copying all numsSet to normal List dataype to get index values
        List<Integer> sortedArrayList = new ArrayList<>(numsSet);

        // Now simply giving the index value with traditional for loop with prebuilt method
        return sortedArrayList.indexOf(target);

    }

    // Binary Search Function from Collections class
    public static int binarySearch(int[] nums, int target){

        sb.append("BINARY");

        // Using Set Data Type to avoid duplicates
        Set<Integer> numsSet = new TreeSet<>();

        // Add the nums array to numsSet with enhanced for loop
        for ( int num : nums ){

            numsSet.add(num);

        }

        // Copying all numsSet to normal List dataype to get index values
        List<Integer> sortedArrayList = new ArrayList<>(numsSet);

        // Left value for iteration
        int left = 0;

        // Right value for iteration
        int right = sortedArrayList.size() - 1;

        // While loop to loop without index value
        while( left <= right ){

            // Diving the left and right to get mid value
            int mid = (left + right) / 2;

            // Checking if the mid is equal
            if ( sortedArrayList.get(mid).equals(target) ){

                return mid;

            }

            // If the targest is less then mid then we are removing the right part to avoid more steps
            if ( target < sortedArrayList.get(mid) ){

                right = mid - 1;

            }

            // If the targest is greater then mid then we are removing the left part to avoid more steps
            if ( target > sortedArrayList.get(mid) ){

                left = mid + 1;

            }

        }

        // Returning the false value if no value found 
        return -1;

    }

}