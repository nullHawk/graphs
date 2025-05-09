import java.util.*;

public class JourneyToTheMoon {
    static boolean[] visited;

    static int dfs(int node, ArrayList<ArrayList<Integer>> graph) {
        visited[node] = true;
        int size = 1;
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                size += dfs(neighbor, graph);
            }
        }
        return size;
    }

    static int journeyToMoon(int n, int[][] astronaut) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pair : astronaut) {
            int u = pair[0];
            int v = pair[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        visited = new boolean[n];
        List<Integer> countrySizes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int size = dfs(i, graph);
                countrySizes.add(size);
            }
        }

        long totalPairs = (long) n * (n - 1) / 2;
        long invalidPairs = 0;

        for (int size : countrySizes) {
            invalidPairs += (long) size * (size - 1) / 2;
        }

        return (int)(totalPairs - invalidPairs);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        int[][] astronaut = new int[p][2];

        for (int i = 0; i < p; i++) {
            astronaut[i][0] = sc.nextInt();
            astronaut[i][1] = sc.nextInt();
        }

        System.out.println(journeyToMoon(n, astronaut));
    }
}
