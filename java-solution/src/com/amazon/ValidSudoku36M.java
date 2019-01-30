package com.amazon;

import java.util.HashSet;
import java.util.Set;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 11/6/18
 * Talk is Cheap,Show me the Code.
 **/
public class ValidSudoku36M {
    public boolean isValidSudoku(char[][] board) {
        Set seen = new HashSet();
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                char number = board[i][j];
                if (number != '.')
                    if (!seen.add(number + " in row " + i) ||
                            !seen.add(number + " in column " + j) ||
                            !seen.add(number + " in block " + i / 3 + "-" + j / 3))
                        return false;
            }
        }
        return true;
    }
}
