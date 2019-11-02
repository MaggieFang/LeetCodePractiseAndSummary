package kongqichuang;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-11-01
 **/
public class Flatten2DVector251M {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * use two index, point to the row and current column
     * </p>
     * TIME COMPLEXITY:
     * SPACE COMPLEXITY:
     * </p>
     **/
    class Vector2D {
        int[][] v;
        int i;
        int j;

        public Vector2D(int[][] v) {
            this.v = v;
        }

        public int next() {
            if (hasNext()) {
                return v[i][j++];
            } else {
                return Integer.MIN_VALUE;
            }
        }

        public boolean hasNext() {
            while (i < v.length && j >= v[i].length) {//后面已经包含了某个元素是空[]情况了
                i++;
                j = 0;
            }
            return i < v.length;

        }
    }
}
