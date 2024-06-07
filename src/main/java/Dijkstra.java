import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {

    public static Dictionary[] dijkstra(final Graph g, final Vertex startingVertex) {
        Dictionary<Object, Integer> distances = new Hashtable<>();
        Dictionary<Object, Vertex> previous = new Hashtable<>();
        PriorityQueue<QueueObject> queue = new PriorityQueue<>();

        queue.add(new QueueObject(startingVertex, 0));

        for (Object v: g.getVertices()) {
            Vertex vertex = (Vertex)v;
            if (vertex != startingVertex)
                distances.put(vertex.getData(), Integer.MAX_VALUE);
            previous.put(vertex.getData(), new Vertex("Null"));
        }

        distances.put(startingVertex.getData(), 0);

        while (!queue.isEmpty()) {
            QueueObject current = queue.poll();
            for (Object e: current.vertex.getEdges()) {
                Edge edge = (Edge)e;
                Integer alternative = distances.get(current.vertex.getData()) + edge.weight();
                Object neighborValue = edge.destination().getData();
                if (alternative < distances.get(neighborValue)) {
                    distances.put(neighborValue, alternative);
                    previous.put(neighborValue, current.vertex);
                    queue.add(new QueueObject(edge.destination(), distances.get(neighborValue)));
                }
            }
        }
        return new Dictionary[]{distances, previous};
    }

    public static void shortestPathBetween(final Graph g, final Vertex startingVertex, final Vertex targetVertex) {
        Dictionary[] dijkstraDictionaries = dijkstra(g, startingVertex);
        Dictionary distances = dijkstraDictionaries[0];
        Dictionary previous = dijkstraDictionaries[1];

        Integer distance = (Integer) distances.get(targetVertex.getData());
        System.out.println("Shortest Distance between " + startingVertex.getData() + " and " + targetVertex.getData());
        System.out.println(distance);

        List<Vertex> path = new ArrayList<>();
        Vertex v = targetVertex;

        while (v.getData() != "Null") {
            path.add(0, v);
            v = (Vertex) previous.get(v.getData());
        }
        System.out.println("Shortest Path");
        path.stream().map(Vertex::getData).forEach(System.out::println);
    }

    public static void print(final Dictionary[] dictionary) {
        System.out.println("Distances:\n");
        for (Enumeration keys = dictionary[0].keys(); keys.hasMoreElements();){
            String nextKey = keys.nextElement().toString();
            System.out.println(nextKey + ": " + dictionary[0].get(nextKey));
        }
        System.out.println("\nPrevious:\n");
        for (Enumeration keys = dictionary[1].keys(); keys.hasMoreElements();) {
            String nextKey = keys.nextElement().toString();
            Vertex nextVertex = (Vertex) dictionary[1].get(nextKey);
            System.out.println(nextKey + ": " + nextVertex.getData());
        }
    }

    private static class QueueObject implements Comparable<QueueObject> {
        private final Vertex vertex;
        private final int priority;

        public QueueObject(final Vertex v, final int p){
            this.vertex = v;
            this.priority = p;
        }

        @Override
        public int compareTo(final QueueObject o) {
            return Integer.compare(this.priority, o.priority);
        }
    }
}