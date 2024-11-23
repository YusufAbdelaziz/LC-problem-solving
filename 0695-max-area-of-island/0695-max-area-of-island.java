class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int rowsNum = grid.length;
        int colsNum = grid[0].length;

        for(int i = 0; i < rowsNum; i++) {
            for(int j = 0; j < colsNum; j++) {
                if(grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, calculateIslandArea(grid, i, j));
                }
            }
        }

        return maxArea;
    }

    private int calculateIslandArea(int[][] grid, int x, int y) {
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0) {
            return 0;
        }

        // Mark the current cell so you don't revisit it again.
        grid[x][y] = 0;

        return 1 + calculateIslandArea(grid, x + 1, y) + calculateIslandArea(grid, x, y + 1)
                    + calculateIslandArea(grid, x - 1, y) + calculateIslandArea(grid, x, y - 1);
    }
}