package com.amazon;

import java.util.LinkedList;

public class DesignSnakeGame353M {
    /**
     * KEYPOINTS:
     * <p>
     * 由于蛇移动的过程的蛇头向前走一步，蛇尾也跟着往前，中间的躯体还在原来的位置，所以移动的结果就是，蛇头变到新位置，去掉蛇尾的位置即可
     * 所以在开头插入新头位置。然后判断是否吃到东西，不是的话去掉tail，吃到东西的话不需要remove，只len++，当前food index++，
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     * </code>
     * </pre>
     * TIME COMPLEXITY:
     * <p>
     * SPACE COMPLEXITY:
     * <p>
     **/
    int w;
    int h;
    int[][] food;
    LinkedList<Position> pos;
    int curFoodIdx;
    int len = 0;

    public DesignSnakeGame353M(int width, int height, int[][] food) {
        this.w = width;
        this.h = height;
        this.food = food;
        this.pos = new LinkedList<>();
        this.pos.add(new Position(0, 0));

    }

    public int move(String di) {
        Position head = new Position(pos.get(0));
        Position tail = pos.get(pos.size() - 1);
        if ("U".equals(di)) {
            head.x--;
        } else if ("D".equals(di)) {
            head.x++;
        } else if ("L".equals(di)) {
            head.y--;
        } else {
            head.y++;
        }
        if (head.x < 0 || head.x >= h || head.y < 0 || head.y >= w) {
            return -1;
        }
        // 还要考虑蛇头碰自己的情况

        pos.add(0, head);


        if (curFoodIdx < food.length && head.x == food[curFoodIdx][0] && head.y == food[curFoodIdx][1]) {
            len++;
            curFoodIdx++;
        } else {
            pos.remove(pos.size() - 1);
        }
        return len;

    }

    public static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Position(Position copy) {
            this.x = copy.x;
            this.y = copy.y;
        }
    }
}
