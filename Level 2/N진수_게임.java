import java.util.*;
class Solution {
  public String solution(int n, int t, int m, int p) {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i <= t * m; ++i) {
          sb.append(Integer.toString(i, n).toUpperCase());
      }
      // System.out.println(sb.toString());
      StringBuilder ans = new StringBuilder();
      for (int i = p - 1, j = 0; j < t; i+= m, ++j) {
          ans.append(sb.charAt(i));
      }
      // System.out.println(ans.toString());
      return ans.toString();
  }
}
