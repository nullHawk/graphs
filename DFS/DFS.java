import java.util.*;

public class DFS {
    static void dfs(int current,ArrayList<Integer>[] graph, boolean[] visited){
        System.out.println(current);
        visited[current] = true;

        for(int i: graph[current]){
            if(!visited[i])
                dfs(i, graph, visited);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // nodes
        int e = sc.nextInt(); // edges

        // initialize graph (adjacency list formate)
        ArrayList<Integer>[] graph = new ArrayList[n+1];
        for(int i = 0; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        // input edges
        for(int i = 0; i < e; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }

        // initialize visited array
        boolean[] visited = new boolean[n];
        dfs(1, graph, visited);

    }
}
