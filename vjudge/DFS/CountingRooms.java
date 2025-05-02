import java.util.Scanner;

class CountingRooms{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        char[][] map = new char[n][m];
        boolean[][] visited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            String line = sc.nextLine();
            map[i] = line.toCharArray();
        }
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!visited[i][j] && map[i][j] == '.'){
                    dfs(map, visited, i, j, n, m);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    static void dfs(char[][] map, boolean[][] visited, int currI, int currJ, int n, int m){
        if(currI < 0 || currI >= n || currJ < 0 || currJ >= m || map[currI][currJ] == '#' || visited[currI][currJ]){
            return;
        }
        visited[currI][currJ] = true;
        dfs(map, visited, currI+1, currJ, n, m);
        dfs(map, visited, currI-1, currJ, n, m);
        dfs(map, visited, currI, currJ-1, n, m);
        dfs(map, visited, currI, currJ+1, n, m);
    }
}