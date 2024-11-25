import java.util.AbstractMap;

class Solution {
    public int orangesRotting(int[][] grid) {
        // Stores a key/value pair where key is the x and value is the y coordinates.
        Queue<Map.Entry<Integer, Integer>> queue = new ArrayDeque<>();

        int minutes = -1;

        // Pick the first rotten orange and start moving from it.
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new AbstractMap.SimpleEntry<>(i, j));

                }
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                Map.Entry<Integer, Integer> current = queue.poll();
                int i = current.getKey();
                int j = current.getValue();

                addNeighbors(grid, i, j, queue);
            }
            minutes++;

        }

        // Check if we couldn't make all oranges rotten.
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return Math.max(minutes, 0);

    }

    private void addNeighbors(int[][] grid, int i, int j, Queue<Map.Entry<Integer, Integer>> queue) {
        int rowsNum = grid.length;
        int colsNums = grid[0].length;

        if (i - 1 >= 0 && checkNotRottenAndEmpty(i - 1, j, grid)) {
            queue.add(new AbstractMap.SimpleEntry<>(i - 1, j));
            grid[i - 1][j] = 2;
        }

        if (j - 1 >= 0 && checkNotRottenAndEmpty(i, j - 1, grid)) {
            queue.add(new AbstractMap.SimpleEntry<>(i, j - 1));
            grid[i][j - 1] = 2;

        }

        if (i + 1 < rowsNum && checkNotRottenAndEmpty(i + 1, j, grid)) {
            queue.add(new AbstractMap.SimpleEntry<>(i + 1, j));
            grid[i + 1][j] = 2;

        }

        if (j + 1 < colsNums && checkNotRottenAndEmpty(i, j + 1, grid)) {
            queue.add(new AbstractMap.SimpleEntry<>(i, j + 1));
            grid[i][j + 1] = 2;

        }
    }

    private boolean checkNotRottenAndEmpty(int i, int j, int[][] grid) {
        return grid[i][j] == 1;
    }
}