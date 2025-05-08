import java.util.*;

class BuildingTeams{
    static boolean isPossible = true;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int pupils = sc.nextInt();
        int friendships = sc.nextInt();
        
        ArrayList<Integer>[] graph = new ArrayList[pupils+1];
        int[] team = new int[pupils+1];

        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 1; i <= friendships; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }

        for(int i = 1; i <= pupils; i++){
            if(team[i] == 0){
                dfs(graph, team, i, 1);
            }
        }

        if (!isPossible) {
            System.out.println("IMPOSSIBLE");
        } else {
            for (int i = 1; i <= pupils; i++) {
                System.out.print(team[i] + " ");
            }
        }



    }

    static void dfs(ArrayList<Integer>[] graph, int[] team, int current, int currentTeam){
        team[current] = currentTeam;

        for(int i: graph[current]){
            if(team[i] == 0){
                dfs(graph, team, i, 3-currentTeam);
            }else if(team[i] == currentTeam){
                isPossible = false;
            }
        }
    }
}