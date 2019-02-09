package com.mianjing.quora;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-02-08
 * Talk is cheap,show me the Code.
 **/
public class SubsetSum {
    //https://www.geeksforgeeks.org/subset-sum-problem-dp-25/

    /**
     * 给一个list，[1, 1, 4, 6, 8]，给一个target = 13，问是否有subset的和为13。
     * Clarification:
     * if they are non-negative? 这个一定要问，不然dp index都负了
     * </p>
     * Keypoints:
     * isSubsetSum(set, n, sum) = isSubsetSum(set, n-1, sum) || isSubsetSum(set, n-1, sum-set[n-1]), exclude or include the last one
     * Base Cases:
     * isSubsetSum(set, n, sum) = false, if sum > 0 and n == 0
     * isSubsetSum(set, n, sum) = true, if sum == 0
     * </p>
     * TIME COMPLEXITY:  exponential
     * SPACE COMPLEXITY:
     * </p>
     **/
    public boolean isSubsetSum(int[] set, int n, int sum) {
        if (sum == 0) {
            return true;
        }
        if (n == 0 && sum != 0) {
            return false;
        }
        if (set[n - 1] > sum) {
            return isSubsetSum(set, n - 1, sum);
        }
        return isSubsetSum(set, n - 1, sum) || isSubsetSum(set, n - 1, sum - set[n - 1]);
    }

    //dp,c[i][j] means sum = i,length = j; c[i][j] will be true if there is a subset of set[0..j-1] with sum equal to i., otherwise false
    //we return c[sum][n],
    //base case c[0][j] = true, c[i][0] = false;//sum not 0 but set is empty
    // c[i][j]= c[i][j-1] || c[i-set[j-1]][j-1]
    //O(sum*n).
    public boolean isSubsetSum(int[] set,int sum){
        boolean[][] C = new boolean[sum+1][set.length+1];
        for(int i = 0; i <= set.length;i++){
            C[0][i] = true;
        }
        for(int i = 1; i <= sum;i++){
            C[i][0] = false;
        }

        for(int i = 1; i <= sum;i++){
            for(int j = 1; j <= set.length;j++){
                if(i - set[j-1] >= 0){
                    C[i][j] = C[i][j-1] || C[i-set[j-1]][j-1];
                }else {
                    C[i][j] = C[i][j-1];
                }
            }
        }
        return C[sum][set.length];
    }

    public static void main(String[] args){
      SubsetSum test = new SubsetSum();
        int set[] = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        System.out.println(test.isSubsetSum(set,sum));
    }

}
