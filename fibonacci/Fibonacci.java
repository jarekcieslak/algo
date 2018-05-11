import java.util.Arrays;

class Fibinacci {

    public static long fibonacciMemoizedRecursion(int n, long[] memoArray) {
        long result;
        if (n == 1 || n == 2) { // if first fib numbers then we return 1;
            result = 1;
        } else if (memoArray[n] != -1) { // if we have cached response we return cached data;
            result = memoArray[n];
        } else { // compute it as usual using recursion
            result = fibonacciMemoizedRecursion(n - 2, memoArray) + fibonacciMemoizedRecursion(n - 1, memoArray);
            // remember the result for the future and return result
        }
        memoArray[n] = result;
        return result;
    }

    /**
     * Dynamic programming apporach using memoization
     *
     * @param n
     * @return
     */
    public static long fibonacciMemoizedRecursion(int n) {
        // Stores computed fib values
        long[] memoArray = new long[n + 1];
        Arrays.fill(memoArray, -1);

        // Initialize array
        memoArray[0] = 0;
        return fibonacciMemoizedRecursion(n, memoArray);
    }


    /**
     * Classic solutino using recursion
     *
     * @param n
     * @return
     */
    public static long fibRecursion(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fibRecursion(n - 1) + fibRecursion(n - 2);
        }
    }

    /**
     * Dynamic programming apporach (bottom up)
     *
     * @param n
     * @return
     */
    public static long fibBottomUp(int n) {
        // Stores computed fib values
        long[] memoArray = new long[n + 1];
        memoArray[0] = 0;
        memoArray[1] = 1;
        memoArray[2] = 1;
        for (int i = 2; i <= n; i++) {
            memoArray[i] = memoArray[i - 1] + memoArray[i - 2];
        }
        return memoArray[n];

    }

    public static void main(String[] args) {
        System.out.println(fibonacciMemoizedRecursion(20));
        System.out.println(fibBottomUp(20));
        System.out.println(fibRecursion(20));
    }
}