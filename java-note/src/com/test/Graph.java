package com.test;

import java.util.LinkedList;
import java.util.List;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/9/18
 * Talk is Cheap,Show me the Code.
 **/
//https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/
public class Graph {
    private int v; // number of vertices.
    private LinkedList<Integer>[] adj;
    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * add an edge into the graph;
     *
     * @param v
     * @param w
     */
    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    public void DFSUtils(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + ",");
        for (int i = 0; i < adj[v].size(); i++) {
            int n = adj[v].get(i);
            if (!visited[n]) {
                DFSUtils(n, visited);
            }
        }
    }

    /**
     * Depth First Traversal (or Search) for a graph is similar to Depth First Traversal of a tree.
     * The only catch here is, unlike trees, graphs may contain cycles,
     * so we may come to the same node again. To avoid processing a node more than once,
     * we use a boolean visited array.
     * Time Complexity: O(V+E) where V is number of vertices in the graph and E is number of edges in the graph.
     *
     * @param vertice
     */
    public void DFS(int vertice) {
        boolean visited[] = new boolean[v];
        DFSUtils(vertice,visited);

        // Call the recursive helper function to print DFS traversal
        // starting from all vertices one by one
        // 覆盖disconnected的情况，这样才完全
        for (int i=0; i<v; ++i)
            if (!visited[i])
                DFSUtils(i, visited);

    }

    public void BFS(int vertice) {
        boolean visited[] = new boolean[v];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[vertice] = true;
        queue.add(vertice);
        while (!queue.isEmpty()) {
            vertice = queue.poll();
            System.out.print(vertice + ",");
            for (int i = 0; i < adj[vertice].size(); i++) {
                int n = adj[vertice].get(i);
                if (!visited[n]) {
                    queue.add(n);
                    visited[n] = true;
                }
            }
        }
    }


    // This function is a variation of DFSUytil() in
    // https://www.geeksforgeeks.org/archives/18212
    private boolean isCyclicUtil(int i, boolean[] visited,
                                 boolean[] recStack)
    {

        // Mark the current node as visited and
        // part of recursion stack
        if (recStack[i])
            return true;

        if (visited[i])
            return false;

        visited[i] = true;

        recStack[i] = true;
        List<Integer> children = adj[i];

        for (Integer c: children)
            if (isCyclicUtil(c, visited, recStack))
                return true;

        recStack[i] = false;

        return false;
    }


    // Returns true if the graph contains a
    // cycle, else false.
    // This function is a variation of DFS() in
    // https://www.geeksforgeeks.org/archives/18212
    private boolean isCyclic()
    {

        // Mark all the vertices as not visited and
        // not part of recursion stack
        boolean[] visited = new boolean[v];
        boolean[] recStack = new boolean[v];


        // Call the recursive helper function to
        // detect cycle in different DFS trees
        for (int i = 0; i < v; i++)
            if (isCyclicUtil(i, visited, recStack))
                return true;

        return false;
    }

    public static void main(String[] rags) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.DFS(2);
        System.out.println();
        g.BFS(2);
    }
}
