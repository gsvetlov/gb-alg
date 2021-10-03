package hw7;

import lesson7.BreadthFirstPath;
import lesson7.DepthFirstPath;
import lesson7.Graph;

public class Main {
    public static void main(String[] args) {
        Graph g = init();
        GraphPathSearch bfp = new BreadthFirstPath(g, 0);
        GraphPathSearch dfp = new DepthFirstPath(g, 0);

        System.out.println("/// Breadth first ///");
        System.out.println(bfp.hasPathTo(3));
        System.out.println(bfp.pathTo(3));

        System.out.println("/// Depth first ///");
        System.out.println(dfp.hasPathTo(3));
        System.out.println(dfp.pathTo(3));

    }

    private static Graph init() {
        Graph g = new Graph(10);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(1, 5);
        g.addEdge(1, 6);
        g.addEdge(2, 5);
        g.addEdge(4, 6);
        g.addEdge(4, 5);
        g.addEdge(5, 3);
        return g;
    }

}
