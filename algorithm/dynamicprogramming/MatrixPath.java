package io.wisoft.seminar.lecture.algorithm.dp;

public class MatrixPath {

  private static int[][] c = new int[4][4];
  private static int[][] d = new int[4][4];
  private static int[][] m = {{6, 7, 12, 5},
                              {5, 3, 11, 18},
                              {7, 17, 3, 3},
                              {8, 10, 14, 9}
  };

  private static int matrixPath(int[][] m, int[][] c, final int i, final int j) {
    int maxVal;
    if (i == 0 && j == 0) {
      c[i][j] = m[i][j];
    } else if (i == 0) {
      c[i][j] = m[i][j] + matrixPath(m, c, 0, j - 1);
      d[i][j] = 1;
    } else if (j == 0) {
      c[i][j] = m[i][j] + matrixPath(m, c, i - 1, 0);
      d[i][j] = 2;
    } else {
      maxVal = Math.max(matrixPath(m, c, i - 1, j), matrixPath(m, c, i, j - 1));
      c[i][j] = m[i][j] + maxVal ;
      if (maxVal == c[i][j - 1])
        d[i][j] = 1;
      else if (maxVal == c[i - 1][j])
        d[i][j] = 2;
    }
    return c[i][j];
  }

  private static void printMaxPath(final int i, final int j) {
    if (i == 0 && j == 0)
      System.out.print("최대 경로 : ");
    else if (d[i][j] == 1)
      printMaxPath(i, j - 1);
    else if (d[i][j] == 2)
      printMaxPath(i - 1, j);
    System.out.format("(%d, %d) ", i+1, j+1);
  }

  public static void main(String[] args) {
    int result = matrixPath(m, c, 3, 3);
    System.out.println("최대 값 : " + result);
    printMaxPath(3, 3);
  }

}
