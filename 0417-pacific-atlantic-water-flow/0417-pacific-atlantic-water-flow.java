class Solution {

    private int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length;
        int COLS = heights[0].length;

        boolean[][] pac = new boolean[ROWS][COLS];
        boolean[][] atl = new boolean[ROWS][COLS];

        List<List<Integer>> sol = new ArrayList<>();

        for (int c = 0; c < COLS; c++) {
            dfs(0, c, pac, heights);
            dfs(ROWS - 1, c, atl, heights);
        }

        for (int r = 0; r < ROWS; r++) {
            dfs(r, 0, pac, heights);
            dfs(r, COLS - 1, atl, heights);
        }

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (pac[r][c] && atl[r][c]) {
                    sol.add(Arrays.asList(r, c));
                }
            }
        }

        return sol;
    }

    public void dfs(int r, int c, boolean[][] ocean, int[][] heights) {
        ocean[r][c] = true;

        for (int[] d : directions) {
            int nr = r + d[0], nc = c + d[1];

            // Notice that !ocean[nr][nc] makes sure that we didn't visit this node before.
            if (isInBounds(nr, nc, heights.length, heights[0].length) && !ocean[nr][nc] &&
                    checkPredicate(r, c, nr, nc, heights)) {
                dfs(nr, nc, ocean, heights);
            }
        }
    }

    public boolean isInBounds(int r, int c, int ROWS, int COLS) {
        return r >= 0 && c >= 0 && r < ROWS && c < COLS;
    }

    public boolean checkPredicate(int r, int c, int nr, int nc, int[][] heights) {
        return heights[nr][nc] >= heights[r][c];
    }
}