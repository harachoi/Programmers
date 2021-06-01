import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int loc = location, index = priorities.length - 1;
        Queue<Integer> q = new LinkedList<>();
        Stack<Boolean> s = new Stack<>();
        Queue<Boolean> check = new LinkedList<>();
        int count = 0;

        for (int i = 0; i < priorities.length; i++) {
            q.add(priorities[i]);
            if (i == location) {
                check.add(true);
            } else {
                check.add(false);
            }
        }
        Arrays.sort(priorities);

        while (!q.isEmpty()) {
            if (q.peek() == priorities[index]) {
                if (check.peek() == true) {
                    break;
                }
                q.poll();
                check.poll();
                index--;
                count++;
            } else {
                check.add(check.poll());
                q.add(q.poll());
            }

        }
        return count + 1;
    }
}
