package lesson7;

import hw7.GraphPathSearch;

public class DepthFirstPath extends GraphPathSearch {
    public DepthFirstPath(Graph g, int source) {
        super(g, source);
    }

    protected void search(Graph g, int v) {
        marked[v] = true;
        for (int w : g.getAdjList(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                search(g, w);
            }
        }
    }
}
