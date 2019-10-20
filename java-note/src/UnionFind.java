/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-10-12
 **/
public class UnionFind {
    //https://blog.csdn.net/liujian20150808/article/details/50848646
    static final int N = 100;// example
    int[] pre = new int[N];

    /**
     * ind the root that x belong to
     *
     * @param x
     * @return root
     */
    int find(int x) {
        int r = x;
        while (pre[r] != r) { // 根结点的pre是自己，所以我们不断往上找，直到pre是自己，则找到了根
            r = pre[r];
        }
        //return r;//如果不做路径压缩，直接这里返回

        int i = x;
        while (i != r) { //路径压缩，所有人的pre都直接到root
            int tmp = pre[i];
            pre[i] = r;
            i = tmp;
        }
        return r;
    }

    /**
     * given two nodes, make them as one union. 先找到两个node各自的root，如果是不同root，
     * 只要将其中一个root的pre设置为另一个root，这样两个连通图就变成一个了
     * @param x
     * @param y
     */
    void join(int x, int y) {
        int rx = find(x);
        int ry = find(y);
        if(rx != ry){
            pre[ry] = rx;
        }
    }

}
