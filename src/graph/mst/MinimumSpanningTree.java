package graph.mst;

/**
 * 加权无向连通图的最小生成树
 */
public interface MinimumSpanningTree {

    Iterable<Edge> edges();

    double weight();
}
