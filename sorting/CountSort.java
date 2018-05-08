import java.util.HashMap;
import java.util.Map;

public class CountSort {
  public static int[] sort(int[] data) {
    Map<Integer, Integer> ocurrences = new HashMap<>();


    // We count ocurrences of elements in the array and put them inside of HashMap
    int i = 0;
    while (i < data.length) {
      int el = data[i];
      try {
        int present = ocurrences.get(el);
        if (present > 0) {
          ocurrences.put(el, ++present);
        }
      } catch (NullPointerException exception) {
        ocurrences.put(el, 1);
      }
      i++;
    }

    // We have
    System.out.println(ocurrences.toString());
    int[] keys = ocurrences.keySet().stream().mapToInt(el -> el.intValue()).toArray();
    int[] vals = ocurrences.values().stream().mapToInt(el -> el.intValue()).toArray();
    int curIndex = 0;
    for (int j = 0; j < keys.length; j++) {
      int key = keys[j];
      int v = vals[j];
      for (int k = 0; k < v; k++) {
        data[curIndex] = key;
        curIndex++;
      }
    }


    return data;
  }

  public static void main(String[] args) {
    int[] myResult = sort(TestData.getInput(0));
    TestData.printArray(myResult);
    TestData.checkResult(myResult, 0);
  }
}
