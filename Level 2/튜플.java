import java.util.*;
class Solution {
    public int[] solution(String s) {
        s = s.replaceAll("\\{", "");
        s = s.substring(0, s.length() - 2);
        String[] list = s.split("},");

        HashMap<Integer, ArrayList<Integer>> result = new HashMap<>();
        for (int i = 0; i < list.length; i++) {
            String[] toInt = list[i].split(",");
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int e = 0; e < toInt.length; e++) {
                tmp.add(Integer.parseInt(toInt[e]));
            }
            result.put(tmp.size() - 1, tmp);
        }

        ArrayList<Integer> alreadyIn = new ArrayList<>();
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                if (!alreadyIn.contains(result.get(i).get(j))) {
                    answer[i] = result.get(i).get(j);
                    alreadyIn.add(result.get(i).get(j));
                }
            }
        }

        return answer;
    }
}
