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

    private static final StringBuilder sb = new StringBuilder();

    // Main method and its the starting point of our application
    public static void main(String[] args) {
        
        int[] nums = {1, 2, 1, 0, 38, 23, 12};

        try( Scanner scanner = new Scanner(System.in) ){

            System.out.print("Enter the target to search in our array : ");

            int target = scanner.nextInt();

            int result = binarySearch(nums, target);

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

        Set<Integer> numsSet = new TreeSet<>();

        for ( int num : nums ){

            numsSet.add(num);

        }

        List<Integer> sortedArrayList = new ArrayList<>(numsSet);

        return sortedArrayList.indexOf(target);

    }

    // Binary Search Function from Collections class
    public static int binarySearch(int[] nums, int target){

        sb.append("BINARY");

        Set<Integer> numsSet = new TreeSet<>();

        for ( int num : nums ){

            numsSet.add(num);

        }

        List<Integer> sortedArrayList = new ArrayList<>(numsSet);

        int left = 0;

        int right = sortedArrayList.size() - 1;

        while( left <= right ){

            int mid = (left + right) / 2;

            if ( sortedArrayList.get(mid).equals(target) ){

                return mid;

            }

            if ( target < sortedArrayList.get(mid) ){

                right = mid - 1;

            }

            if ( target > sortedArrayList.get(mid) ){

                left = mid + 1;

            }

        }

        return -1;

    }

}