import java.util.Arrays;

public class TestData {
  private static TestItem[] data = {
    new TestItem(
      new int[]{8, 4, 2, 5, 2},
      new int[]{2, 2, 4, 5, 8}
    )
  };

  public static int[] getInput(int testNumber) {
    return data[testNumber].input;
  }

  public static int[] getOutput(int testNumber) {
    return data[testNumber].output;
  }

  public static boolean checkResult(int[] dataToCheck, int testNumber) {
    if (Arrays.equals(dataToCheck, getOutput(testNumber))) {
      System.out.println("OK!");
      return true;
    }
    return false;
  }

  public static void printArray(int[] input) {
    System.out.println(Arrays.toString(input));
  }
}


class TestItem {
  int[] input;
  int[] output;

  public TestItem(int[] input, int[] output) {
    this.input = input;
    this.output = output;
  }

  public int[] getInput() {
    return input;
  }

  public void setInput(int[] input) {
    this.input = input;
  }

  public int[] getOutput() {
    return output;
  }

  public void setOutput(int[] output) {
    this.output = output;
  }
}
