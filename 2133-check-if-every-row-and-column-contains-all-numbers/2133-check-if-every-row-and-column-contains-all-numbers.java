class Solution {
    public boolean checkValid(int[][] matrix) {
        Set<Integer> rowSet;
        Set<Integer> colSet;
        
        int n = matrix.length;
        for(int i = 0; i < n; i++) {
            rowSet = new HashSet<>();
            colSet = new HashSet<>();
            for(int j = 0; j < n; j++) {
                int rowNum = matrix[i][j];
                int colNum = matrix[j][i];
                
                if(rowSet.contains(rowNum)) return false;
                else rowSet.add(rowNum);
                
                if(colSet.contains(colNum)) return false;
                else colSet.add(colNum);
            
            }
        }
        return true;
    }
}