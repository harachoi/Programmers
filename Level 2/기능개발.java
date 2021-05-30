import java.util.*;
class Solution {
   public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> resultList = new ArrayList<>();
        Queue<Integer> qu = new LinkedList<>();
        int tmp;
        for (int i = 0; i < progresses.length; i++) {
            tmp = 100 - progresses[i];
            int result = tmp / speeds[i];
            if (tmp % speeds[i] != 0) {
                result++;
            }
            qu.add(result);
        }

        int count = 0;
        tmp = qu.poll();
        int max = tmp;
        count++;
        while (true) {
            if (qu.isEmpty()) {
                resultList.add(count);
                break;
            }
            if (tmp < qu.peek() &&  max < qu.peek()) {
                resultList.add(count);
                tmp = qu.poll();
                max = tmp;
                count = 1;
            } else {
                count++;
                tmp = qu.poll();
            }
        }
        return resultList.stream().mapToInt(i -> i).toArray();
    }
}
