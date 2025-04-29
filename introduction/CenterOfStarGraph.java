// Given a Star Graph, find the center of the graph.

class CenterOfStarGraph{
    static int findCenter(int[][] edges){
        if(edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1]){
            return edges[0][0];
        }
        return edges[0][1];
    }

    public static void main(String[] args){
        int[][] edges = {{1, 2}, {2, 3}, {4, 2}};
        System.out.println(findCenter(edges));
        // Output: 2
    }
}