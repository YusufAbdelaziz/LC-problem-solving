class Solution {

    private final int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public void solve(char[][] board) {
        int ROWS = board.length;
        int COLS = board[0].length;

        for (int i = 0; i < ROWS; i++) {
            if (board[i][0] == 'O') {
                captureRegion(i, 0, board);
            }

            if (board[i][COLS - 1] == 'O') {
                captureRegion(i, COLS - 1, board);
            }
        }

        for (int i = 0; i < COLS; i++) {
            if (board[0][i] == 'O') {
                captureRegion(0, i, board);
            }

            if (board[ROWS - 1][i] == 'O') {
                captureRegion(ROWS - 1, i, board);
            }
        }

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

    }

    private void captureRegion(int r, int c, char[][] board) {
        board[r][c] = '#';

        for (int[] direction : directions) {
            int newR = r + direction[0];
            int newC = c + direction[1];

            if (isValidTraverse(newR, newC, board)) {
                captureRegion(newR, newC, board);
            }
        }
    }

    private boolean isValidTraverse(int r, int c, char[][] board) {
        int ROWS = board.length;
        int COLS = board[0].length;
        return r < ROWS && c < COLS && r >= 0 && c >= 0 && board[r][c] == 'O';
    }
}