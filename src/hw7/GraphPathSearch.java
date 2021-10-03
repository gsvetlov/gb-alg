package hw7;

import java.util.LinkedList;
import java.util.List;
import lesson7.Graph;

public abstract class GraphPathSearch {
    protected boolean[] marked;
    protected int[] edgeTo;
    protected int source;

    public GraphPathSearch(Graph g, int source) {
        this.source = source;
        edgeTo = new int[g.getVertexCount()];
        marked = new boolean[g.getVertexCount()];
        search(g, source);
    }

    protected abstract void search(Graph g, int source);

    public boolean hasPathTo(int dist) {
        return marked[dist];
    }

    public List<Integer> pathTo(int dist) {
        if (!hasPathTo(dist)) {
            return null;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        int vertex = dist;
        while (vertex != source) {
            stack.push(vertex);
            vertex = edgeTo[vertex];
        }
        return stack;
    }


}
