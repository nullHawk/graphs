class FloodFill{
    public static void main(String[] args){
        int[][] image = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };
        int sr = 1, sc = 1, color = 2;

        FloodFill floodFill = new FloodFill();
        int[][] result = floodFill.floodFill(image, sr, sc, color);

        System.out.println("Flood-filled image:");
        for (int[] row : result) {
            for (int pixel : row) {
            System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }

    static void dfs(int[][]image, int starting_color, int color, int i, int  j){
        if (i<0 || j <0 || i==image.length || j == image[0].length){
            return;
        }
        if(image[i][j] == starting_color){
            image[i][j] = color;
            dfs(image, starting_color, color, i-1, j);
            dfs(image, starting_color, color, i+1, j);
            dfs(image, starting_color, color, i, j-1);
            dfs(image, starting_color, color, i, j+1);
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int starting_color = image[sr][sc];

        if(starting_color == color){
            return image;
        }

        dfs(image, starting_color, color, sr, sc);
        return image;
    }


}