// Given an integer n representing number of vertices. Find out how many undirected graphs (not necessarily connected) can be constructed out of a given n number of vertices.
class NumOfGraphs{
    static int numOfGraphs(int vertices){
        return 2 << (vertices * (vertices - 1) / 2);
    }
    
    public static void main(String[] args){
        int vertices = 3;
        System.out.println(numOfGraphs(vertices));
    }
}