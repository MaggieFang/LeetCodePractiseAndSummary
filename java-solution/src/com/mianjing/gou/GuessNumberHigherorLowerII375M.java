package com.mianjing.gou;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/11/19
 * Talk is Cheap,Show me the Code.
 **/
public class GuessNumberHigherorLowerII375M {
    /**
     * when I guess x but x != y (y is the pick num)
     * then I will go to the left part of x or right part.
     * for guranttee, max(T[..,x-1],T[x+1,...])
     * and then we traverse 1 to n to get the min
     * MINMAX. the worst case to find the miminum loss.
     * T[i][j]  is the min money to pay from i ~ j;
     * T[1][n] is the result we want. so we try to find the worst of the left and right
     * max(T[....x-1],T[x+1,...]), so the result is (max(T[....x-1],T[x+1,...])+x
     * and we iterate from 1 to n for x, to find the MIN.
     * T[i,j] = Min(T[i,j],(max(T[....x-1],T[x+1,...])+x)   i <= x<= j
     * O(n^3)
     **/
    public int getMoneyAmount(int n) {
        int[][] T = new int[n + 1][n + 1];
        for (int i = 1; i < T.length; i++) {
            for (int j = 1; j < T.length; j++) {
                if (i >= j) {
                    T[i][j] = 0;
                } else {
                    T[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        dp(T, 1, n);
        return T[1][n];
    }

    public int dp(int[][] T, int s, int e) {
        if (s >= e) return 0;
        if (T[s][e] != Integer.MAX_VALUE) return T[s][e];
        for (int x = s; x <= e; x++) {
            T[s][e] = Math.min(T[s][e], x + Math.max(dp(T, s, x - 1), dp(T, x + 1, e)));
        }
        return T[s][e];
    }

    public int getMoneyAmount2(int n) {
        int[][] T = new int[n+1][n+1];
        for(int i = 1; i < T.length;i++){
            for(int j = 1; j < T.length;j++){
                if(i >= j) {
                    T[i][j] = 0;
                }else{
                    T[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for(int i = 1;i <= n;i++){
            for(int j = i+1;j <= n;j++){
                for(int x = i; x<=j;x++){
                    T[i][j] = Math.min(T[i][j],x+Math.max(T[i][x-1],x == n ? 0:T[x+1][j]));
                }
            }
        }
        return T[1][n];
    }
    public static void main(String[] args){
        GuessNumberHigherorLowerII375M t = new GuessNumberHigherorLowerII375M();
        System.out.println(t.getMoneyAmount2(3));
    }

}
