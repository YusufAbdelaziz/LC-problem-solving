class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> rowSet;
        Set<Character> colSet;
        
        for(int i = 0; i < 9; i++) {
            rowSet = new HashSet<>();
            colSet = new HashSet<>();
            
            for(int j = 0; j < 9; j++) {
                char rowChar = board[i][j];
                char colChar = board[j][i];
                
                if(rowChar != '.') {
                    if(rowSet.contains(rowChar)) return false;
                    else rowSet.add(rowChar);
                }
                
                if(colChar != '.') {
                    if(colSet.contains(colChar)) return false;
                    else colSet.add(colChar);
                }
            }
        }
        
        // Now we need to check each square or block. We can divide the 9 * 9 grid
        // into 3 * 3 block.
        
        // Note that first block index is (0, 0) where as the second is (0, 1), the third is (0, 2) and so on.
        for(int i = 0; i < 9 ; i += 3) {
            for(int j = 0; j < 9; j += 3 ){
                if(!checkBlock(i, j, board)) return false;
            }
        }
        
        return true;
        
    }
    
    private boolean checkBlock(int blockStartX, int blockStartY, char[][] board) {
        // Keep tracks of elements in the block.
        Set<Character> blockSet = new HashSet<>();
        
        int blockEndX = blockStartX + 3;
        int blockEndY = blockStartY + 3;
        
        for(int i = blockStartX; i < blockEndX; i++) {
            
            for(int j = blockStartY; j < blockEndY; j++) {
                
                if(board[i][j] == '.') continue;
                
                if(blockSet.contains(board[i][j])) return false;
                
                else blockSet.add(board[i][j]);
            }
        }
        
        return true;
    }
}