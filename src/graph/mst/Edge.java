package graph.mst;

/**
 * 加权无向图的边模型
 */
public class Edge implements Comparable<Edge> {

    private final int v;
    private final int w;
    private final double weight;


    Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    double weight() {
        return weight;
    }

    int either() {
        return v;
    }

    int other(int v) {
        if (this.v == v) {
            return w;
        } else if (this.w == v) {
            return v;
        } else {
            throw new RuntimeException("Inconsistent edge");
        }
    }

    @Override
    public int compareTo(Edge o) {
        if (this.weight > o.weight) {
            return 1;
        } else if (this.weight < o.weight) {
            return -1;
        } else {
            return 0;
        }
    }

    public String toString() {
        return String.format("%d-%d %.2f", v, w, weight);
    }
}
