package graph.mst;

import java.util.ArrayList;
import java.util.List;

/**
 * 加权无向图
 */
public class EdgeWeightedGraph {

    private List<List<Edge>> adjEdges; // 邻接表 表示法
    private int edges;

    EdgeWeightedGraph(int V) {
        adjEdges = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adjEdges.add(new ArrayList<>());
        }
    }

    int V() {
        return adjEdges.size();
    }

    int E() {
        return edges;
    }

    void addEdge(Edge edge) {
        int v = edge.either();
        int w = edge.other(v);
        adjEdges.get(v).add(edge);
        adjEdges.get(w).add(edge);
        edges++;
    }

    Iterable<Edge> adj(int v) {
        if (v <= 0 || v > adjEdges.size()) {
            throw new IllegalArgumentException();
        }
        return adjEdges.get(v);
    }

    Iterable<Edge> edges() {
        List<Edge> result = new ArrayList<>();
        for (int i = 0; i < adjEdges.size(); i++) {
            for (Edge edge : adjEdges.get(i)) {
                // 比较巧妙地去重，而不必遍历result
                if (edge.other(i) > i) {
                    result.add(edge);
                }
            }
        }
        return result;
    }

}
