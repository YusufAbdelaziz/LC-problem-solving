class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] visitedIslands = new boolean[grid.length][grid[0].length];
        
        int numOfIslands = 0;
        
        for(int i = 0 ; i < grid.length ; i ++){
            for(int j = 0; j < grid[i].length ; j ++){
                if(!visitedIslands[i][j] && grid[i][j] == '1'){
                    numOfIslands++;
                    visitIslandsByDFS(i, j, visitedIslands, grid);
                }
            }
        }
        
        return numOfIslands;
    }
    
    private void visitIslandsByDFS(int i, int j, boolean[][] visitedIslands, char[][] grid){
        // Check if you've exceeded the limits (horizontally or vertically).
        if(i < 0 || i >= grid.length ||  j < 0 || j >= grid[i].length )
            return;
        
        // Check if it's a water or the island was being visited before.
        if(grid[i][j] != '1' || visitedIslands[i][j])
            return;
        
        
        visitedIslands[i][j] = true;
        
        visitIslandsByDFS(i - 1, j, visitedIslands, grid);
        visitIslandsByDFS(i + 1, j, visitedIslands, grid);
        visitIslandsByDFS(i, j - 1, visitedIslands, grid);
        visitIslandsByDFS(i, j + 1, visitedIslands, grid);
    }
}