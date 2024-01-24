# Two Pointer Water Container

## Introduction
"Two Pointer Water Container" is a Java project designed to solve the container with most water problem using the two-pointer approach. This repository demonstrates the application of this approach to find the maximum area that can be contained between two lines, represented as heights in an array.

## Features
- **Efficient Algorithm:** Utilizes a two-pointer technique to optimize performance.
- **Multiple Test Cases:** Covers a range of scenarios including empty arrays, single elements, and arrays with increasing, decreasing, and random heights.

## Getting Started
Clone this repository and run the `Main` class to see the algorithm in action with various test cases.

## Usage
The program calculates the maximum area contained within a set of vertical lines. This is particularly useful in problems related to histograms or container-like structures.

## Algorithm Explanation
- The algorithm iterates over an array of integers, each representing the height of a line.
- Two pointers, one at the start and one at the end of the array, move towards each other.
- At each step, the area between the pointers is calculated and compared against the maximum area found so far.
- The pointer at the shorter line moves one step towards the other pointer.
- This process repeats until both pointers meet.

### Time and Space Complexity
- **Time Complexity:** O(n), where n is the length of the array.
- **Space Complexity:** O(1), as no additional space is required.

## Code Snippet

```java
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
```

## Test Cases

### Test Case 1: Empty Array
- **Container**: An empty array representing no heights.
- **Max Area**: Calculated area should be 0 due to the absence of heights.

### Test Case 2: Single Element Array
- **Container**: An array with a single element, e.g., [5].
- **Max Area**: The area is 0 as only one line cannot form a container.

### Test Case 3: Array with Two Elements
- **Container**: An array with two elements, e.g., [1, 2].
- **Max Area**: Calculated based on the two heights.

### Test Case 4: Array with All Elements of Equal Height
- **Container**: An array where all elements are of equal height, e.g., [4, 4, 4, 4].
- **Max Area**: Calculated considering equal heights.

### Test Case 5: Array with Increasing Heights
- **Container**: An array with increasing heights, e.g., [1, 2, 3, 4, 5].
- **Max Area**: Determined by the increasing pattern of heights.

### Test Case 6: Array with Decreasing Heights
- **Container**: An array with decreasing heights, e.g., [5, 4, 3, 2, 1].
- **Max Area**: Calculated considering the decreasing order of heights.

### Test Case 7: Array with Random Heights
- **Container**: An array with random heights, e.g., [1, 8, 6, 2, 5, 4, 8, 3, 7].
- **Max Area**: Evaluated based on the random heights arrangement.

### Test Case 8: A Large Array of Heights
- **Container**: A large array with 1000 elements of varying heights.
- **Max Area**: Computed for a large dataset to test algorithm efficiency.