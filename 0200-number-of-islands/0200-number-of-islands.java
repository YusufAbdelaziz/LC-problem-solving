class Solution {
    public int numIslands(char[][] grid) {
        int numIslands = 0;
        boolean[][] marked = new boolean[grid.length][grid[0].length];
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(!marked[i][j] && grid[i][j] != '0') {
                    numIslands++;
                    dfs(marked, grid, i, j);
                }
            }
        }
        
        return numIslands;
    }
    
    
    private void dfs(boolean[][] marked, char[][] grid, int i, int j) {
        if(i >= grid.length || i < 0 || j < 0 || j >= grid[i].length) {
            return;
        }
        
        if(grid[i][j] == '0' || marked[i][j]) {
            return;
        }        
        
        
        
        marked[i][j] = true;
        
        dfs(marked, grid, i + 1, j);
        dfs(marked, grid, i - 1, j);
        dfs(marked, grid, i, j + 1);
        dfs(marked, grid, i, j - 1);

    }
}