import java.util.ArrayList;
import java.util.List;

public class Vertex<T> {

    private final T data;

    private final List<Edge> edges;

    public Vertex(final T data) {
        this.data = data;
        this.edges = new ArrayList<>();
    }

    public void addEdge(final Vertex vertex, final Integer weight) {
        edges.add(new Edge(this, vertex, weight));
    }

    public void removeEdge(final Vertex vertex) {
        edges.removeIf(edge -> edge.destination().equals(vertex));
    }

    public T getData() {
        return this.data;
    }

    public List<Edge> getEdges() {
        return this.edges;
    }

    public String toString(final boolean showWeight) {
        StringBuilder value = new StringBuilder();

        if(this.edges.isEmpty())
            value.append(this.data).append(" ---> ");
        else {
            for(int i = 0; i < edges.size(); i++) {
                if (i == 0)
                    value.append(this.edges.get(i).start().data).append(" ---> ");
                value.append(this.edges.get(i).destination().data);
                if (showWeight)
                    value.append(" (").append(this.edges.get(i).weight()).append(")");
                if (i != this.edges.size() - 1)
                    value.append(", ");
            }
        }
        return value.toString();
    }
}
