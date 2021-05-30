import java.util.ArrayList;
class Solution {
  static boolean[][] check;
  static int[][] copy;
  static int maxSizeOfOneArea, numberOfArea, temp_Area, copy_m, copy_n;

  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {1, 0, -1, 0};
  public int[] solution(int m, int n, int[][] picture) {
      check = new boolean[m][n];
      copy = new int[m][n];
      copy_m = m;
      copy_n = n;
      numberOfArea = maxSizeOfOneArea = 0;

      for(int i = 0; i < m; i++) {
          for(int j = 0; j < n; j++) {
              copy[i][j] = picture[i][j];
              if(picture[i][j] == 0) check[i][j] = true;
          }
      }

      for(int x = 0; x < m; x++) {
          for(int y = 0; y < n; y++) {
              if(copy[x][y] != 0 && !check[x][y]) {
                  temp_Area = 0;
                  dfs(x, y);
                  numberOfArea++;
                  if(temp_Area > maxSizeOfOneArea) maxSizeOfOneArea = temp_Area;
              }
          }
      }

      int[] answer = {numberOfArea, maxSizeOfOneArea};
      return answer;
  }
  static void dfs(int x, int y) {
      check[x][y] = true;
      temp_Area++;

      for(int z = 0; z < 4; z++) {
          int temp_x = x + dx[z];
          int temp_y = y + dy[z];

          if(0 <= temp_x && temp_x < copy_m && 0 <= temp_y && temp_y < copy_n) {
              if(copy[temp_x][temp_y] == copy[x][y] && !check[temp_x][temp_y]) dfs(temp_x, temp_y);
          }
      }
  }
}
