package com.amazon;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 11/4/18
 * Talk is Cheap,Show me the Code.
 **/
public class Search2DMatrix240M {

    /**
     * KEYPOINTS:
     * <p>
     *  get the [topest][rightest] number,
     *    if it > target. we can discard the colum.
     *    if it < target, we can discard the row.
     *    else return true.
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY:  O(n)
     * <p>
     * SPACE COMPLEXITY: O(1)
     * <p>
    **/
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0){
            return false;
        }

        int m= matrix.length;
        int n = matrix[0].length;

        int i = 0;
        int j = n -1;
        while(i < m && j >=0){
            int num = matrix[i][j];
            if(num == target){
                return true;
            }else if(num > target){
                j--;
            }else{
                i++;
            }
        }
        return false;
    }


    public void main(String[] ag){

    }
}
