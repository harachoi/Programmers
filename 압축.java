import java.util.*;
class Solution {
    public int[] solution(String msg) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        ArrayList<Integer> list = new ArrayList<>();
        int count = 1;
        int index = 1;

        //Insert first letters
        for (char ch = 'A'; ch <= 'Z'; ++ch) {
            map.put(String.valueOf(ch), index++);
            count++;
        }

        for (int i = 0; i < msg.length(); i++) {
            String result = checkContain(map, msg.substring(i));
            list.add(map.get(result));
            if (i != msg.length() - 1) {
                if (i + result.length()  != msg.length()) {
                    String put = msg.substring(i, i + result.length() + 1);
                    map.put(put, count);
                }
            }
            count++;
            i += result.length() - 1;
        }
        int[] answer = list.stream().mapToInt(i -> i).toArray();
        return answer;
    }

    public String checkContain(HashMap<String, Integer> map, String subStr) {
        for (int i = subStr.length(); i >= 0; i--) {
            String check = subStr.substring(0, i);
            if (map.containsKey(check)) {
                return check;
            }
        }
        return "";
    }
}
