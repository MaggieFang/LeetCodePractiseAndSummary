package recursion;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 11/14/18
 * Talk is Cheap,Show me the Code.
 **/

/**
 * It may be useful to write a separate wrapper function to do initialization
 * for a complex recursive function.
 */
public class Wrapper {

    public int[] getNs(int n) {
        int[] ans = new int[n == 0 ? 1 : n];
        doRecur(n, ans, 0);
        return ans;

    }

    public int doRecur(int n, int[] results, int level) {
        if (n > 1) {
            results[level] = doRecur(n - 1, results, level + 1);
            return results[level];
        } else {
            results[level] = 1;
            return results[level];
        }
    }


    public int binarySearch(int[] array, int target) {
        return binaryRecur(array, target, 0, array.length - 1);
    }

    public int binaryRecur(int[] A, int target, int low, int high) {
        int range = high - low;
        if (range < 0) {
            return -1;
        }
        int center = low + range / 2;
        if (A[center] == target) {
            return center;
        } else if (A[center] > target) {
            return binaryRecur(A, target, low, center - 1);
        } else {
            return binaryRecur(A, target, center + 1, high);
        }
    }

}
