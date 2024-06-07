import java.util.ArrayList;
import java.util.List;

public class Graph<T> {

    private final List<Vertex> vertices;
    private final boolean weighted;
    public boolean directed;

    public Graph(final boolean weighted, final boolean directed) {
        this.vertices = new ArrayList<>();
        this.weighted = weighted;
        this.directed = directed;
    }

    public Vertex addVertex(final String data) {
        Vertex vertex = new Vertex(data);
        vertices.add(vertex);
        return vertex;
    }

    public void addEdge(final Vertex source, final Vertex destination, Integer weight) {
        if(!weighted)
            weight = null;
        source.addEdge(destination, weight);
        if(!directed)
            destination.addEdge(source, weight);
    }

    public void removeEdge(final Vertex source, final Vertex destination) {
        source.removeEdge(destination);
        if(!directed)
            destination.removeEdge(source);
    }

    public void removeVertex(final Vertex vertex) {
        vertices.remove(vertex);
    }

    public Vertex getVertexByValue(final T value) {
        for(Vertex vertex : vertices)
            if (vertex.getData().equals(value))
                return vertex;
        return null;
    }

    public List<Vertex> getVertices() {
        return vertices;
    }

    public boolean isWeighted() {
        return weighted;
    }

    public boolean isDirected() {
        return directed;
    }

    public void print() {
        vertices.stream().map(vertex -> vertex.toString(isWeighted()))
                        .forEach(System.out::println);
    }
}
