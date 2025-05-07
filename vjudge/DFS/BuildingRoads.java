import java.util.*;

class BuildingRoads{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] edges = new ArrayList[n+1];
        ArrayList<Integer> bridges = new ArrayList<>();
        boolean[] visited = new boolean[n+1];
        for(int i = 0; i <= n; i++){
            edges[i] = new ArrayList<>();
        }

        for(int i = 1; i <= m; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            edges[u].add(v);
            edges[v].add(u);
        }
        
        for(int i = 1; i <= n; i++){
            if(!visited[i]){
                bridges.add(i);
                dfs(edges, visited, i);
            }
        }

        System.out.println(bridges.size()-1);
        for(int i = 0; i < bridges.size()-1; i++){
            System.out.println(bridges.get(i) + " " + bridges.get(i+1));
        }

    }

    static void dfs(ArrayList<Integer>[] edges, boolean[] visited, int node){
        Stack<Integer> stack = new Stack<>();
        stack.push(node);
        visited[node] = true;

        while (!stack.isEmpty()) {
            int cur = stack.pop();
            for (int neighbor : edges[cur]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    stack.push(neighbor);
                }
            }
        }

    }
}