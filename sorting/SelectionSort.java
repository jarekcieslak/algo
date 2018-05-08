/**
 * Divide and conquer algorithm.
 * <p>
 * Iterative solution.
 * input: 8, 4, 2, 5, 2
 * 1. We select smallest element in the array (2)
 * 2. We change place with first element. Now we have   2, 4, 8, 5, 2
 * 3. We repeat the process for smaller array ->        2,     (4, 8, 5, 2)
 * 2, 2,  (4, 8, 5)
 * 2, 2, 4,  (8, 5)
 * 2, 2, 4, 5,  (8)
 * 2, 2, 4, 5, 8
 * <p>
 * <p>
 * <p>
 * <p>
 * Complexity = O(n2),
 * Sorts in place
 * Other quadratic sorting alghoritms = bubble sort, insertion sort
 */
class SelectionSort {

    public static int[] sort(int[] data) {

        for (int i = 0; i < data.length; i++) {
            // Set global minimum to first element, and scan the rest
            int min = i;

            // Find global minimum
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < data[min]) {
                    min = j;
                }
            }

            // swap elements and solve reduced subproblem (i++)
            int temp = data[i];
            data[i] = data[min];
            data[min] = temp;

        }
        return data;
    }

    public static void main(String[] args) {
        int[] myResult = sort(TestData.getInput(0));
        TestData.printArray(myResult);
        TestData.checkResult(myResult, 0);
    }
}