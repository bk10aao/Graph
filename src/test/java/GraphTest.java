public class GraphTest {

    private Graph testGraph;

    public GraphTest() {
        this.testGraph = new Graph(false, true);

        Vertex startNode = testGraph.addVertex("v0.0.0");
        Vertex v1 = testGraph.addVertex("v1.0.0");
        Vertex v2 = testGraph.addVertex("v2.0.0");

        Vertex v11 = testGraph.addVertex("v1.1.0");
        Vertex v12 = testGraph.addVertex("v1.2.0");
        Vertex v21 = testGraph.addVertex("v2.1.0");

        Vertex v111 = testGraph.addVertex("v1.1.1");
        Vertex v112 = testGraph.addVertex("v1.1.2");
        Vertex v121 = testGraph.addVertex("v1.2.1");
        Vertex v211 = testGraph.addVertex("v2.1.1");

        testGraph.addEdge(startNode, v1, null);
        testGraph.addEdge(startNode, v2, null);

        testGraph.addEdge(v1, v11, null);
        testGraph.addEdge(v1, v12, null);
        testGraph.addEdge(v2, v21, null);

        testGraph.addEdge(v11, v111, null);
        testGraph.addEdge(v11, v112, null);
        testGraph.addEdge(v12, v121, null);
        testGraph.addEdge(v21, v211, null);

        testGraph.addEdge(v211, v2, null);

        Graph testGraph = new Graph(true, true);
        Vertex a = testGraph.addVertex("A");
        Vertex b = testGraph.addVertex("B");
        Vertex c = testGraph.addVertex("C");
        Vertex d = testGraph.addVertex("D");
        Vertex e = testGraph.addVertex("E");
        Vertex f = testGraph.addVertex("F");
        Vertex g = testGraph.addVertex("G");

        testGraph.addEdge(a, c, 100);
        testGraph.addEdge(a, b, 3);
        testGraph.addEdge(a, d, 4);
        testGraph.addEdge(d, c, 3);
        testGraph.addEdge(d, e, 8);
        testGraph.addEdge(e, b, -2);
        testGraph.addEdge(e, f, 10);
        testGraph.addEdge(b, g, 9);
        testGraph.addEdge(e, g, -50);

        Dijkstra.print(Dijkstra.dijkstra(testGraph, e));
        Dijkstra.shortestPathBetween(testGraph, a, g);
    }

    public Vertex getStartingVertex() {
        return (Vertex)testGraph.getVertices().get(0);
    }

    public static void main(String[] args) {
        GraphTest graphTest = new GraphTest();
    }
}
