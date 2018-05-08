
import java.util.Arrays;

/**
 * Divide and conquer alghoritm.
 * <p>
 * input: 7,2,5,3,7,13,1,6
 * We solve it by divide and conquer algorithm using recursion.
 * Recursive condition (if input array is of size 1 then just return it)
 * 1. We calculate mid element, mid = (low + high) / 2 = 4, which is 3.
 * 2. We split array to two smaller ones (7,2,5,3) and 7,13,1,6
 * 3. We sort arrays in a similar manner and get the result (2,3,5,7) and (1,6,7,13)
 * 4. We merge the results in a following way
 * - we compare first element of array a1 and a2 and put the smaller one in resulting array
 * - result = [1]  a1=[2,3,5,7] a2=[6,7,13]
 * - result = [1,2] a1=[3,5,7] a2=[6,7,13]
 * - result = [1,2,3] a1=[5,7] a2=[6,7,13]
 * ...
 * - result = [1,2,3,5,6,7,13]
 * <p>
 * Complexity = O(nlogn)
 */

public class MergeSort {

  public static int[] sort(int[] data, int left, int right) {
    int[] testArr = Arrays.copyOfRange(data, left, right);
    if (testArr.length == 1) {
      return data;
    } else {
      // Divide and conquer
      // divide to two smaller arrays. Keeps dividing until we get arrays of size one
      // Once we reach that point we start merging arrays back
      int mid = (left + right) / 2;
      sort(data, left, mid);
      sort(data, mid, right);

      // Merge
      merge(data, left, mid, right);
    }

    return data;
  }

  public static void merge(int[] data, int low, int mid, int high) {
    int[] leftPart = Arrays.copyOfRange(data, low, mid);
    int[] rightPart = Arrays.copyOfRange(data, mid, high);

    int currentIndex = low;
    int lIndex = 0, rIndex = 0;

    while (lIndex != leftPart.length && rIndex != rightPart.length) {
      int lItem = leftPart[lIndex];
      int rItem = rightPart[rIndex];
      if (lItem < rItem) {
        data[currentIndex] = lItem;
        currentIndex++;
        lIndex++;
      } else if (lItem >= rItem) {
        data[currentIndex] = rItem;
        currentIndex++;
        rIndex++;
      }
    }

    // Copy rest of the array
    // If one of the L or R arrays is empty append it
    if (lIndex == leftPart.length) {
      for (int i = rIndex; i < rightPart.length; i++) {
        data[currentIndex] = rightPart[i];
        currentIndex++;
      }
    } else if (rIndex == rightPart.length) {
      for (int i = lIndex; i < leftPart.length; i++) {
        data[currentIndex] = leftPart[i];
        currentIndex++;
      }
    }
  }

  public static void main(String[] args) {
    int[] test = {2, 5, 7, 13};
    int[] test1 = TestData.getInput(0);
    int[] test2 = {7, 2, 5, 3, 7, 13, 1, 6};
    System.out.println(Arrays.toString(sort(test2, 0, test2.length)));
  }
}
