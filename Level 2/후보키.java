import java.util.*;
class Solution {
    public int solution(String[][] relation) {
        int answer = 0;
        int pair = 0;
        for (int i = 0 ; i < relation[0].length; i++) {
            HashSet<Integer> store = new HashSet<>();
            int count = 0;
            pair = check(relation, i,  i,  store, count, false);
            answer += pair;
        }
        return answer;
    }

    public int check(String[][] relation, int start, int end, HashSet<Integer> store, int count, boolean found) {
        ArrayList<ArrayList<String>> checkList = new ArrayList<ArrayList<String>>();
        checkList = new ArrayList<ArrayList<String>>();
        
        for (int i = 0; i < relation.length; i++) {
            ArrayList<String> set = new ArrayList<String>();
            for (int j = start; j <= end; j++) {
                if (!store.contains(j)) {
                    set.add(relation[i][j]);
                }
            }
            if (!checkList.contains(set)) {
                checkList.add(set);
            } else {
                if (end < relation[0].length - 1) {
                    found = true;
                    end++;
                    return check(relation, start, end, store, count, found);
                } else {
                    return count;
                }
            }
        }


        if (checkList.size() == relation.length) {
            count++;
            if (found) {
                store.add(end);
                end++;
                if (end == relation[0].length) {
                    return count;
                }
                return check(relation, start, end, store, count, found);
            }
            return count;
        }
        return count;
    }

}
