import java.util.stream.Collectors;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

         // Test Case 1: Empty Array
         System.out.println("\nContainer: " + getFormattedArray(new Integer[] {}) + "\nMaxArea: " + maxArea(new Integer[] {}));

         // Test Case 2: Single Element Array
         System.out.println("\nContainer: " + getFormattedArray(new Integer[] {5}) + "\nMaxArea: " + maxArea(new Integer[] {5}));
 
         // Test Case 3: Array with Two Elements
         System.out.println("\nContainer: " + getFormattedArray(new Integer[] {1, 2}) + "\nMaxArea: " + maxArea(new Integer[] {1, 2}));
 
         // Test Case 4: Array with All Elements of Equal Height
         System.out.println("\nContainer: " + getFormattedArray(new Integer[] {4, 4, 4, 4}) + "\nMaxArea: " + maxArea(new Integer[] {4, 4, 4, 4}));
 
         // Test Case 5: Array with Increasing Heights
         System.out.println("\nContainer: " + getFormattedArray(new Integer[] {1, 2, 3, 4, 5}) + "\nMaxArea: " + maxArea(new Integer[] {1, 2, 3, 4, 5}));
 
         // Test Case 6: Array with Decreasing Heights
         System.out.println("\nContainer: " + getFormattedArray(new Integer[] {5, 4, 3, 2, 1}) + "\nMaxArea: " + maxArea(new Integer[] {5, 4, 3, 2, 1}));
 
         // Test Case 7: Array with Random Heights
         System.out.println("\nContainer: " + getFormattedArray(new Integer[] {1, 8, 6, 2, 5, 4, 8, 3, 7}) + "\nMaxArea: " + maxArea(new Integer[] {1, 8, 6, 2, 5, 4, 8, 3, 7}));
    
        // Test Case 8: A Large Array of Heights
        Integer[] largeArray = new Integer[1000];
        for (int i = 0; i < 1000; ++i) {
            largeArray[i] = i % 10 + 1;
        }
        System.out.println("\nContainer: " + getFormattedArray(largeArray) + "\nMaxArea: " + maxArea(largeArray));
    }

    static int maxArea(Integer[] height) {
        // Handle empty arrays
        int arrayLength = height.length;
        if (arrayLength == 0) { return 0; }
        
        int currentMax = 0, left = 0, right = arrayLength - 1;
        
        while (left != right) {
            // The area for any two lines is at most the square of the smaller line
            int area = Integer.min(height[left], height[right]) * (right - left);
            if (area > currentMax) {
                currentMax = area;
            }

            // Move the pointer of the smaller of the two values
            if (height[left] > height[right]) {
                --right;
            }
            else {
                ++left;
            }
        }
        return currentMax;
    }

    static String getFormattedArray(Integer[] container) {
        return (container != null)
            ? Arrays.stream(container).map(String::valueOf).collect(Collectors.joining(", ", "[ ", " ]"))
            : "Empty Container";
    }

}
                