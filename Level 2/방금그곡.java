import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        boolean check = false;
        Queue<Character> q = new LinkedList<>();
        for (int i = 0; i < skill.length(); i++) {
            q.add(skill.charAt(i));
        }
        Queue<Character> orig = new LinkedList<>(q);
        for (int i = 0; i < skill_trees.length; i++) {
            for (int j = 0; j < skill_trees[i].length(); j++) {
                if (q.peek() == skill_trees[i].charAt(j)) {
                    q.poll();
                    if (q.size() == 0) {
                        break;
                    }
                } else if (q.contains(skill_trees[i].charAt(j))) {
                    check = true;
                    break;
                }
            }
            if (!check) {
                answer++;
            }
            check = false;
            q = new LinkedList<>(orig);
        }
        return answer;
    }
}
