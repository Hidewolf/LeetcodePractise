class uniquePaths_62 {

  public static void main(String[] args) {
    uniquePaths_62 t = new uniquePaths_62();
    System.out.println(t.uniquePaths(7, 3));
  }

  public int uniquePaths(int m, int n) {
    int[][] o = new int[n][m];
    for (int i = 0; i < n; i++) {
      o[i][m - 1] = 1;
    }
    for (int i = 0; i < m; i++) {
      o[n - 1][i] = 1;
    }
    for (int i = 2; i <= n; i++) {
      for (int j = 2; j <= m; j++) {
        o[n-i][m-j]=o[n-i+1][m-j]+o[n-i][m-j+1];
      }
    }
    return o[0][0];
  }
}