package com.amazon;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 11/27/18
 * Talk is Cheap,Show me the Code.
 **/
public class FloodFill733E {
    public int[][] floodFillSimpler(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0 || image[0].length == 0) {
            return image;
        }
        if (image[sr][sc] == newColor) { //important! otherwises stackoverflow
            return image;
        }
        dfs(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }

    public void dfs(int[][] image, int i, int j, int newColor, int num) {
        if (i < 0 || i >= image.length || j < 0 || j >= image[i].length || image[i][j] != num) {
            return;
        }

        image[i][j] = newColor;
        dfs(image, i, j - 1, newColor, num);
        dfs(image, i, j + 1, newColor, num);
        dfs(image, i - 1, j, newColor, num);
        dfs(image, i + 1, j, newColor, num);


    }


    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0 || image[0].length == 0) {
            return image;
        }
        boolean[][] visited = new boolean[image.length][image[0].length];
        dfs(image, sr, sc, newColor, visited, image[sr][sc]);
        return image;
    }

    public void dfs(int[][] image, int i, int j, int newColor, boolean[][] visited, int num) {
        if (i < 0 || i >= image.length || j < 0 || j >= image[i].length) {
            return;
        }

        if (num != image[i][j] || visited[i][j]) {
            return;
        }

        image[i][j] = newColor;
        visited[i][j] = true;
        dfs(image, i, j - 1, newColor, visited, num);
        dfs(image, i, j + 1, newColor, visited, num);
        dfs(image, i - 1, j, newColor, visited, num);
        dfs(image, i + 1, j, newColor, visited, num);
    }
}
