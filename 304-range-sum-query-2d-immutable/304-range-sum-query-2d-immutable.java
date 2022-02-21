class NumMatrix {
    
    private int [][] expandedMatrix;
    
    public NumMatrix(int[][] matrix) {
        if(matrix == null) throw new IllegalArgumentException("A null is passed");
        if(matrix.length == 0) throw new RuntimeException("An empty array is passed");
        int row = matrix.length;
        int column = matrix[0].length;  
        expandedMatrix = new int[row + 1][column + 1];
        // Recall that the first row and first column are set to be 0s.
        for(int i = 1 ; i < expandedMatrix.length; i++){
            for(int j = 1; j < expandedMatrix[0].length ; j++){
                expandedMatrix[i][j] = expandedMatrix[i-1][j] + expandedMatrix[i][j-1] 
                    + matrix[i - 1][j-1] - expandedMatrix[i-1][j-1];
            }
        }
        
        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1 += 1;
        row2 += 1;
        col1 += 1;
        col2 += 1;
        
        return expandedMatrix[row2][col2] - expandedMatrix[row1 - 1][col2] -
            expandedMatrix[row2][col1-1] + expandedMatrix[row1 - 1][col1 - 1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */