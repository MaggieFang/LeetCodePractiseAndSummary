package com.doordash;

import java.util.Scanner;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-02-04
 * Talk is Cheap,Show me the Code.
 **/
public class Connected4 {
    static final int ROW = 7;
    static final int COL = 7;
    int count;
    int[][] panel;

    public static void main(String[] args) {
        Connected4 test = new Connected4();
        Scanner scanner = new Scanner(System.in);
        outer:
        while (true){
            while (true){
                System.out.println("player 1 input column:(0-"+(COL-1)+")");
                int c = scanner.nextInt();
                if(test.isPlayable(c)){
                    if(test.play(c,1)){
                        System.out.println("player 1 wins");
                        test.printPanel();
                        break outer;
                    }
                    break;
                }else {
                    System.out.println("column "+ c +" full, reinput");
                }
            }
            test.printPanel();
            if(test.isFull()){
                System.out.println("the panel full, you both sucks");
                break outer;
            }

            while (true){
                System.out.println("player 2 input column:(0-"+(COL-1)+")");
                int c = scanner.nextInt();
                if(test.isPlayable(c)){
                    if(test.play(c,2)){
                        System.out.println("player 2 wins");
                        test.printPanel();
                        break outer;
                    }
                    break;
                }else {
                    System.out.println("column "+ c +" full, reinput");
                }
            }
            test.printPanel();
            if(test.isFull()){
                System.out.println("the panel full, you both sucks");
                break outer;
            }
        }

    }

    public Connected4() {
        panel = new int[ROW][COL];
        count = 0;
    }

    public void printPanel() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                System.out.print(panel[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean isPlayable(int col) {
        return panel[0][col] == 0;
    }

    public boolean isFull() {
        return count == COL * ROW;
    }

    public boolean play(int col, int player) {
        int i = ROW - 1;
        for (; i >= 0; i--) {
            if (panel[i][col] == 0) {
                panel[i][col] = player;
                break;
            }
        }
        count++;
        return checkWin(i, col);

    }

    public boolean checkWin(int x, int y) {
        int i = y;
        int num = 0;
        // horizon
        while (i < COL && panel[x][y] == panel[x][i++]) {
            num++;
        }

        if (num >= 4) {
            return true;
        }

        i = y - 1;
        while (i >= 0 && panel[x][y] == panel[x][i--]) {
            num++;
        }
        if (num >= 4) {
            return true;
        }
        // vertical, no need to go up since we fill it from bottom
        num = 0;
        i = x;
        while (i < ROW && panel[x][y] == panel[i++][y]) {
            num++;
        }
        if (num >= 4) {
            return true;
        }

        //left-up
        num = 0;
        i = x;
        int j = y;
        while (i < ROW && j < COL && panel[x][y] == panel[i][j]) {
            num++;
            i++;
            j++;
        }
        if (num >= 4) {
            return true;
        }

        i = x - 1;
        j = y - 1;
        while (i >= 0 && j >= 0 && panel[x][y] == panel[i][j]) {
            num++;
            i--;
            j--;
        }
        if (num >= 4) {
            return true;
        }

        // right-up
        num = 0;
        i = x;
        j = y;
        while (i < ROW && j >= 0 && panel[x][y] == panel[i][j]) {
            num++;
            i++;
            j--;
        }
        i = x - 1;
        j = y + 1;
        while (i >= 0 && j < COL && panel[x][y] == panel[i][j]) {
            num++;
            i--;
            j++;
        }
        if (num >= 4) {
            return true;
        }
        return false;
    }

}
