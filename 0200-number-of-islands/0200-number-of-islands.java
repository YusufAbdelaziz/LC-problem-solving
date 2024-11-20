class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int rowNums = grid.length;
        int colNums = grid[0].length;

        for(int i = 0; i < rowNums; i++) {
            for(int j = 0; j < colNums; j++) {
                if(grid[i][j] == '1' ) {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }


        return count;
    }

    private void dfs(char[][] grid, int x, int y) {
        int rowNums = grid.length;
        int colNums = grid[0].length;
        if(x < 0 || y < 0 || x >= rowNums || y >= colNums || grid[x][y] == '0') {
            return;
        }
       

        grid[x][y] = '0';  
        dfs(grid, x + 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x, y - 1);
        dfs(grid, x - 1, y);

    }
}