package com.mianjing.google;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/11/19
 * Talk is Cheap,Show me the Code.
 **/
public class PrintMatrixZigzag {
    static void printZigZag(int a[][]){
        int row = a.length;
        int col = a[0].length;
        int curRow = 0;
        while (curRow < row){
            if(curRow % 2 == 0){
                for(int i = 0; i < col;i++){
                    System.out.println(a[curRow][i]);
                }

            }else {
                for(int i = col-1; i >= 0;i--){
                    System.out.println(a[curRow][i]);
                }

            }
            curRow++;
        }
    }

    public static void main(String[] args)
    {



        int mat[][] = { {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}};

        printZigZag(mat);
    }
}
