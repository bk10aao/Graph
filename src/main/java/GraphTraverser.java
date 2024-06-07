import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphTraverser {

    public static List<Vertex> depthFirstTraversal(final Vertex start, final ArrayList<Vertex> visitedVertices) {
        List<Vertex> visited = new ArrayList<>();
        return depthFirstTraversal(start, visitedVertices, visited);
    }

    private static List<Vertex> depthFirstTraversal(final Vertex start, final ArrayList<Vertex> visitedVertices, final List<Vertex> visited) {
        for (Object e: start.getEdges()) {
            Vertex neighbor = ((Edge) e).destination();
            if (!visitedVertices.contains(neighbor)) {
                visitedVertices.add(neighbor);
                visited.add(neighbor);
                GraphTraverser.depthFirstTraversal(neighbor, visitedVertices, visited);
            }
        }
        return visited;
    }

    public static List<Vertex> breadthFirstSearch(final Vertex start, final ArrayList<Vertex> visitedVertices) {
        List<Vertex> visited = new ArrayList<>();
        Queue<Vertex> visitQueue = new LinkedList();
        visitQueue.offer(start);
        while (!visitQueue.isEmpty()) {
            for (Object e: visitQueue.poll().getEdges()) {
                Vertex neighbor = ((Edge) e).destination();
                if (!visitedVertices.contains(neighbor)) {
                    visitedVertices.add(neighbor);
                    visited.add(neighbor);
                    visitQueue.offer(neighbor);
                }
                StringBuilder data = new StringBuilder();
                for(Vertex v : visitedVertices)
                    if(data.isEmpty()) data =
                            new StringBuilder(v.getData().toString());
                    else
                        data.append(" ---> ").append(v.getData());
            }
        }
        return visited;
    }

    public static void print(final List<Vertex> visited) {
        StringBuilder built = new StringBuilder(visited.get(0).getData().toString());
        for(int i = 1; i < visited.size(); i++)
            built.append(" ---> ").append(visited.get(i).getData());
        System.out.println(built);
    }
}
