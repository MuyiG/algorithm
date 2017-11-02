package graph.mst;

import java.util.ArrayList;
import java.util.List;

/**
 * 加权无向图
 */
public class EdgeWeightedGraph {

    List<List<Edge>> adjEdges;
    int edges;

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

    }

//    Iterable<Edge> adj(int v) {
//
//    }
//
//    Iterable<Edge> edges() {
//
//    }
//
//    public String toString() {
//
//    }
}
