package com.google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 12/29/18
 * Talk is Cheap,Show me the Code.
 **/
public class EvaluateDivision399M {
    /**
     * a->b,2
     * b->a,1/2
     * b->c,3
     * c->b, 1/3
     * a/c
     * a->b->c,2*3 = 6
     * 1 buildGrahp graph : Map<String,Map<Stirng,double>> ("a",("b",2)),
     * 2. iterate queries. to do dfs. if cannot be found -1.
     * Take a / b = 2, b / c = 3, a / c = ? for example,
     * a --2--> b --3--> c
     * We simply find a path using DFS from node a to node c and multiply the weights of edges passed, i.e. 2 * 3 = 6.
     * Please note that during DFS,
     * Rejection case should be checked before accepting case.
     **/

    public double[] calcEquation(String[][] e, double[] v, String[][] q) {
        HashMap<String, HashMap<String, Double>> graph = buildGraph(e, v);
        double[] result = new double[q.length];
        for (int i = 0; i < q.length; i++) {
            String s = q[i][0];
            String end = q[i][1];
            result[i] = findWeight(graph, s, end, new HashSet<String>());
        }
        return result;

    }

    public double findWeight(HashMap<String, HashMap<String, Double>> graph, String s, String e,
                             HashSet<String> visited) {

        if (!graph.containsKey(e) || !graph.containsKey(s)) {
            return -1.0;
        }

        if (s.equals(e)) {
            return 1.0;
        }

        visited.add(s);
        HashMap<String, Double> neibor = graph.get(s);
        for (Map.Entry<String, Double> n : neibor.entrySet()) {
            String v = n.getKey();
            if (!visited.contains(v)) {
                double r = findWeight(graph, v, e, visited); //!!! get the next value, * curValue
                if (r != -1.0) {
                    return n.getValue() * r;
                }
            }
        }
        return -1.0;

    }

    public HashMap<String, HashMap<String, Double>> buildGraph(String[][] e, double[] weight) {
        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < e.length; i++) {
            String u = e[i][0];
            String v = e[i][1];
            double w = weight[i];
            HashMap<String, Double> tmp = graph.getOrDefault(u, new HashMap<String, Double>());
            tmp.put(v, w);
            graph.put(u, tmp);
            tmp = graph.getOrDefault(v, new HashMap<String, Double>());
            tmp.put(u, 1 / w);
            graph.put(v, tmp);
        }
        return graph;

    }
}
