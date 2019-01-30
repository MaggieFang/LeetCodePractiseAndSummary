import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/14/19
 * Talk is Cheap,Show me the Code.
 **/
public class Dijkstra {
    public int[] dijkstra(int graph[][], int src) {
        int V = graph.length;
        final int[] dis = new int[V];
        for (int i = 0; i < dis.length; i++) {
            dis[i] = Integer.MAX_VALUE;
        }
        dis[src] = 0;
        boolean[] visited = new boolean[dis.length];

        for (int cnt = 0; cnt < V - 1; cnt++) {
            int u = pickMin(dis, visited);
            visited[u] = true;
            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 &&  dis[u] + graph[u][v] < dis[v]) {
                    dis[v] = dis[u] + graph[u][v];
                }
            }

        }
        return dis;
    }

    public int pickMin(int[] dis, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int ans = -1;
        for (int i = 0; i < dis.length; i++) {
            if (!visited[i] && dis[i] < min) {
                min = dis[i];
                ans = i;
            }
        }
        return ans;
    }

    public void print(int[] dis) {
        for (int i = 0; i < dis.length; i++)
            System.out.println(i + " tt " + dis[i]);
    }

    public static void main(String[] args) {
        /* Let us create the example graph discussed above */
        int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        Dijkstra t = new Dijkstra();
        t.print(t.dijkstra(graph, 0));

    }
}
