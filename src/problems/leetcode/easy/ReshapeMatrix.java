package src.problems.leetcode.easy;

// 566

class ReshapeMatrix {
  public int[][] matrixReshape(int[][] mat, int r, int c) {
    int rows = mat.length;
    int columns = mat[0].length;
    if (rows * columns != c * r)
      return mat;

    int[][] newArr = new int[r][c];
    int columnNum = 0, rowNum = 0;

    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[i].length; j++) {
        newArr[rowNum][columnNum] = mat[i][j];
        columnNum++;
        if (columnNum > c) {
          columnNum = 0;
          rowNum++;
        }

      }
    }

    return newArr;
  }
}