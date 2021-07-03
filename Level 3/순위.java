import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] map = new int[n + 1][n + 1];

        for (int i = 0; i < results.length; i++) {
            map[results[i][0]][results[i][1]] = 1;
            map[results[i][1]][results[i][0]] = -1;
        }

        //fill map
        for (int i = 1; i <= n; i++) {
            ArrayList<Integer> lose = new ArrayList<>();
            ArrayList<Integer> win = new ArrayList<>();
            for (int j = 1; j <= n; j++) {
                if (map[i][j] == 1) win.add(j);
                else if (map[i][j] == -1) lose.add(j);
            }
            
            for (int j = 0; j < win.size(); j++) {
                for (int k = 0; k < lose.size(); k++) {
                    map[win.get(j)][lose.get(k)] = -1;
                    map[lose.get(k)][win.get(j)] = 1;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            int count = 1;
            for (int j = 1; j <= n; j++) {
                if (map[i][j] != 0) count++;
            }
            if (count == n) answer++;
        }
        return answer;
    }
}
