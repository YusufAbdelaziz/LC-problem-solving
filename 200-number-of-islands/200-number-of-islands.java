class Solution {
    
    
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        
        int rows = grid.length;
        int landsNum = 0;
        int columns = grid[0].length;
        boolean [][] visited = new boolean[rows][columns];
        // We start apply DFS for each cell, but if a cell is already visited or equal
        // to 0, then there's no need to apply a DFS starting from that cell.
        for(int i = 0; i < rows ; i++){
            for(int j = 0 ; j < columns ; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    landsNum ++;
                    dfs(i, j, grid, visited);
                }
            }
        }
        
        return landsNum;
    }
    
    private void dfs(int row, int column, char[][] grid, boolean[][] visited){
        // If a cell exceeds the boundaries, then return.
        
        if(row < 0 || column < 0 || row >= grid.length || column >= grid[row].length)
            return;
        
        // If the cell is already visited or doesn't equal to 1 (land) then return.
        if(grid[row][column] == '0' || visited[row][column])
            return;
        
        // Otherwise, mark the current cell as a visited one.
        visited[row][column] = true;
        
        // Start traversing through the graph in horizontal and vertical directions.
        
        // Upwards
        dfs(row - 1, column, grid, visited);
        // Downwards
        dfs(row + 1, column, grid, visited);
        // Right
        dfs(row, column - 1, grid, visited);
        // Left
        dfs(row, column + 1, grid, visited);
        
    }
    
    
    
}